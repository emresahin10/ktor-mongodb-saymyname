package emresahin.service

import emresahin.data.models.saymyname.Quote
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.eq

class QuotesService(private val coroutineClient: CoroutineClient) {
    private val dbName = System.getenv("MONGO_DB_NAME")

    private val collection = database().getCollection<Quote>("quotes")
    private fun database() = coroutineClient.getDatabase(dbName)

    suspend fun findAllQuotes(): List<Quote> = collection.find().toList()

    suspend fun findQuoteById(quoteId: String): Quote? {
        return collection.findOne(Quote::quoteId eq quoteId)
    }

    suspend fun randomQuote(): Quote = findAllQuotes().random()

}