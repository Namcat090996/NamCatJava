package vn.com.stanford.je0824.bookstore.model;

public class HelloWorldService {

    private HelloWorld helloWorld;

    public HelloWorldService() {
        this.helloWorld = new StrutsHelloWorld();
    }

    public void sayHello() {
        helloWorld.sayHello();
    }

}
