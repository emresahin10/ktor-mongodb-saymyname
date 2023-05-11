package emresahin.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.homeRoute() {

    get("/") {
        call.respondText("This is the home page of the API.\n" +
                "try /characters for the characters.\n" +
                "try /characters/{charId} for a specific character."
        )
    }

}