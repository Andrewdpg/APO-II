package Semana_6.billeteraVirtual.model;

import Semana_6.billeteraVirtual.exceptions.NegativeAmmountException;
import Semana_6.billeteraVirtual.exceptions.NotEnoughMoneyException;
import Semana_6.billeteraVirtual.exceptions.OverTopException;

public class Wallet {
    private double funds;
    private int id;
    private double limit;

    public Wallet(int id) {
        this.id = id;
        funds = 0;
        limit = 1000;
    }

    public void put(double ammount) throws NegativeAmmountException, OverTopException{
        if(ammount < 0){
            throw new NegativeAmmountException();
        }
        if(ammount +funds >limit){
            throw new OverTopException();
        }
        funds+= ammount;
    }

    public void withdraw(double ammount) throws NegativeAmmountException, NotEnoughMoneyException{
        if(ammount < 0){
            throw new NegativeAmmountException();
        }
        if(funds < ammount){
            throw new NotEnoughMoneyException();
        }
        funds -= ammount;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double founds) {
        this.funds = founds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

}
