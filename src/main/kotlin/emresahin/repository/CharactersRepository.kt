package emresahin.repository

import emresahin.data.models.saymyname.Character
import emresahin.data.models.saymyname.CharacterDto
import emresahin.data.models.saymyname.toCharacterDto
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.eq

class CharactersRepository(private val coroutineClient: CoroutineClient) {

    private fun collection() = coroutineClient.getDatabase("ktor-mongodb-saymyname").getCollection<Character>("characters")

    suspend fun findAllCharacters(): List<CharacterDto> = collection().find().toList().map(Character::toCharacterDto)

    suspend fun findOneCharacter(charId: String): List<CharacterDto> {
        return collection().find(CharacterDto::charId eq charId).toList().map(Character::toCharacterDto)
    }

}