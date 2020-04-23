package fr.younup.helloworldcicd

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class HelloWorldController {

    static scaffold = HelloWorld

    HelloWorldService helloWorldService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond helloWorldService.list(params), model:[helloWorldCount: helloWorldService.count()]
    }

    def show(Long id) {
        respond helloWorldService.get(id)
    }

    @Transactional
    def save(HelloWorld helloWorld) {
        if (helloWorld == null) {
            render status: NOT_FOUND
            return
        }
        if (helloWorld.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond helloWorld.errors
            return
        }

        try {
            helloWorldService.save(helloWorld)
        } catch (ValidationException e) {
            respond helloWorld.errors
            return
        }

        respond helloWorld, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(HelloWorld helloWorld) {
        if (helloWorld == null) {
            render status: NOT_FOUND
            return
        }
        if (helloWorld.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond helloWorld.errors
            return
        }

        try {
            helloWorldService.save(helloWorld)
        } catch (ValidationException e) {
            respond helloWorld.errors
            return
        }

        respond helloWorld, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        helloWorldService.delete(id)

        render status: NO_CONTENT
    }
}
