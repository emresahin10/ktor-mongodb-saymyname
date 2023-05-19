package emresahin.data.models.saymyname

import kotlinx.serialization.Serializable

@Serializable
data class QuoteDto(
    val quoteId: String? = null,
    val quote: String? = null,
    val author: String? = null,
    val series: String? = null,
)

fun QuoteDto.toQuote(): Quote = Quote(
    quoteId = this.quoteId.orEmpty(),
    quote = this.quote.orEmpty(),
    author = this.author.orEmpty(),
    series = this.series.orEmpty(),
)
