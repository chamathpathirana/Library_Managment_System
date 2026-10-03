package Controllers.Login;

public class LoginController {
    public boolean checkUserNameandPassword(String name, String password) {
        if (name.equals("chamath") && password.equals("12345")){
                return true;

            } return false;
        }
    }

