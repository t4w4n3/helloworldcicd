package fr.younup.helloworldcicd

import grails.compiler.GrailsCompileStatic
import grails.rest.RestfulController

@GrailsCompileStatic
class HelloWorldController extends RestfulController {
    static responseFormats = ['json']

    HelloWorldController() {
        super(HelloWorld)
    }
}
