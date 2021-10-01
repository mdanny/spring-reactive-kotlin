package com.springreactive.tutorial

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

/* In the Spring Reactive approach, we use a handler to handle the request and create a response */
@Component
class GreetingHandler {
    fun hello(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(Greeting("Hello, Spring with Kotlin!")))
    }
}
