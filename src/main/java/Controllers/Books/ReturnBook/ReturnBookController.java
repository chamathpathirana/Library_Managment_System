package Controllers.Books.ReturnBook;

import Controllers.DB.dbConnection;
import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ReturnBookController {
    Connection connection = dbConnection.getInstance().getConnection();

    public Map<String, String> get(String member_name) {
        String SQL =  "SELECT i.issue_id, i.Book_id, b.Book_name, " +
                "i.member_id, m.full_name, " +
                "i.issuedate, i.duedate " +
                "FROM issuebook i " +
                "INNER JOIN books b ON i.Book_id = b.book_id " +
                "INNER JOIN members m ON i.member_id = m.member_id " +
                "WHERE m.full_name = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, member_name);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                Map<String, String> data = new HashMap<>();

                data.put("issue_id", resultSet.getString("issue_id"));
                data.put("member_id", resultSet.getString("member_id"));
                data.put("Book_id", resultSet.getString("Book_id"));
                data.put("Book_name", resultSet.getString("Book_name"));
                data.put("issuedate", resultSet.getString("issuedate"));
                data.put("duedate", resultSet.getString("duedate"));

                return data;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;

    }


    public void returnBooks(String book_id, String member_id, LocalDate issue_date, LocalDate due_date, LocalDate return_date) {

        String SQL = "INSERT INTO  Return_BookHistory(book_id, member_id, issue_date, due_date, return_date) VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, book_id);
            preparedStatement.setString(2, member_id);
            preparedStatement.setDate(3, Date.valueOf(issue_date));
            preparedStatement.setDate(4, Date.valueOf(due_date));
            preparedStatement.setDate(5, Date.valueOf(return_date));

            preparedStatement.executeUpdate();
            System.out.println("Sucess");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
