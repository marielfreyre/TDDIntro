package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by MarielFreyre on 7/31/15.
 */
public class Account {

    private float balance;

    public Account(float balance){this.balance = balance;}


    public double exchangeMoney(double sum){
        if (this.balance+sum>0){return balance += sum;}
        else{return balance;}

    }
}
