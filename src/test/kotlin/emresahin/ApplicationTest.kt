package emresahin

import emresahin.repository.CharactersRepository
import emresahin.service.CharactersService
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Before

class ApplicationTest {

    @MockK
    lateinit var repository: CharactersRepository

    lateinit var service: CharactersService

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        service = CharactersService(repository)
    }


}
