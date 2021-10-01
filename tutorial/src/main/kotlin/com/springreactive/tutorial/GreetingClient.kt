package com.springreactive.tutorial

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

/* The Spring RestTemplate class is, by nature, blocking. Consequently, we do not want to use it in a
 reactive application. For reactive applications, Spring offers the WebClient class, which is non-blocking.
  We use a WebClient-based implementation to consume our RESTful service */
@Component
class GreetingClient(builder: WebClient.Builder) {
    private val client: WebClient

    fun getMessage(): Mono<String> {
        return client.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Greeting::class.java)
            .mapNotNull(Greeting::message)
    }

    // Spring Boot auto-configures a `WebClient.Builder` instance with nice defaults and customizations.
    // We can use it to create a dedicated `WebClient` for our component.
    init {
        client = builder.baseUrl("http://localhost:8080").build()
    }
}
