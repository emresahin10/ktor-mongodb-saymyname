package emresahin.plugins

import emresahin.repository.CharactersRepository
import emresahin.routes.characterRoute
import emresahin.service.CharactersService
import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.koin.core.parameter.parametersOf
import org.koin.ktor.ext.inject
import org.litote.kmongo.coroutine.CoroutineClient

fun Application.configureRouting() {
    val dbAdmin = System.getenv("MONGO_USER")
    val mongoPW = System.getenv("MONGO_PW")
    val dbUri = System.getenv("MONGO_DB_URI")
    val dbName = "ktor-mongodb-saymyname"
    val uri = "mongodb+srv://$dbAdmin:$mongoPW@$dbName.$dbUri"

    val coroutineClient by inject<CoroutineClient> {
        parametersOf(uri)
    }
    val repository by inject<CharactersRepository> {
        parametersOf(coroutineClient)
    }
    val service by inject<CharactersService> {
        parametersOf(repository)
    }

    routing {
        characterRoute(service)
    }
}
