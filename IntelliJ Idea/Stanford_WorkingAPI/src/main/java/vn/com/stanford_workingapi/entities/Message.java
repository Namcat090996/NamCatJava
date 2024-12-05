package vn.com.stanford_workingapi.entities;

public class Message {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    private String name;
    
    private String message;

    public Message() {

    }
    public Message(String name, String message) {
        this.name = name;
        this.message = message;
    }
    
    public Message(String name) {
        this.name = name;
    }
}
