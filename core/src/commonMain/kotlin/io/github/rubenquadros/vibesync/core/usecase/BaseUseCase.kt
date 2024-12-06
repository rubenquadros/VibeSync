package io.github.rubenquadros.vibesync.core.usecase

import io.github.rubenquadros.vibesync.core.api.ApiException
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

abstract class BaseUseCase<REQUEST, RESPONSE>(
    open val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend operator fun invoke(request: REQUEST): UseCaseResult<RESPONSE> {
        return runCatching {
            withContext(dispatcher) {
                UseCaseResult.Success(execute(request))
            }
        }.getOrElse { exception: Throwable ->
            when (exception) {
                is CancellationException -> {
                    throw exception
                }
                is ApiException -> {
                    UseCaseResult.Error
                }
                else -> {
                    UseCaseResult.Unknown
                }
            }
        }
    }

    abstract suspend fun execute(request: REQUEST): RESPONSE
}