package pl.coderslab.utils;

import pl.coderslab.entity.User;

import java.sql.*;
import java.util.Arrays;

public class DaoMethods {


    public User create(User user){

        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement preste = conn.prepareStatement("INSERT INTO users VALUES(null,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            preste.setString(1,user.getEmail());
            preste.setString(2,user.getUsername());
            preste.setString(3,user.getPassword());
            preste.executeUpdate();
            ResultSet rs = preste.getGeneratedKeys();

            while(rs.next()){
                user.setId(rs.getInt(1));
            }
            return user;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public void update (User user){
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement preste = conn.prepareStatement("UPDATE users set email = ?, username = ? WHERE id = ?;");
            preste.setString(1,user.getEmail());
            preste.setString(2,user.getUsername());
            preste.setInt(3, user.getId());

            preste.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }



    }

    public User read(int id ){

        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement preste = conn.prepareStatement("SELECT * FROM users WHERE id = ?;");
            preste.setInt(1,id);
            ResultSet rs = preste.executeQuery();
            if (rs.next()) {
                int id2 = rs.getInt("id");

                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                User user = new User();
                user.setId(id2);
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
                return user;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public User[] findAll() {
        try (Connection conn = DbUtil.getConnection()) {
            User users[] = new User[0];
            PreparedStatement preste = conn.prepareStatement("SELECT * FROM users;");

            ResultSet rs2 = preste.executeQuery();
            while (rs2.next()) {
                User user = new User();
                user.setId(rs2.getInt("id"));
                user.setEmail(rs2.getString("email"));
                user.setPassword(rs2.getString("password"));
                user.setUsername(rs2.getString("username"));

                users = addToArray(users, user);
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;


    }

    public void delete(int id){
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement preste = conn.prepareStatement("DELETE  FROM users where id = ?;");
            preste.setInt(1,id);
            preste.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

public User[] addToArray(User users[], User user){
        users = Arrays.copyOf(users, users.length+1);
        users[users.length-1] = user;
        return users;
}

}