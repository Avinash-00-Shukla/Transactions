package EzPay.Transactions.Service;

import EzPay.Transactions.Model.Transaction;
import EzPay.Transactions.Model.TransactionMode;
import EzPay.Transactions.Model.TransactionStatus;
import EzPay.Transactions.Model.TransactionType;
import EzPay.Transactions.Repo.TransactionFiltersImpl;
import EzPay.Transactions.Repo.TransactionStatusFilterImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
 
 
public class TransactionService {

    private TransactionFiltersImpl transactionFilters;
    private TransactionStatusFilterImpl transactionStatusFilter;

    // Constructor
    public TransactionService() { 
        transactionFilters = new TransactionFiltersImpl();
        transactionStatusFilter = new TransactionStatusFilterImpl();
    } 

    // Filter transactions by a specific date range
    public List<Transaction> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate) throws SQLException, ClassNotFoundException{
        return transactionFilters.getTransactionsByDateRange(startDate, endDate);
    }

    // Filter transactions by exact amount
    public List<Transaction> getTransactionsByExactAmount(double amount) throws SQLException, ClassNotFoundException{
        return transactionFilters.getTransactionsByAmount(amount);
    }

    // Filter transactions by minimum amount
    public List<Transaction> getTransactionsByMinAmount(double minAmount) throws SQLException, ClassNotFoundException{
        return transactionFilters.getTransactionsByMinAmount(minAmount);
    }

    // Filter transactions by maximum amount
    public List<Transaction> getTransactionsByMaxAmount(double maxAmount) throws SQLException, ClassNotFoundException{
        return transactionFilters.getTransactionsByMaxAmount(maxAmount);
    }

    // Filter transactions by transaction type
    public List<Transaction> getTransactionsByType(TransactionType type) throws SQLException, ClassNotFoundException{
        return transactionFilters.getTransactionsByType(type);
    }

    // Filter transactions by transaction status
    public List<Transaction> getTransactionsByStatus(TransactionStatus status) throws SQLException, ClassNotFoundException{
        return transactionStatusFilter.getTransactionsByStatus(status);
    }

    // Filter transactions by transaction mode
    public List<Transaction> getTransactionsByMode(TransactionMode mode) throws SQLException, ClassNotFoundException{
        return transactionFilters.getTransactionsByMode(mode);
    }

    // Filter transactions by description (contains keywords)
    public List<Transaction> getTransactionsByDescription(String descriptionKeyword) throws SQLException, ClassNotFoundException{
        return transactionFilters.getTransactionsByDescription(descriptionKeyword);
    }

    // Retrieve a specific transaction by its ID
    public List<Transaction> getTransactionByTransactionId(String transactionId) throws SQLException, ClassNotFoundException{
        return transactionFilters.getTransactionByTransactionId(transactionId);
    }

    // Filter transactions by sender account number
    public List<Transaction> getTransactionsBySenderAccount(String senderAccount) throws SQLException, ClassNotFoundException{
        return transactionFilters.getTransactionsBySenderAccount(senderAccount);
    }

    // Filter transactions by receiver account number
    public List<Transaction> getTransactionsByReceiverAccount(String receiverAccount) throws SQLException, ClassNotFoundException{
        return transactionFilters.getTransactionsByReceiverAccount(receiverAccount);
    } 

    // Filter transactions by currency type
    public List<Transaction> getTransactionsByCurrency(String currency) throws SQLException, ClassNotFoundException{
        return transactionFilters.getTransactionsByCurrency(currency);
    }

    // To get all transactions
    public List<Transaction> getAllTransactions() throws SQLException, ClassNotFoundException{
        return transactionFilters.getAllTransactions();
    }
}
