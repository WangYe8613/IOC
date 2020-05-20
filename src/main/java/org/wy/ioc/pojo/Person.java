package org.wy.ioc.pojo;

import org.springframework.beans.factory.annotation.Value;

public abstract class Person {
    @Value(value = "人")
    String name;
    String age;

    public abstract void work();
}
