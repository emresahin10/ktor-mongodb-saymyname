package emresahin

import emresahin.plugins.configureRouting
import emresahin.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.netty.*
import org.koin.ktor.plugin.Koin

fun main(args: Array<String>): Unit = EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {

    install(Koin) {
        modules(emresahin.di.appModule)
    }

    configureSerialization()
    configureRouting()
}
