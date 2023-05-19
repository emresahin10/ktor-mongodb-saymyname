package emresahin.data.models.saymyname

import org.bson.codecs.pojo.annotations.BsonId

data class Quote(
    @BsonId val _id: String? = null,
    val quoteId: String,
    val quote: String,
    val author: String,
    val series: String,
)

fun Quote.toQuoteDto(): QuoteDto = QuoteDto(
    quoteId = this.quoteId,
    quote = this.quote,
    author = this.author,
    series = this.series,
)