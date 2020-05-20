package org.wy.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 该类是一个配置类，它的作用和service.xml一样
 * 使用该类就可以实现：完全脱离xml方式的Spring IOC机制，即纯注解实现Spring IOC
 *
 * 继续学习三个新的注解：
 * ①@Configuration
 *      作用：制定一个类作为配置类
 *
 * ②@ComponentScan
 *      作用：用于"指定Spring创建IOC容器时要扫描的包在"
 *      属性：
 *          value：包名，eg："org.wy.ioc"
 */

@Configuration
@ComponentScan(value = "org.wy.ioc")
public class SpringConfig {
}
