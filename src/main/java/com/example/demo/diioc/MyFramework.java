package com.example.demo.diioc;

public class MyFramework {
    public ITest init() {
        Manager m = new Manager(); // jdbc:com.example.demo
        ITest tc = new TestController(m);

        // reflection

        return tc;
    }
}
