package fr.younup.helloworldcicd


import grails.rest.RestfulController

class HelloWorldController extends RestfulController {
    static responseFormats = ['json']

    HelloWorldController() {
        super(HelloWorld)
    }
}
