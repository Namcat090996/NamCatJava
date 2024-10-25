import vn.com.stanford.je0824.bookstore.model.HelloWorld;
import vn.com.stanford.je0824.bookstore.model.HelloWorldService;
import vn.com.stanford.je0824.bookstore.model.SpringHelloWorld;

public class Main {
    public static void main(String[] args) {

        HelloWorld helloWorld = new SpringHelloWorld();

        HelloWorldService hello = new HelloWorldService();

        hello.sayHello();

    }
}
