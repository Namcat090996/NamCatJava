package vn.com.stanford.je0824.bookstore.model;

import java.util.List;

public class SpringHelloWorld implements HelloWorld{
    @Override
    public void sayHello() {
        System.out.println("Say Hello World");
    }

    @Override
    public void keu() {
        System.out.println("Con cac");
    }
}
