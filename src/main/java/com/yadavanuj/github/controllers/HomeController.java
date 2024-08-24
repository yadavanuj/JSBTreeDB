package com.yadavanuj.github.controllers;

import com.yadavanuj.github.ds.list.SinglyList;
import com.yadavanuj.github.mem.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HomeController {
    private final Store store;

    // Behind the scene, Spring will do a new on Store and pass it to HomeController's constructor while initializing it.
    @Autowired
    public HomeController(Store store) {
        this.store = store;
    }

    @GetMapping("/")
    public String greet() {
        return "Hello World!!!!!!";
    }

    @GetMapping("/list/create/{name}")
    public String createList(@PathVariable String name) {
        // No validation on name as we are testing and controlling
        SinglyList newList = new SinglyList();
        this.store.put(name, newList);
        return "Success!";
    }

    @GetMapping("/list/prepend/{name}/{value}")
    public String prepend(@PathVariable String name,@PathVariable int value) {
        // Not handling negative cases for presentation
        SinglyList list = (SinglyList) this.store.get(name);
        list.prepend(value);

        this.store.put(name, list);
        SinglyList t = (SinglyList) this.store.get(name);
        return t.toString();
    }

    @GetMapping("/list/append/{name}/{value}")
    public String append(@PathVariable String name,@PathVariable int value) {
        // Not handling negative cases for presentation
        SinglyList list = (SinglyList) this.store.get(name);
        list.append(value);

        this.store.put(name, list);
        SinglyList t = (SinglyList) this.store.get(name);
        return t.toString();
    }
}
