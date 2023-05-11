package emresahin.routes

import emresahin.data.models.saymyname.Character
import emresahin.data.models.saymyname.toCharacterDto
import emresahin.data.response.ErrorResponse
import emresahin.service.CharactersService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.characterRoute(service: CharactersService) {

    route("/characters") {
        get {
            call.respond(HttpStatusCode.OK, service.findAllCharacters().map(Character::toCharacterDto))
        }

        get("/{charId}") {
            service.findCharacterById(call.parameters["charId"].toString())
                ?.let { character -> call.respond(HttpStatusCode.OK, character.toCharacterDto()) }
                ?: call.respond(HttpStatusCode.NotFound, ErrorResponse.NOT_FOUND_RESPONSE)
        }
    }

}
