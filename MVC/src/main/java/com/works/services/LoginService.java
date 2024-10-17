package com.works.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
@RequiredArgsConstructor
public class LoginService {

    final DBService dbService;
    final HttpServletRequest req;

    public boolean login( String email, String password ) {
        try {
            String sql = "select * from customer where email = ? and password = ? ";
            PreparedStatement pre = dbService.getSource().getConnection().prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            boolean status = rs.next();
            if (status) {
                req.getSession().setAttribute("user", email);
            }
            return status;
        }catch (Exception ex) {}
        return false;
    }

}
