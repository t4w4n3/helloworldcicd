package fr.younup.helloworldcicd

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class HelloWorldControllerSpec extends Specification implements ControllerUnitTest<HelloWorldController>, DataTest {

    def setup() {
        mockDomain(HelloWorld)
        new BootStrap().init.call()
    }

    def cleanup() {
    }

    void "Le get du CRUD renvoi un HelloWorld"() {
        given:
        params.id = 1

        when:
        controller.show()

        then:
        response.json['message'] == "Hello World"
    }
}