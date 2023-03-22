package emresahin.di

import emresahin.repository.CharactersRepository
import emresahin.service.CharactersService
import org.koin.dsl.module
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val appModule = module {
    single { (uri: String) -> KMongo.createClient(uri).coroutine }
    single { (client: CoroutineClient) -> CharactersRepository(client) }
    single { (repository: CharactersRepository) -> CharactersService(repository) }
}