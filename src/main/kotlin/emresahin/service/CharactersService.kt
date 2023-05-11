package emresahin.service

import emresahin.data.models.saymyname.Character
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.eq

class CharactersService(private val coroutineClient: CoroutineClient) {
    private val dbName = System.getenv("MONGO_DB_NAME")
    private fun database() = coroutineClient.getDatabase(dbName)
    private val collection = database().getCollection<Character>("characters")

    suspend fun findAllCharacters(): List<Character> = collection.find().toList()

    suspend fun findCharacterById(charId: String): Character? {
        return collection.findOne(Character::charId eq charId)
    }

}