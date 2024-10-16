package com.works.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
@RequiredArgsConstructor
public class LoginService {

    final DBService dbService;

    public boolean login( String email, String password ) {
        try {
            String sql = "select * from customer where email = ? and password = ? ";
            PreparedStatement pre = dbService.getSource().getConnection().prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            return rs.next();
        }catch (Exception ex) {}
        return false;
    }

}
