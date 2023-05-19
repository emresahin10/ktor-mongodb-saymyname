package emresahin.routes

import emresahin.data.models.saymyname.Quote
import emresahin.data.models.saymyname.toQuoteDto
import emresahin.data.response.ErrorResponse
import emresahin.service.QuotesService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.quoteRoute(service: QuotesService) {

    route("/quotes") {
        get {
            call.respond(HttpStatusCode.OK, service.findAllQuotes().map(Quote::toQuoteDto))
        }

        get("/{quoteId}") {
            service.findQuoteById(call.parameters["quoteId"].toString())
                ?.let { quote -> call.respond(HttpStatusCode.OK, quote.toQuoteDto()) }
                ?: call.respond(HttpStatusCode.NotFound, ErrorResponse.NOT_FOUND_RESPONSE)
        }

        get("/random") {
            call.respond(HttpStatusCode.OK, service.randomQuote().toQuoteDto())
        }
    }
}
