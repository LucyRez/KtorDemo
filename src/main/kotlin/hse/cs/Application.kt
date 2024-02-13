package hse.cs

import hse.cs.features.login.configureLoginRouting
import hse.cs.features.registration.configureRegistrationRouting
import hse.cs.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
    configureLoginRouting()
    configureSerialization()
    configureRegistrationRouting()
}
