package fr.younup.helloworldcicd

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HelloWorldServiceSpec extends Specification {

    HelloWorldService helloWorldService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new HelloWorld(...).save(flush: true, failOnError: true)
        //new HelloWorld(...).save(flush: true, failOnError: true)
        //HelloWorld helloWorld = new HelloWorld(...).save(flush: true, failOnError: true)
        //new HelloWorld(...).save(flush: true, failOnError: true)
        //new HelloWorld(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //helloWorld.id
    }

    void "test get"() {
        setupData()

        expect:
        helloWorldService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<HelloWorld> helloWorldList = helloWorldService.list(max: 2, offset: 2)

        then:
        helloWorldList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        helloWorldService.count() == 5
    }

    void "test delete"() {
        Long helloWorldId = setupData()

        expect:
        helloWorldService.count() == 5

        when:
        helloWorldService.delete(helloWorldId)
        sessionFactory.currentSession.flush()

        then:
        helloWorldService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        HelloWorld helloWorld = new HelloWorld()
        helloWorldService.save(helloWorld)

        then:
        helloWorld.id != null
    }
}
