package Controllers.Books.ViewAllBooks;

import Controllers.DB.dbConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AllBooksController {
   static Connection connection = dbConnection.getInstance().getConnection();


    public static ObservableList<Map<String, String>> getAllBooks(){
        ObservableList<Map<String, String>> BookList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM books ORDER BY book_id ASC";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Map<String, String> row = new HashMap<>();

                row.put("book_id", resultSet.getString("book_id") != null ? resultSet.getString("book_id") : "");
                row.put("book_name", resultSet.getString("Book_name") != null ? resultSet.getString("Book_name") : "");
                row.put("author", resultSet.getString("author") != null ? resultSet.getString("author") : "");
                row.put("category", resultSet.getString("category") != null ? resultSet.getString("category") : "");
                row.put("quantity", resultSet.getString("quantity") != null ? resultSet.getString("quantity") : "");
                row.put("published_year", resultSet.getString("published_year") != null ? resultSet.getString("published_year") : "");

                BookList.add(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return BookList;
    }
}


