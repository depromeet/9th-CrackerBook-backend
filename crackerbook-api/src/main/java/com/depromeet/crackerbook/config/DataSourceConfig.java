package com.depromeet.crackerbook.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@RequiredArgsConstructor
@Configuration
@EnableJpaRepositories(
        basePackages = "com.depromeet.crackerbook.domain" // repository package path
        , entityManagerFactoryRef = "entityManagerFactory"
        , transactionManagerRef = "transactionManager")
public class DataSourceConfig {

    private static final String DATA_SOURCE_USERNAME = "postgres";
    private static final String DATA_SOURCE_PASSWORD = "1q2w3e4r!!";

    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .username(DATA_SOURCE_USERNAME) // FIXME: AWS Secret Manager
                .password(DATA_SOURCE_PASSWORD)
                .build();
    }

    @Primary
    @Bean(name = "jpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa")
    public JpaProperties jpaProperties() {
        return new JpaProperties();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder
            , @Qualifier("dataSource") DataSource primaryDataSource
            , @Qualifier("jpaProperties") JpaProperties jpaProperties
    ) {
        return builder
                .dataSource(primaryDataSource)
                .properties(jpaProperties.getProperties())
                .packages("com.depromeet.crackerbook.domain") // entity package path
                .persistenceUnit("default")
                .build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory.getObject());
        transactionManager.setNestedTransactionAllowed(true);
        return transactionManager;
    }
}
