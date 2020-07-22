package ai.nexo.sla

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjectFunctionalSpec extends Specification {

    @Shared
    RESTClient client

    @LocalServerPort
    int port;

    def setup() {
        client = new RESTClient("http://localhost:${port}/projects")
        client.contentType = ContentType.JSON
    }

    @Unroll
    def "Create project success title: '#title'"() {

        when:
            def result = client.post(body: [title: title])

        then:
            result?.data?.id != null
            result?.data?.title == title

        where:
            title      | _
            "Titulo"   | _
            "zzz"      | _
            "asdf1234" | _

    }

}