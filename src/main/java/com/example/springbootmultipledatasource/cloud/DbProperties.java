package com.example.springbootmultipledatasource.cloud;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "db")
@RefreshScope
public class DbProperties {

      // This is for storing application properties in a Map
    public Map<String, String> dbProps;

    public Map<String, String> getDbProps() {
        return dbProps;
    }

    public void setDbProps(Map<String, String> dbProps) {
        this.dbProps = dbProps;
    }

        // Get property value using key
    public String getDbPropData(String key) {
        return dbProps.get(key);
    }

    @Override
    public String toString() {
        return "DbProperties{" +
                "dbProps=" + dbProps +
                '}';
    }
}