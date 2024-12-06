package io.github.rubenquadros.vibesync.home

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform