package ai.nexo.sla

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContactFunctionalSpec extends Specification {

    @Shared
    RESTClient client

    @LocalServerPort
    int port;

    def setup() {
        client = new RESTClient("http://localhost:${port}/contacts")
        client.contentType = ContentType.JSON
    }

    @Unroll
    def "Create contact success type:#type value:#value"() {
        given:
            def qualquer = "coisa"

        when:
            def result = client.post(body: [value: value, type: type])

        then:
            result?.data?.id != null
            result?.data?.value == value
            result?.data?.type == expectedType

        where:
            type    | value                 | expectedType
            "eMaIl" | "teste@teste.com.br"  | "email"
            "EMAIL" | "teste@teste.com.br"  | "email"
            "Email" | "teste@teste.com.br"  | "email"
            "email" | "teste2@teste.com.br" | "email"
            "phone" | "555-5555"            | "phone"

    }

    @Unroll
    def "Create contact fail"() {

        when:
            def result = client.post(body: [title: title])

        then:
            def e = thrown(Exception)
            e.statusCode == 400

        where:
            title      | _
            "Titulo"   | _
            "zzz"      | _
            "asdf1234" | _

    }

}