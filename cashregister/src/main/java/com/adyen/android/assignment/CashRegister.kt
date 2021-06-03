package com.adyen.android.assignment

import com.adyen.android.assignment.money.Change
import com.adyen.android.assignment.money.MonetaryElement
import java.util.*
import java.util.function.Consumer

/**
 * The CashRegister class holds the logic for performing transactions.
 *
 * @param change The change that the CashRegister is holding.
 */
class CashRegister() {

    private lateinit var cash: Change

    constructor(change: Change) : this() {
        cash = change
    }

    /**
     * Performs a transaction for a product/products with a certain price and a given amount.
     *
     * @param price The price of the product(s).
     * @param amountPaid The amount paid by the shopper.
     *
     * @return The change for the transaction.
     *
     * @throws TransactionException If the transaction cannot be performed.
     */
    @Throws(TransactionException::class)
    fun performTransaction(price: Long, amountPaid: Change): Change {

        //difference between price and the user payment
        val payDiff: Long = amountPaid.total - price

        //invalid cases
        if (price <= 0) {
            throw TransactionException("Price is not valid", IllegalArgumentException())
        } else if (price > amountPaid.total) {
            throw TransactionException("Customer has not enough money")
        } else if (payDiff > cash.total) {
            throw TransactionException("CashRegister has not enough money")
        }

        //Add customer money to our cash
        addCustomerMoneyToCash(amountPaid)

        //if the customer paid the exact amount then return empty Change
        if (payDiff == 0L) {
            return Change()
        }

        //This is the amount we are going to payback
        val returnChange = Change()

        //To reduce amount of items we return we have to start from the biggest value monetary
        val sortedMonetaryItems: LinkedList<MonetaryElement> = LinkedList(cash.getElements())
        sortedMonetaryItems.sortWith { o1: MonetaryElement, o2: MonetaryElement -> o2.minorValue - o1.minorValue }

        val possiblePayment = HashMap<Long, Change>()

        possiblePayment(
            Stack<Int?>(),
            sortedMonetaryItems,
            payDiff,
            returnChange,
            sortedMonetaryItems.size,
            0,
            possiblePayment
        )

        val payment = possiblePayment
            .entries
            .stream()
            .filter { entry: Map.Entry<Long, Change> -> entry.key == 0L }
            .map { it.value }
            .findFirst()

        if (!payment.isPresent) {
            throw TransactionException("CashRegister has not exact return value")
        }

        return payment.get()

    }

    //add customer money to our cash
    private fun addCustomerMoneyToCash(amountPaid: Change) {
        amountPaid.getElements().forEach(Consumer { element: MonetaryElement ->
            cash.add(
                element, amountPaid.getCount(
                    element
                )
            )
            amountPaid.remove(element, amountPaid.getCount(element))
        })
    }

    private fun possiblePayment(
        stack: Stack<Int?>,
        monetaryItems: LinkedList<MonetaryElement>,
        payDiff: Long,
        returnChange: Change,
        size: Int,
        index: Int,
        possiblePayment: MutableMap<Long, Change>
    ) {
        var payDiff = payDiff
        if (payDiff == 0L && !possiblePayment.containsKey(payDiff))
        {
            possiblePayment[payDiff] = returnChange
        }
        else {
            for (i in index until size) {
                val element = monetaryItems[i]
                // try this partial candidate solution
                while (element.minorValue <= payDiff &&
                    cash.getElements().contains(element) && cash.getCount(element) != 0 && possiblePayment.isEmpty())
                {
                    payDiff = payDiff - element.minorValue
                    cash.remove(element, 1)
                    returnChange.add(element, 1)
                    stack.push(element.minorValue)
                }
                // given the candidate, explore further
                possiblePayment(stack, monetaryItems, payDiff, returnChange, size, index + 1, possiblePayment)

                //backtrack
                if (stack.peek() == monetaryItems[i].minorValue && possiblePayment.isEmpty()) {
                    val lasElement = monetaryItems[i]
                    payDiff = payDiff + lasElement.minorValue
                    cash.add(lasElement, 1)
                    returnChange.remove(lasElement, 1)
                    stack.pop()
                }
            }
        }
    }

    class TransactionException(message: String, cause: Throwable? = null) :
        Exception(message, cause)


}
