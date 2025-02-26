package com.maximet.sqlcda.repository;

import com.maximet.sqlcda.db.Bdd;
import com.maximet.sqlcda.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    //Attributs
    private static Connection connexion = Bdd.getConnexion();

    //Méthodes
    public static User save(User addUser){
        User newUser = null;
        try{
            //Requête
            String sql = "INSERT INTO users(firstname, lastname, email, password) VALUE (?,?,?,?)";

            //Préparer la requête
            PreparedStatement preparedStatement = connexion.prepareStatement(sql);

            //Bind les paramètres
            preparedStatement.setString(1, addUser.getFirstname());
            preparedStatement.setString(2, addUser.getLastname());
            preparedStatement.setString(3, addUser.getEmail());
            preparedStatement.setString(4, addUser.getPassword());

            //Exécuter la requête
            int nbrRows = preparedStatement.executeUpdate();
            if(nbrRows > 0){
                newUser = new User(addUser.getFirstname(), addUser.getLastname(), addUser.getEmail(), addUser.getPassword());
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return newUser;
    }


    public static boolean isExist(String email){

        User getUser = null;

        try{
            String sql = "SELECT id FROM users WHERE email = ?";

            //Prépare la requête
            PreparedStatement preparedStatement = connexion.prepareStatement(sql);

            //Bind le paramètre
            preparedStatement.setString(1, email);

            //Récupérer le résultat
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                getUser = new User();
                getUser.setId(resultSet.getInt("id"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return getUser != null;
    }

    public static User findByEmail(String email){

        User getUser = null;

        try{
            String sql = "SELECT id, firstname, lastname, email FROM users WHERE email = ?";

            //Prépare la requête
            PreparedStatement preparedStatement = connexion.prepareStatement(sql);

            //Bind le paramètre
            preparedStatement.setString(1, email);

            //Récupérer le résultat
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                getUser = new User();
                getUser.setId(resultSet.getInt("id"));
                getUser.setFirstname(resultSet.getString("firstname"));
                getUser.setLastname(resultSet.getString("lastname"));
                getUser.setEmail(resultSet.getString("email"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return getUser;
    }

    public static List<User> findAll(){

        List<User> userList = new ArrayList<>();
        User getUser = null;

        try{
            String sql = "SELECT id, firstname, lastname, email FROM users";

            //Prépare la requête
            PreparedStatement preparedStatement = connexion.prepareStatement(sql);

            //Récupérer le résultat
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                getUser = new User();
                getUser.setId(resultSet.getInt("id"));
                getUser.setFirstname(resultSet.getString("firstname"));
                getUser.setLastname(resultSet.getString("lastname"));
                getUser.setEmail(resultSet.getString("email"));
                userList.add(getUser);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return userList;
    }
}