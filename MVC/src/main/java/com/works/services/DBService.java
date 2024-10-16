package com.works.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Value("${_driver}")
    private String driver;

    @Value("${_url}")
    private String url;

    @Value("${_username}")
    private String username;

    @Value("${_password}")
    private String password;

    public DriverManagerDataSource getSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


}
