package com.med.care.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Configurable
@ComponentScan(basePackages = {"com.med.care.service_impl"})
@EnableJpaRepositories(basePackages = {"com.med.care.dao"}, transactionManagerRef = "transactionManager")
@EnableTransactionManagement
public class ApplicationContext {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.med.care.domain");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.format_sql", true);
        factoryBean.setJpaProperties(properties);

        return factoryBean;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public DriverManagerDataSource dataSource() {

        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUsername("root");
        source.setPassword("");
        source.setUrl("jdbc:mysql://localhost:3306/care_blood_donation");
        return source;
    }
}
