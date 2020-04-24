package fr.younup.helloworldcicd

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

@Integration
@Rollback
class HelloWorldIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Le get du CRUD renvoi un HelloWorld"() {
        expect:
        HelloWorld.findByMessageIsNotNull().message == "Hello World"
    }
}
