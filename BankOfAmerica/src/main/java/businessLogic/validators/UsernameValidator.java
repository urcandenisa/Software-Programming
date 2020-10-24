package businessLogic.validators;

import model.User;

import java.util.regex.Pattern;

public class UsernameValidator implements Validator<User> {
    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
    @Override
    public boolean validate(User user){
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        if(!pattern.matcher(user.getUsername()).matches()){
            System.out.println("DO SMTH, username does not match the pattern");
            return false;
        }
        return true;
    }
}
