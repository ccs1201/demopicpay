package com.demo.picpay.controler;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/helloWorld")
public class HelloWorldController {

    @PostMapping
    public ResponseEntity<String> sayHello(@RequestBody @Valid @NotNull String name) {

        var response = "Hello " + name.toString() + ", Welcome to the Dev's World!";

        return ResponseEntity.ok(response);
    }
}
