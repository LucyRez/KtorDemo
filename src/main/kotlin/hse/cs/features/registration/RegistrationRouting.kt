package hse.cs.features.registration

import hse.cs.features.login.LoginModelRequest
import hse.cs.features.login.LoginModelResponse
import hse.cs.storage.Storage
import hse.cs.storage.TokenStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Application.configureRegistrationRouting() {
    routing {
        post("/register") {
            val req = call.receive<RegistrationModelRequest>()
            if (!Storage.userList.map {
                    it.email
                }.contains(req.email)) {
                Storage.userList.add(req)
                call.respond(HttpStatusCode.OK)
            }

            call.respond(HttpStatusCode.BadRequest, "The user already exists")
        }
    }
}