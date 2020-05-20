package org.wy.ioc.service;

import org.wy.ioc.pojo.Consumer;
import org.wy.ioc.pojo.Producer;

import static java.lang.Thread.sleep;

public class TransactionServiceImpl implements TransactionService {

    private Producer producer;
    private Consumer consumer;

    public TransactionServiceImpl(){
        producer = new Producer("老板","30");
        consumer = new Consumer("王也","24");
        consumer.balance = 3L; //初始化的时候给消费者的余额定为3元
    }

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
