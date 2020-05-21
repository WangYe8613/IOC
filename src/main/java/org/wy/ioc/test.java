package org.wy.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.wy.ioc.config.SpringConfig;
import org.wy.ioc.dao.DatabaseUtil;
import org.wy.ioc.service.TransactionService;
import org.wy.ioc.service.TransactionServiceImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        //纯注解方式实现Spring IOC：进阶

        // step1：获取核心容器对象
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        // step2：根据id获取bean对象
        DatabaseUtil db = (DatabaseUtil) ac.getBean("DatabaseUtil");

        // step3：根据db操作数据库
        DataSource ds = db.createDataSource();
        Connection conn = null;
        try {
            conn = ds.getConnection();
            if (conn == null) {
                System.out.println("获取数据库连接失败！！！");
                return;
            }

            // 下面是我的数据库里的数据查询，可以直接使用，这里仅仅是为了验证连接数据库是否成功
            // 当前数据库里的UserVO表中只有一条数据，UUID=1234，name=admin

            // 建议使用PreparedStatement，而非Statement，是为了防止SQL注入
            String sql = "SELECT * FROM UserVO WHERE name!=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, "xxx");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("uuid: " + rs.getString("uuid"));
                System.out.println("name: " + rs.getString("name"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

// -------------------------我是分割线-------------------------

//        //纯注解方式实现Spring IOC
//
//        // step1：获取核心容器对象
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
//        // step2：根据id获取bean对象
//        TransactionService transactionService = (TransactionService) ac.getBean("TransactionService");
//        // step3：调用bean对象中的方法
//        transactionService.transaction();

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
