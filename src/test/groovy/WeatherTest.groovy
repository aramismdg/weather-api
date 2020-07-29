import com.teco.weatherapi.controllers.WeatherController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class WeatherTest extends Specification{

    @Autowired (required = false)
    private WeatherController weatherController

    def "when context is loaded then all expected beans are created"() {
        expect: "the WebController is created"
        weatherController
    }
}
