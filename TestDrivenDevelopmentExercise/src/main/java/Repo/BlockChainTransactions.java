package main.java.Repo;

import main.java.Transaction.Transaction;

public interface BlockChainOperations {
    Transaction createTransaction(long id, double amount, String sender, String receiver);
    void makeTransaction(Transaction transaction);
    void printTransactionHistory();
    void printUserData(String name);
}
