package emresahin.di

import emresahin.service.CharactersService
import emresahin.service.QuotesService
import org.koin.dsl.module
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val appModule = module {
    single { (uri: String) -> KMongo.createClient(uri).coroutine }
    single { (client: CoroutineClient) -> CharactersService(client) }
    single { (client: CoroutineClient) -> QuotesService(client) }
}