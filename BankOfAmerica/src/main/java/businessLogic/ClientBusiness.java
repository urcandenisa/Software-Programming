package businessLogic;

import businessLogic.validators.PersonalNumericalCodeValidator;
import businessLogic.validators.Validator;
import dataAccess.ClientDataAccess;
import model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientBusiness {

    private List<Validator<Client>> validators;
    private ClientDataAccess clientDataAccess;

    public ClientBusiness(){
        validators = new ArrayList<Validator<Client>>();
        validators.add(new PersonalNumericalCodeValidator());
        clientDataAccess = new ClientDataAccess();
    }

    public List<Client> selectAll(){
        List<Client> clientsList = clientDataAccess.selectAll();
        if(clientsList == null){
            return null;
        }
        return clientsList;
    }

    public boolean addClient(Client client){
        if(validators.get(0).validate(client) == true) {
            clientDataAccess.addClient(client);
            return true;
        }
            ///aici fa o exceptie sau ceva ca nu se potriveste
            return false;

    }

    public void updateClient(Client client){
        clientDataAccess.updateClient(client);
    }
    public List<Client> searchAfter(String personalNumericalCode){
        List<Client> clients = clientDataAccess.searchAfter("personalNumericalCode", personalNumericalCode);
        if(clients == null) return null;
        return clients;
    }

    public void deleteAfter(String personalNumericalCode){
        clientDataAccess.deleteAfter("personalNumericalCode", personalNumericalCode);
    }

    public static void main(String[] args) {
        ClientBusiness cl = new ClientBusiness();
        List<Client> li = cl.selectAll();
    }

}
