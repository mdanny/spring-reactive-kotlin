package com.springreactive.tutorial

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TutorialApplication

fun main(args: Array<String>) {
    val context = runApplication<TutorialApplication>(*args)
    val greetingClient: GreetingClient = context.getBean(GreetingClient::class.java)
    println(
        ">> message = " +
            greetingClient.getMessage().block()
    )
}
