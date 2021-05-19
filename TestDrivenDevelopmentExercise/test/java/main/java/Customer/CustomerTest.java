package main.java.Customer;

import main.java.Customer.Customer;
import main.java.Transaction.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
    private Transaction transaction;
    private Customer customer1;
    private Customer customer2;

    @Before
    public void init(){
        this.customer1 = new Customer("Peter", 1, 100);
        this.customer2 = new Customer("George", 2, 100);
        this.transaction = new Transaction(1, 50, customer1, customer2);
    }

    @Test
    public void testCustomerConstructorWithValidName(){
        String name = "Gosho";
        customer1 = new Customer(name, 1, 222);
        Assert.assertEquals(name, customer1.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCustomerConstructorWithInvalidNameEmptySpaces(){
        String name = "   ";
        customer1 = new Customer(name, 1, 222);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCustomerConstructorWithInvalidNameNull(){
        customer1 = new Customer(null, 1, 222);
    }

    @Test
    public void testCustomerConstructorWithValidBalance(){
        double balance = 400;
        customer1 = new Customer("Test", 1, balance);
        Assert.assertEquals(balance, customer1.getBalance(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCustomerConstructorWithInvalidBalance(){
        double balance = -1;
        customer1 = new Customer("Test", 1, balance);
    }

    @Test
    public void testSavingTransactionSend(){
        customer1.saveSendTransaction(transaction);
        Assert.assertEquals(transaction, customer1.getSendTransactionById(transaction.getId()));
    }

    @Test
    public void testSavingTransactionReceived(){
        customer1.saveReceivedTransaction(transaction);
        Assert.assertEquals(transaction, customer1.getReceivedTransactionById(transaction.getId()));
    }

    @Test
    public void testClearTransactionHistory(){
        customer1.saveReceivedTransaction(transaction);
        customer1.saveSendTransaction(transaction);
        Assert.assertEquals(1, customer1.getReceived().size());
        Assert.assertEquals(1, customer1.getSend().size());
        customer1.clearSendTransactionHistory();
        customer1.clearReceivedTransactionHistory();
        Assert.assertEquals(0, customer1.getSend().size());
        Assert.assertEquals(0, customer1.getReceived().size());
    }

    @Test
    public void testGetTransactionById(){
        customer1.saveSendTransaction(transaction);
        customer1.saveReceivedTransaction(transaction);
        Assert.assertEquals(transaction, customer1.getSendTransactionById(transaction.getId()));
        Assert.assertEquals(transaction, customer1.getReceivedTransactionById(transaction.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSendTransactionByIdWithInvalidId(){
        customer1.getSendTransactionById(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetReceivedTransactionByIdWithInvalidId(){
        customer1.getReceivedTransactionById(4);
    }

    @Test
    public void testRemoveTransactionById(){
        customer1.saveReceivedTransaction(transaction);
        customer1.saveSendTransaction(transaction);
        Assert.assertTrue(customer1.getReceived().contains(transaction));
        Assert.assertTrue(customer1.getSend().contains(transaction));
        customer1.removeReceivedTransactionById(transaction.getId());
        customer1.removeSendTransactionById(transaction.getId());
        Assert.assertFalse(customer1.getReceived().contains(transaction));
        Assert.assertFalse(customer1.getSend().contains(transaction));
    }

    @Test
    public void testGetters(){
        String name = "Test";
        long id = 1;
        double balance = 100;
        customer1 = new Customer(name, id, balance);
        Assert.assertEquals(customer1.getName(), name);
        Assert.assertEquals(id, customer1.getId());
        Assert.assertEquals(balance, customer1.getBalance(), 0.0);
    }

    @Test
    public void testSendTransactionWithEnoughMoney(){
        double balance = customer1.getBalance();
        customer1.sendTransaction(transaction);
        balance -= transaction.getAmount();
        Assert.assertEquals(balance, customer1.getBalance(), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSendTransactionWithNotEnoughMoney(){
        customer1.sendTransaction(new Transaction(1, 1000, customer1, customer2));
    }

    @Test
    public void testReceiveTransaction(){
        double balance = customer1.getBalance();
        customer1.receiveTransaction(transaction);
        balance += transaction.getAmount();
        Assert.assertEquals(balance, customer1.getBalance(), 0.0);
    }
}
