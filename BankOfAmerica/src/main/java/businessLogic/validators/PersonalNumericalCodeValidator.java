package businessLogic.validators;

import model.Client;

import java.util.regex.Pattern;

public class PersonalNumericalCodeValidator implements Validator<Client>{
    private static final String CNP_PATTERN = "^[0-9]{13,13}$";
    @Override
    public boolean validate(Client client) {
        Pattern pattern = Pattern.compile(CNP_PATTERN);
        if(!pattern.matcher(client.getPersonalNumericalCode()).matches()){
            System.out.println("DO SMTH, cnp does not match the pattern");
            return false;
        }
        return true;
    }
}
