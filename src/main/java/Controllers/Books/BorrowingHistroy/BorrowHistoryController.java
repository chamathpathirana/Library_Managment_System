package Controllers.Books.BorrowingHistroy;

import Controllers.DB.dbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BorrowHistoryController {

    Connection connection = dbConnection.getInstance().getConnection();

    public  ObservableList<Map<String, String>> getBookHistoryBooks() {
        ObservableList<Map<String, String>> returnBorrowHistoryList = FXCollections.observableArrayList();

        String SQL = "SELECT " +
                "b.book_id AS book_id, " +
                "b.Book_name AS book_name, " +
                "m.member_id AS member_id, " +
                "m.full_name AS member_name, " +
                "RB.issue_date AS issue_date, " +
                "RB.due_date AS due_date, " +
                "RB.return_date AS return_date, " +
                "'Returned' AS status " +
                "FROM Return_BookHistory RB " +
                "JOIN books b ON RB.book_id = b.book_id " +
                "JOIN members m ON RB.member_id = m.member_id " +
                "ORDER BY m.member_id ASC";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Map<String, String> row = new HashMap<>();
                row.put("book_id", resultSet.getString("book_id") != null ? resultSet.getString("book_id") : "");
                row.put("book_name", resultSet.getString("book_name") != null ? resultSet.getString("book_name") : "");
                row.put("member_id", resultSet.getString("member_id") != null ? resultSet.getString("member_id") : "");
                row.put("member_name", resultSet.getString("member_name") != null ? resultSet.getString("member_name") : "");
                row.put("issue_date", resultSet.getString("issue_date") != null ? resultSet.getString("issue_date") : "");
                row.put("due_date", resultSet.getString("due_date") != null ? resultSet.getString("due_date") : "");
                row.put("return_date", resultSet.getString("return_date") != null ? resultSet.getString("return_date") : "");
                row.put("status", resultSet.getString("status") != null ? resultSet.getString("status") : "");

                returnBorrowHistoryList.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return returnBorrowHistoryList;

    }
}
