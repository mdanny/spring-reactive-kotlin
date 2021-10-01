package com.springreactive.tutorial

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.EntityExchangeResult
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingRouterTest(@Autowired val webTestClient: WebTestClient) {
    @Test
    fun testHello() {
        webTestClient // Create a GET request to test an endpoint
            .get().uri("/hello")
            .accept(MediaType.APPLICATION_JSON)
            .exchange() // and use the dedicated DSL to test assertions against the response
            .expectStatus().isOk
            .expectBody<Greeting>().consumeWith { consumer: EntityExchangeResult<Greeting> ->
                assertThat(
                    consumer.responseBody?.message
                ).isEqualTo("Hello, Spring with Kotlin!")
            }
    }
}
