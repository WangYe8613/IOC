package org.wy.ioc.pojo;

public class Consumer extends Person {
    public Long balance; //余额

    public Consumer(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void work() {
        System.out.println(name + ":我来消费了~");
        --balance;
    }
}
