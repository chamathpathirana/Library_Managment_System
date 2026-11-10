package Controllers.Members;

import Controllers.DB.dbConnection;
import Controllers.model.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AddMemberController {
    Connection connection = dbConnection.getInstance().getConnection();

    public String genarateMemberID(){
        String SQL = """
               
               SELECT MAX(CAST(SUBSTRING(member_id, 2) AS UNSIGNED)) FROM members WHERE member_id REGEXP '^M[0-9]+$'""";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                int lastId = resultSet.getInt(1);

                if (resultSet.wasNull()){
                    lastId = 0;
                }

                return String.format("M%03d", lastId + 1);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    public void addMembers(MemberDTO memberDTO){
        String SQL = "INSERT INTO members(member_id , full_name , email , phone_number , address )VALUES(?,?,?,?,?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, memberDTO.getMemberID());
            preparedStatement.setString(2,memberDTO.getFullname());
            preparedStatement.setString(3,memberDTO.getEmail());
            preparedStatement.setInt(4,memberDTO.getPhoneNumber());
            preparedStatement.setString(5,memberDTO.getAddress());

            preparedStatement.executeUpdate();
            System.out.println("Succesfully add member" + genarateMemberID());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
