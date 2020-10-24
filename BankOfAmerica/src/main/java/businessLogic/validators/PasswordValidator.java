package businessLogic.validators;

import model.User;

import java.util.regex.Pattern;

public class PasswordValidator implements Validator<User> {
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    @Override
    public boolean validate(User user) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        if(!pattern.matcher(user.getPassword()).matches()){
            System.out.println("DO SMTH, passwoed does not match the pattern");
            return false;
        }
        return true;
    }
}
