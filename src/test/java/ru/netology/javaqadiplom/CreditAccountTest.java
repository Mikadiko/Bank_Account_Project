package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }


    @Test
    public void shouldAddToPositiveBalance1() {
        CreditAccount account = new CreditAccount(
                1,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_001, account.getBalance());
    }


    @Test
    public void shouldAddToZeroBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(1_000, account.getBalance());
    }


    @Test
    public void shouldCreateAccountIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                1,
                5_000,
                15
        );

        Assertions.assertEquals(1, account.getBalance());
    }


    @Test
    public void shouldNotCreateAccountIfInitialBalanceNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    -1,
                    5_000,
                    15
            );
        });
    }

    @Test
    public void shouldCreateAccountIfCreditLimitZero() {
        CreditAccount account = new CreditAccount(
                1000,
                0,
                15
        );

        Assertions.assertEquals(0, account.getCreditLimit());
    }

    @Test
    public void shouldCreateAccountIfCreditLimitPositive() {
        CreditAccount account = new CreditAccount(
                1000,
                1,
                15
        );

        Assertions.assertEquals(1, account.getCreditLimit());
    }


    @Test
    public void shouldNotCreateAccountIfCreditLimitNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    100,
                    -1,
                    15
            );
        });
    }


    @Test
    public void shouldCreateAccountIfRatePositive() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                1
        );

        Assertions.assertEquals(1, account.getRate());
    }

    @Test
    public void shouldCreateAccountIfRateZero() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                0
        );

        Assertions.assertEquals(0, account.getRate());
    }


    @Test
    public void shouldNotCreateAccountIfRateNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    0,
                    5_000,
                    -1);
        });
    }

    @Test
    public void shouldPositivePayBelowLimitIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10
        );
        account.pay(4000);

        Assertions.assertEquals(1000, account.getBalance());
    }


    @Test
    public void shouldPositivePayBelowCreditLimitIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10
        );
        account.pay(6000);

        Assertions.assertEquals(-1000, account.getBalance());
    }


    @Test
    public void shouldPositivePayBelowCreditLimitAssertTrue() {
        CreditAccount account = new CreditAccount(
                5000,
                2000,
                10
        );

        Assertions.assertTrue(account.pay(6000));
    }


    @Test
    public void shouldPositivePayAboveLimitIfInitialBalancePositive() {
        CreditAccount account = new CreditAccount(
                1000,
                2000,
                10
        );
        account.pay(4000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldPositivePayAboveLimitAssertFalse() {
        CreditAccount account = new CreditAccount(
                1000,
                2000,
                10
        );

        Assertions.assertFalse(account.pay(4000));
    }


    @Test
    public void shouldCalculatePercentToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }


    @Test
    public void shouldCalculatePercentToBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                200,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }


    @Test
    public void shouldCalculatePercentToNegativeBalanceOddNumber() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(555);

        Assertions.assertEquals(-83, account.yearChange());
    }
}
