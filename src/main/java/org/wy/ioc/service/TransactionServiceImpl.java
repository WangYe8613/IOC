package org.wy.ioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wy.ioc.pojo.Consumer;
import org.wy.ioc.pojo.Producer;

import static java.lang.Thread.sleep;

@Service("TransactionService") // 将TransactionServiceImpl存入Spring IOC容器中，id设为TransactionService
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private Producer producer;
    @Autowired
    private Consumer consumer;


    @Override
    public void transaction() {
        while(consumer.balance > 0) {
            producer.work();
            consumer.work();
            System.out.println("消费者余额剩余： " + consumer.balance);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费者没钱了！！！");
    }
}
