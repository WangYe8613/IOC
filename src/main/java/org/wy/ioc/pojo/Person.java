package org.wy.ioc.pojo;

public abstract class Person {
    String name;
    String age;

    public abstract void work();

    // 使用get和set方法，便于spring注入值
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
