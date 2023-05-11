package emresahin

import emresahin.service.CharactersService
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Before

class ApplicationTest {

    @MockK
    lateinit var repository: CharactersService



    @Before
    fun setup() {
        MockKAnnotations.init(this)

    }


}
