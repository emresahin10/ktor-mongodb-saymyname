package emresahin.routes

import emresahin.data.response.BaseResponse
import emresahin.data.response.ErrorResponse
import emresahin.service.CharactersService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.characterRoute(service: CharactersService) {

    route("/characters") {
        get {
            service.findAll()
            call.respond(HttpStatusCode.OK, BaseResponse(service.findAll()))
        }

        get("/{charId}") {
            val character = service.findOne(call.parameters["charId"] ?: "").let { charId ->
                charId.ifEmpty {
                    call.respond(HttpStatusCode.NotFound, ErrorResponse.NOT_FOUND_RESPONSE)
                    return@get
                }
            }
            call.respond(HttpStatusCode.OK, BaseResponse(data = character))
        }
    }

}
