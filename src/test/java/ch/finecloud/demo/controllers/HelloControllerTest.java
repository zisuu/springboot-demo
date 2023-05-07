package ch.finecloud.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {


    @Test
    void sayHello() {
        HelloController helloController = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = helloController.sayHello("World", model);
        assertAll(
                () -> assertEquals("hello", result),
                () -> assertEquals("World", model.getAttribute("user"))
        );
    }
}