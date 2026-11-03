package Controllers.Books.IssueBook;


import Controllers.DB.dbConnection;

import java.sql.*;
import java.time.LocalDate;

public class IssueBookController {
    Connection connection = dbConnection.getInstance().getConnection();

    public String getMemberIDFromDB(String memberName) {
       String SQL = "SELECT member_id FROM members WHERE full_name = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1,memberName);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return  resultSet.getString("member_id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  null;
    }

    public String getBookIDFromDB(String bookNmae) {

        String SQL = "SELECT book_id FROM books WHERE Book_name = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, bookNmae);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return resultSet.getString("book_id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String genarateIssueBookId() {
        String SQL = """
               
               SELECT MAX(CAST(SUBSTRING(issue_id, 3) AS UNSIGNED)) FROM issueBook WHERE issue_id REGEXP '^IB[0-9]+$'""";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                int lastId = resultSet.getInt(1);

                if (resultSet.wasNull()){
                    lastId = 0;
                }
                return String.format("IB%03d", lastId + 1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }


    public void issueBooks(String IssueID, String MemberID, String BookID, LocalDate IssueDate, LocalDate DueDate) {
        String SQL = "INSERT INTO issuebook(Issue_id, Member_id, Book_id, issuedate, duedate) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1,IssueID);
            preparedStatement.setString(2,MemberID);
            preparedStatement.setString(3,BookID);
            preparedStatement.setDate(4, Date.valueOf(IssueDate));
            preparedStatement.setDate(5, Date.valueOf(DueDate));

            preparedStatement.executeUpdate();
            System.out.println("vadee Goda......");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

