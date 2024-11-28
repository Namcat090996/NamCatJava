package vn.com.stanford.workingrestfulapi.entities;

public class Message {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Message() {

    }
    public Message(String name) {
    this.name = name;
    }
}
