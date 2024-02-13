package hse.cs.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val data: String
)

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respond(
                Response(data = "Test data")
            )
        }
    }
}
