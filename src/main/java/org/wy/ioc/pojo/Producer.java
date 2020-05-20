package org.wy.ioc.pojo;

import org.springframework.stereotype.Service;

@Service("Producer") // 将Producer存入Spring IOC容器中，id设为Producer
public class Producer extends Person {

    @Override
    public void work() {
        System.out.println(name + ":我来生产了~");
    }
}
