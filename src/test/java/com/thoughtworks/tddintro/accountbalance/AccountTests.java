package com.thoughtworks.tddintro.accountbalance;

import org.junit.Test;
import org.junit.Before;



import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;






public class AccountTests {
    private Account account;
    @Before
    public void setUp() throws Exception {
        account = new Account(100);
    }

    @Test
  public void shouldIncreaseMyBalanceWhenIDepositMoney(){
      assertThat(account.exchangeMoney(50.0), is(150.0));


  }

   @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
       assertThat(account.exchangeMoney(-50.0), is(50.0));

    }

    @Test
   public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        assertThat(account.exchangeMoney(100.0), is(50.0));

    }
}
