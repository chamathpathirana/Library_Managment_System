package Controllers.Books.AddBook;


import Controllers.DB.dbConnection;
import Controllers.model.BookDTO;


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




     public boolean addBooks(BookDTO bookDTO){
         String SQL = "INSERT INTO books(book_id , Book_name , author , category , quantity , published_year)VALUES(?,?,?,?,?,?);";

         try {
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);

             preparedStatement.setString(1,bookDTO.getBookId());
             preparedStatement.setString(2,bookDTO.getBookTitle());
             preparedStatement.setString(3,bookDTO.getBookAuthor());
             preparedStatement.setString(4,bookDTO.getCategory());
             preparedStatement.setString(5,bookDTO.getQuantity());
             preparedStatement.setString(6, bookDTO.getPublishedYear());

             preparedStatement.executeUpdate();
             System.out.println("Successfull add book");

         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         return true;
     }



}
