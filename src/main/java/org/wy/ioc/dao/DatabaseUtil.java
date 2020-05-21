package org.wy.ioc.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * 纯注解实现Spring IOC机制：进阶
 *
 * 这次实践需要导入mysql-connector-java的jar包，如果有需要，可以自行下载或者跟我要
 *
 * 再来学习一个新的注解：
 * ①@PropertySource
 *      作用：读取指定.properties格式的配置文件，使用该配置文件中的键值对
 *      属性："classpath:xxx.properties"
 *      说明：常用于配置数据信息
 *
 * ②@Bean
 *      作用：将方法的返回值作为bean存入Spring IOC容器
 *      属性："xxx"
 */

@Service("DatabaseUtil") // 将DatabaseUtil存入Spring IOC容器中，id设为DatabaseUtil
@PropertySource("classpath:JDBCConfig.properties")
public class DatabaseUtil {

    // 根据JDBCConfig.properties配置中设置的值来给成员变量注入数据
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.connectionTimeout}")
    private long connectionTimeout;

    @Value("${jdbc.idleTimeout}")
    private long idleTimeout;

    @Value("${jdbc.maximumPoolSize}")
    private int maximumPoolSize;

    @Bean("DataSource") //将该方法的返回值作为bean存入Spring IOC容器，id设为dataSource
    public DataSource createDataSource(){
        // 这里使用HikariConfig数据库连接池
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setConnectionTimeout(connectionTimeout);
        hikariConfig.setIdleTimeout(idleTimeout);
        hikariConfig.setMaximumPoolSize(maximumPoolSize);

        DataSource ds = new HikariDataSource(hikariConfig);
        return ds;
    }
}
