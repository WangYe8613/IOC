package org.wy.ioc.pojo;

public class Producer extends Person {

    public Producer(String name, String age){
        this.name = name;
        this.age = age;
    }

    @Override
    public void work() {
        System.out.println(name + ":我来生产了~");
    }
}
