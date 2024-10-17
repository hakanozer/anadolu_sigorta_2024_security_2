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
    final TinkEncDec tinkEncDec;

    public boolean login( String email, String password ) {
        try {
            String sql = "select * from customer where email = ?";
            PreparedStatement pre = dbService.getSource().getConnection().prepareStatement(sql);
            pre.setString(1, email);
            //pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            boolean status = rs.next();
            if (status) {
                String dbPassword = rs.getString("password");
                String plainPassword = tinkEncDec.decrypt(dbPassword);
                if (password.equals(plainPassword)) {
                    req.getSession().setAttribute("user", email);
                    return true;
                }
            }
        }catch (Exception ex) {}
        return false;
    }

}
