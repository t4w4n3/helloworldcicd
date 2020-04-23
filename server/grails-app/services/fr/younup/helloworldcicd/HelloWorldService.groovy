package fr.younup.helloworldcicd

import grails.gorm.services.Service

@Service(HelloWorld)
interface HelloWorldService {

    HelloWorld get(Serializable id)

    List<HelloWorld> list(Map args)

    Long count()

    void delete(Serializable id)

    HelloWorld save(HelloWorld helloWorld)

}