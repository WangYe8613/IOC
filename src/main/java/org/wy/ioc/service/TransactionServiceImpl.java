package org.wy.ioc.service;

import org.wy.ioc.pojo.Consumer;
import org.wy.ioc.pojo.Producer;

import static java.lang.Thread.sleep;

public class TransactionServiceImpl implements TransactionService {

    private Producer producer;
    private Consumer consumer;

    // spring可以用每个类的构造函数来创建该类对象，但是我们选择另一种更常用的方式：getter()和setter()
//    public TransactionServiceImpl(){
//        producer = new Producer("老板","30");
//        consumer = new Consumer("王也","24");
//        consumer.balance = 3L; //初始化的时候给消费者的余额定为3元
//    }


    // 使用get和set方法，便于spring注入值
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
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
