package vn.com.stanford.je0824.bookstore.model;

import java.util.List;

public class SpringHelloWorld implements IHanhDong{
    @Override
    public List layDanhSach() {
        return null;
    }

    @Override
    public Object layChiTiet(Object id) {
        return null;
    }

    @Override
    public boolean themMoi(Object obj) {
        return false;
    }

    @Override
    public boolean capNhat(Object obj) {
        return false;
    }

    @Override
    public boolean xoa(Object id) {
        return false;
    }

    @Override
    public void sayHello() {
        System.out.println("Say Hello World");
    }
}
