package com.adyen.android.assignment

import com.adyen.android.assignment.money.Bill
import com.adyen.android.assignment.money.Change
import com.adyen.android.assignment.money.Coin
import org.junit.Assert.*
import org.junit.Test

class CashRegisterTest {

    @Test
    fun price_zero_test() {
        val cashRegisterChange = Change.max()
        val cashRegister =
            CashRegister(cashRegisterChange)
        val customerCash = Change.max()
        val price = 0L

        val result = assertThrows(CashRegister.TransactionException::class.java) {
            cashRegister.performTransaction(price, customerCash)
        }
        assertEquals("Price is not valid", result.message)
        assertTrue(result.cause is IllegalArgumentException)
    }
    @Test
    fun price_negative_test() {
        val cashRegisterChange = Change.max()
        val cashRegister =
            CashRegister(cashRegisterChange)
        val customerCash = Change.max()
        val price = -2L

        val result = assertThrows(CashRegister.TransactionException::class.java) {
            cashRegister.performTransaction(price, customerCash)
        }
        assertEquals("Price is not valid", result.message)
        assertTrue(result.cause is IllegalArgumentException)
    }

    @Test
    fun merchant_has_not_enough_money() {
        val cashRegisterChange = Change.none()
        val cashRegister =
            CashRegister(cashRegisterChange)
        val customerCash = Change.max()
        val price = 200L

        val result = assertThrows(CashRegister.TransactionException::class.java) {
            cashRegister.performTransaction(price, customerCash)
        }
        assertEquals("CashRegister has not enough money", result.message)
    }
    @Test
    fun customer_has_not_enough_money() {
        val cashRegisterChange = Change.max()
        val cashRegister =
            CashRegister(cashRegisterChange)
        val customerCash = Change.none()
        val price = 200L

        val result = assertThrows(CashRegister.TransactionException::class.java) {
            cashRegister.performTransaction(price, customerCash)
        }
        assertEquals("Customer has not enough money", result.message)
    }


    @Test
    fun merchant_has_not_exact_return_value() {
        val cashRegisterChange = Change().add(Bill.ONE_HUNDRED_EURO, 5)
        val cashRegister =
            CashRegister(cashRegisterChange)
        val customerCash = Change()
            .add(Bill.ONE_HUNDRED_EURO, 2)
        val price = 2000L

        val result = assertThrows(CashRegister.TransactionException::class.java) {
            cashRegister.performTransaction(price, customerCash)
        }
        assertEquals("CashRegister has not exact return value", result.message)
    }


    @Test
    fun merchant_returns_with_minimal_amount_of_change() {
        val cashRegisterChange = Change()
            .add(Bill.ONE_HUNDRED_EURO, 200)
            .add(Bill.FIFTY_EURO, 100)
            .add(Bill.TEN_EURO, 200)
            .add(Bill.FIVE_EURO, 200)
            .add(Bill.TWENTY_EURO, 100)
            .add(Coin.ONE_EURO, 500)


        val cashRegister =
            CashRegister(cashRegisterChange)
        val customerCash = Change()
            .add(Bill.FIVE_HUNDRED_EURO, 1)

        val price = 10400L

        val result = cashRegister.performTransaction(price, customerCash)

        val expectedChange = Change()
            .add(Bill.ONE_HUNDRED_EURO, 3)
            .add(Bill.FIFTY_EURO, 1)
            .add(Bill.TWENTY_EURO, 2)
            .add(Bill.FIVE_EURO, 1)
            .add(Coin.ONE_EURO, 1)

        assertEquals(expectedChange, result)
    }

    @Test
    fun pay_with_coins() {
        val cashRegisterChange = Change()
            .add(Bill.ONE_HUNDRED_EURO, 5)
            .add(Bill.FIVE_EURO, 1)
            .add(Coin.FIFTY_CENT, 1)
            .add(Coin.FIVE_CENT, 10)
            .add(Coin.ONE_CENT, 120)
        val cashRegister =
            CashRegister(cashRegisterChange)
        val customerCash = Change()
            .add(Bill.FIVE_EURO, 1)

        val price = 400L

        val result = cashRegister.performTransaction(price, customerCash)
        val expectedChange = Change()
            .add(Coin.FIFTY_CENT, 1)
            .add(Coin.FIVE_CENT, 10)

        assertEquals(expectedChange, result)
    }

    @Test
    fun customer_has_exact_value() {
        val cashRegisterChange = Change()
            .add(Bill.ONE_HUNDRED_EURO, 5)
            .add(Bill.FIVE_EURO, 1)
            .add(Coin.FIFTY_CENT, 1)
            .add(Coin.TEN_CENT, 5)
            .add(Coin.FIVE_CENT, 10)
        val cashRegister =
            CashRegister(cashRegisterChange)
        val customerCash = Change()
            .add(Bill.FIVE_EURO, 1)

        val price = 500L
        val result = cashRegister.performTransaction(price, customerCash)
        val expectedChange = Change.none()
        assertEquals(expectedChange, result)
    }

    @Test
    fun give_back_98() {
        val cashRegisterChange = Change()
            .add(Bill.FIVE_HUNDRED_EURO, 5)
            .add(Bill.FIFTY_EURO, 5)
            .add(Bill.TWENTY_EURO, 5)
            .add(Bill.FIVE_EURO, 5)
            .add(Coin.TWO_EURO, 5)
            .add(Coin.ONE_EURO, 5)

        val cashRegister =
            CashRegister(cashRegisterChange)

        val customerCash = Change()
            .add(Bill.ONE_HUNDRED_EURO, 1)

        val price = 200L
        val result = cashRegister.performTransaction(price, customerCash)
        val expectedChange = Change()
            .add(Bill.FIFTY_EURO, 1)
            .add(Bill.TWENTY_EURO, 2)
            .add(Bill.FIVE_EURO, 1)
            .add(Coin.TWO_EURO, 1)
            .add(Coin.ONE_EURO, 1)

        assertEquals(expectedChange, result)
    }


    @Test
    fun merchant_can_only_pay_after_getting_cash_from_the_customer() {
        val cashRegisterChange = Change()
            .add(Bill.FIVE_EURO, 1)

        val cashRegister =
            CashRegister(cashRegisterChange)
        val customerCash = Change()
            .add(Coin.ONE_EURO, 5)

        val price = 100L

        val result = cashRegister.performTransaction(price, customerCash)
        val expectedChange = Change()
            .add(Coin.ONE_EURO, 4)

        assertEquals(expectedChange, result)
    }
}
