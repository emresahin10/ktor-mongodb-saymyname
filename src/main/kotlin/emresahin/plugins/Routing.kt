package emresahin.plugins

import emresahin.service.CharactersService
import emresahin.routes.characterRoute
import emresahin.routes.homeRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.core.parameter.parametersOf
import org.koin.ktor.ext.inject
import org.litote.kmongo.coroutine.CoroutineClient

fun Application.configureRouting() {
    val dbAdmin = System.getenv("MONGO_USER")
    val mongoPW = System.getenv("MONGO_PW")
    val dbUri = System.getenv("MONGO_DB_URI")
    val dbName = System.getenv("MONGO_DB_NAME")
    val uri = "mongodb+srv://$dbAdmin:$mongoPW@$dbName.$dbUri"

    val coroutineClient by inject<CoroutineClient> {
        parametersOf(uri)
    }
    val service by inject<CharactersService> {
        parametersOf(coroutineClient)
    }

    routing {
        homeRoute()
        characterRoute(service)
    }
}
