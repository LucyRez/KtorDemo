package hse.cs.features.login

import hse.cs.plugins.Response
import hse.cs.storage.Storage
import hse.cs.storage.TokenStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID

fun Application.configureLoginRouting() {
    routing {
        post("/login") {
            val req = call.receive<LoginModelRequest>()
            val tmp = Storage.userList.firstOrNull {
                it.login == req.login
            }

            if (tmp != null && tmp.password == req.password) {
                if (Storage.userList.map {
                        it.login
                    }.contains(req.login)) {
                    val token = UUID.randomUUID().toString()
                    Storage.tokenList.add(TokenStorage(token, req.login))
                    call.respond(LoginModelResponse(token = token))
                }
            }

            call.respond(HttpStatusCode.BadRequest, "The user does not exist")
        }
    }
}