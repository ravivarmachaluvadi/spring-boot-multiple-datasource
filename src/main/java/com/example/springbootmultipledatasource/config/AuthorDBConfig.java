package com.example.springbootmultipledatasource.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "authorEntityManagerFactory", transactionManagerRef = "authorTransactionManager", basePackages = {
        "com.example.springbootmultipledatasource.author.repository" })
public class AuthorDBConfig {

    @Bean(name = "authorDataSource")
    @ConfigurationProperties(prefix = "spring.postgres.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "authorEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean authorEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("authorDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        //properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return builder.dataSource(dataSource).properties(properties)
                .packages("com.example.springbootmultipledatasource.model.author").persistenceUnit("Author").build();
    }

    @Bean(name = "authorTransactionManager")
    public PlatformTransactionManager authorTransactionManager(
            @Qualifier("authorEntityManagerFactory") EntityManagerFactory authorEntityManagerFactory) {
        return new JpaTransactionManager(authorEntityManagerFactory);
    }
}
