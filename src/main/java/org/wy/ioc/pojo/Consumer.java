package org.wy.ioc.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("Consumer") // 将Consumer存入Spring IOC容器中，id设为Consumer
public class Consumer extends Person {
    @Value(value = "3")
    public Long balance; //余额

    @Override
    public void work() {
        System.out.println(name + ":我来消费了~");
        --balance;
    }
}
