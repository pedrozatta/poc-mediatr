package ai.nexo.sla

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasicFunctionalSpec extends Specification {

    @Shared
    RESTClient client

    @LocalServerPort
    int port;

    def setup() {
        client = new RESTClient("http://localhost:${port}/")
        client.contentType = ContentType.JSON
    }

    @Unroll
    def "health Success userId: #userId"() {

        when:
            def result = client.get(path: "actuator/health", headers: ["userId": userId])

        then:
            result != null
            result.data.status == "UP"

        where:
            userId     | _
            null       | _
            "zzz"      | _
            "asdf1234" | _

    }

}