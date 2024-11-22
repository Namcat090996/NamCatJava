package vn.com.stanford.workingrestfulapi.entities;

public class Message {
    
    private String name;
    
    public Message(String name) {
        this.name = name;
    }
    
    public Message() {}
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
