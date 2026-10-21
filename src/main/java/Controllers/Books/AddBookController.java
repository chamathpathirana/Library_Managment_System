package Controllers.Books;


import Controllers.DB.dbConnection;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddBookController {
    Connection connection = dbConnection.getInstance().getConnection();

     public void addBooks(String book_id, String title , String author, String category, int quantity, String published_year){
         String SQL = "INSERT INTO books(book_id , title , author , category , quantity , published_year)VALUES(?,?,?,?,?,?);";

         try {
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             preparedStatement.setString(1,"B004");
             preparedStatement.setString(2,title);
             preparedStatement.setString(3,author);
             preparedStatement.setString(4,category);
             preparedStatement.setInt(5,quantity);
             preparedStatement.setString(6, published_year);

             preparedStatement.executeUpdate();
             System.out.println("Successfull add book");

         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }



}
