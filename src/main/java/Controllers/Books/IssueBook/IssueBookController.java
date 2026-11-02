package Controllers.Books.IssueBook;


import Controllers.DB.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}

