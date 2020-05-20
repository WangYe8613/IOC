package org.wy.ioc.pojo;

public class Consumer extends Person {
    public Long balance; //余额

    // spring可以用每个类的构造函数来创建该类对象，但是我们选择另一种更常用的方式：getter()和setter()
//    public Consumer(String name, String age) {
//        this.name = name;
//        this.age = age;
//    }


    // 使用get和set方法，便于spring注入值
    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Override
    public void work() {
        System.out.println(name + ":我来消费了~");
        --balance;
    }
}
