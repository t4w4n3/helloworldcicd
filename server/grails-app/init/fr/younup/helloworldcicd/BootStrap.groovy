package fr.younup.helloworldcicd

class BootStrap {

    def init = { servletContext ->
        new HelloWorld(message: "Hello World").save()
    }
    def destroy = {
    }
}
