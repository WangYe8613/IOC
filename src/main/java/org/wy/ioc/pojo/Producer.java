package org.wy.ioc.pojo;

public class Producer extends Person {

    // spring可以用每个类的构造函数来创建该类对象，但是我们选择另一种更常用的方式：getter()和setter()
//    public Producer(String name, String age){
//        this.name = name;
//        this.age = age;
//    }

    @Override
    public void work() {
        System.out.println(name + ":我来生产了~");
    }
}
