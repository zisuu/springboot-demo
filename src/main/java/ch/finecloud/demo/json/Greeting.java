package ch.finecloud.demo.json;

import org.springframework.stereotype.Component;

@Component
public class Greeting {
    private String message;

    public Greeting() {
    }

    public Greeting(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "message='" + message + '\'' +
                '}';
    }


}
