package com.harmonystream.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.harmonystream.dao.UserDAO;
import com.harmonystream.model.User;
import com.harmonystream.util.DBConnection;

public class UserDAOImpl implements UserDAO {

    @Override
    public User login(String email, String password) {

        User u = null;

        try {
            Connection c = DBConnection.getConnection();
            System.out.println("✅ DB CONNECTED");

            PreparedStatement p = c.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?"
            );

            p.setString(1, email.trim());
            p.setString(2, password.trim());

            ResultSet r = p.executeQuery();

            if (r.next()) {
                u = new User();
                u.setId(r.getInt("id"));
                u.setName(r.getString("name"));
                u.setEmail(r.getString("email"));
                u.setRole(r.getString("role").trim().toUpperCase());

                System.out.println("✅ USER FOUND: " + u.getEmail());
                System.out.println("✅ ROLE = " + u.getRole());
            } else {
                System.out.println("❌ NO USER FOUND IN DB");
            }

            c.close();

        } catch (Exception e) {
            System.out.println("🔥 DATABASE ERROR");
            e.printStackTrace();
        }

        return u;
    }
}
