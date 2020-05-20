package org.wy.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wy.ioc.config.SpringConfig;
import org.wy.ioc.service.TransactionService;
import org.wy.ioc.service.TransactionServiceImpl;

public class test {
    public static void main(String[] args) {
        //纯注解方式实现Spring IOC

        // step1：获取核心容器对象
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        // step2：根据id获取bean对象
        TransactionService transactionService = (TransactionService) ac.getBean("TransactionService");
        // step3：调用bean对象中的方法
        transactionService.transaction();

// -------------------------我是分割线-------------------------

//        // 不再使用主动new的方式创建对象
////        TransactionService transactionService = new TransactionServiceImpl();
//
//        // 而是从Spring IOC容器中获取
//        // step1：获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("service.xml");
//        // step2：根据id获取bean对象
//        TransactionService transactionService = (TransactionService) ac.getBean("TransactionService");
//        // step3：调用bean对象中的方法
//        transactionService.transaction();
    }
}
