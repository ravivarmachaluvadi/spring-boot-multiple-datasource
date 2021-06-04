package com.example.springbootmultipledatasource.cloud;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value = "prop.value")
@RefreshScope
public class PropsDTO {

    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PropsDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
