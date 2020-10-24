package model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;


public class Account {
    private String personalNumericalCode;
    private String identificationNumber;
    private String type;
    private double amountOfMoney;
    private String dateOfCreation;


    public Account(){

    }
    public Account(String personalNumericalCode, String identificationNumber, String type, double amountOfMoney, String dateOfCreation) {
        this.personalNumericalCode = personalNumericalCode;
        this.identificationNumber = identificationNumber;
        this.type = type;
        this.amountOfMoney = amountOfMoney;
        this.dateOfCreation = dateOfCreation;
    }

    public String getPersonalNumericalCode() {
        return personalNumericalCode;
    }

    public void setPersonalNumericalCode(String personalNumericalCode) {
        this.personalNumericalCode = personalNumericalCode;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Override
    public String toString() {
        return identificationNumber + " " + type + " " + amountOfMoney + " " + dateOfCreation;
    }
}
