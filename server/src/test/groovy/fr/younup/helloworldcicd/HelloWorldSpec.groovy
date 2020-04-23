package fr.younup.helloworldcicd

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class HelloWorldSpec extends Specification implements DomainUnitTest<HelloWorld> {

    def setup() {
        new BootStrap().init()
    }

    def cleanup() {
    }

    void "There is one hello world with a valid message"() {
        when:
        def helloWorld = HelloWorld.findByMessageNotIsEmpty()

        then:
        helloWorld != null
        helloWorld.message == "Hello World"
    }
}
