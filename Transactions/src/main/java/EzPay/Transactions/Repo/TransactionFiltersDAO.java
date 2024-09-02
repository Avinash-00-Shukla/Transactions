package EzPay.Transactions.Repo;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import EzPay.Transactions.Model.Transaction;
import EzPay.Transactions.Model.TransactionMode;
import EzPay.Transactions.Model.TransactionType;

public interface TransactionFiltersDAO {
    public List<Transaction> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate) throws SQLException, ClassNotFoundException;
    public List<Transaction> getTransactionsByAmount(double amount) throws SQLException, ClassNotFoundException;
    public List<Transaction> getTransactionsByMinAmount(double minAmount) throws SQLException, ClassNotFoundException;
    public List<Transaction> getTransactionsByMaxAmount(double maxAmount) throws SQLException, ClassNotFoundException;
    public List<Transaction> getTransactionsByType(TransactionType type) throws SQLException, ClassNotFoundException;
    public List<Transaction> getTransactionsByMode(TransactionMode mode) throws SQLException, ClassNotFoundException;
    public List<Transaction> getTransactionsByDescription(String descriptionKeyword) throws SQLException, ClassNotFoundException;
    public List<Transaction> getTransactionByTransactionId(String transactionId) throws SQLException, ClassNotFoundException;
    public List<Transaction> getTransactionsBySenderAccount(String senderAccount) throws SQLException, ClassNotFoundException;
    public List<Transaction> getTransactionsByReceiverAccount(String receiverAccount) throws SQLException, ClassNotFoundException;
    public List<Transaction> getTransactionsByCurrency(String currency) throws SQLException, ClassNotFoundException;
    public List<Transaction> getAllTransactions() throws SQLException, ClassNotFoundException;
}