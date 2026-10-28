package Controllers.Books;


import Controllers.DB.dbConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AddBookController {
    Connection connection = dbConnection.getInstance().getConnection();

    public String genarateBookId(){
        String SQL = """
                SELECT MAX(CAST(SUBSTRING(book_id, 2) AS UNSIGNED)) FROM books WHERE book_id REGEXP '^B[0-9]+$'""";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                int lastId = resultSet.getInt(1);

                if (resultSet.wasNull()){
                    lastId = 0;
                }

                return String.format("B%03d", lastId + 1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }




     public void addBooks(String book_id, String title , String author, String category, int quantity, String published_year){
         String SQL = "INSERT INTO books(book_id , title , author , category , quantity , published_year)VALUES(?,?,?,?,?,?);";

         try {
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);

             preparedStatement.setString(1,book_id);
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
