package main.java.Repo;

import main.java.Customer.Customer;
import main.java.Repo.BlockChainUserCommands;

import java.util.List;

public class BlockChainRepository implements BlockChainUserCommands {
    public static long TRANSACTION_ID;

    private List<Transaction> transaction;
    private List<Customer> customers;

    @Override
    public void registerNewUser(String name, double amount){
        Customer customer = new Customer(name, this.customers.size() + 1, amount);
        customers.add(customer);
    }

    @Override
    public void removeUser(String name) {

    }

    @Override
    public Customer getUserByName(String name) {
        for (Customer c : customers) {
            if (c.getName().equals(name)){
                return c;
            }
        }
        throw new IllegalArgumentException("No such user");
    }

    @Override
    public Customer getUserById(long id) {
        for (Customer c : customers) {
            if (c.getId() == id){
                return c;
            }
        }
        throw new IllegalArgumentException("No such user");
    }
}
