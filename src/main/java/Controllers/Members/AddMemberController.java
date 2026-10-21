package Controllers.Members;

import Controllers.DB.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMemberController {
    Connection connection = dbConnection.getInstance().getConnection();

    public void addMembers(String member_id,String full_name,String email, Integer phone_number,String address){
        String SQL = "INSERT INTO members(member_id , full_name , email , phone_number , address )VALUES(?,?,?,?,?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,"M003");
            preparedStatement.setString(2,full_name);
            preparedStatement.setString(3,email);
            preparedStatement.setInt(4,phone_number);
            preparedStatement.setString(5,address);

            preparedStatement.executeUpdate();
            System.out.println("Succesfully add member");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
