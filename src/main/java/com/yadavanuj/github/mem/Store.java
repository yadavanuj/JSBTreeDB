package com.yadavanuj.github.mem;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// TODO: (Explain) This is a singleton component for Spring. i.e. Spring will create only one instance of this.
@Component
public class Store {
    private static final Map<String, Object> store = new HashMap<>();

    // TODO: (Explain) This brings boxing and unboxing in picture, so we should discuss it later.
    public void put(String key, Object value) {
        store.put(key, value);
    }

    public Object get(String key) {
        return store.get(key);
    }
}
