package emresahin.service

import emresahin.data.models.saymyname.CharacterDto
import emresahin.repository.CharactersRepository

class CharactersService(private val repository: CharactersRepository) {

    suspend fun findAll(): List<CharacterDto> = repository.findAllCharacters()

    suspend fun findOne(charId: String) = repository.findOneCharacter(charId)

}