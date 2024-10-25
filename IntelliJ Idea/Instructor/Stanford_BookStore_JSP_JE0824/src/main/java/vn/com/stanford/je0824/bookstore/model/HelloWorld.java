package vn.com.stanford.je0824.bookstore.model;

public interface HelloWorld {
    String mauLong = "yellow";

    public abstract void sayHello();

    default void keu()
    {
        System.out.println("Meo meo");
    }
}
