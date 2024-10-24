package vn.com.stanford.je0824.bookstore.model;

import sun.jvm.hotspot.HelloWorld;

public class HelloWorldService {

    private IHanhDong helloWorld;

    public HelloWorldService() {
        this.helloWorld = new StrutsHelloWorld();
    }
}
