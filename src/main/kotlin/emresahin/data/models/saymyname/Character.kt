package emresahin.data.models.saymyname

import org.bson.codecs.pojo.annotations.BsonId

data class Character(
    @BsonId val _id: String? = null,
    val charId: String,
    val name: String,
    val birthday: String,
    val img: String,
    val status: String,
    val nickname: String,
    val portrayed: String,
    val category: String,
)

fun Character.toCharacterDto(): CharacterDto = CharacterDto(
    charId = this.charId,
    name = this.name,
    birthday = this.birthday,
    img = this.img,
    status = this.status,
    nickname = this.nickname,
    portrayed = this.portrayed,
    category = this.category,
)
