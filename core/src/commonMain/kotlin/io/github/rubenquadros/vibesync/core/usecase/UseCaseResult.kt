package io.github.rubenquadros.vibesync.core.usecase

sealed interface UseCaseResult<out DATA> {
    data class Success<DATA>(val data: DATA): UseCaseResult<DATA>

    data object Error: UseCaseResult<Nothing>

    data object Unknown: UseCaseResult<Nothing>
}