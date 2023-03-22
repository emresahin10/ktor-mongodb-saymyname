package emresahin.data.models.saymyname

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    val charId: String? = null,
    val name: String? = null,
    val birthday:String? = null,
    val img: String? = null,
    val status: String? = null,
    val nickname: String? = null,
    val portrayed: String? = null,
    val category: String? = null,
)

fun CharacterDto.toCharacter(): Character = Character(
    charId = this.charId.orEmpty(),
    name = this.name.orEmpty(),
    birthday = this.birthday.orEmpty(),
    img = this.img.orEmpty(),
    status = this.status.orEmpty(),
    nickname = this.nickname.orEmpty(),
    portrayed = this.portrayed.orEmpty(),
    category = this.category.orEmpty(),
)
