package com.springreactive.tutorial

/* The greeting object will be serialized as JSON by the RESTful service */
class Greeting {
    var message: String? = null

    constructor(message: String?) {
        this.message = message
    }

    override fun toString(): String {
        return "Greeting{" +
            "message='" + message + '\'' +
            '}'
    }
}
