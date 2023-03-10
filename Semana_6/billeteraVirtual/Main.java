package Semana_6.billeteraVirtual;

import java.util.Scanner;

import Semana_6.billeteraVirtual.exceptions.NegativeAmmountException;
import Semana_6.billeteraVirtual.exceptions.NotEnoughMoneyException;
import Semana_6.billeteraVirtual.exceptions.OverTopException;
import Semana_6.billeteraVirtual.model.Wallet;

public class Main {

    public static void main(String[] args) {
        Wallet wallet = new Wallet(00001);
        Scanner scn =new Scanner(System.in);
        try {
            wallet.put(scn.nextDouble());
            System.out.println("Fondos actuales: " + wallet.getFunds());
            wallet.withdraw(scn.nextDouble());
        } catch (NegativeAmmountException ex) {
            ex.printStackTrace();
        } catch (OverTopException ex) {
            ex.printStackTrace();
        }catch(NotEnoughMoneyException ex){
            ex.printStackTrace();
        }
        scn.close();
    }
}
