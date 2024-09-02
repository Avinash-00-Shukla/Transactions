package EzPay.Transactions.Repo;

import java.sql.SQLException;
import java.util.List;

import EzPay.Transactions.Model.Transaction;
import EzPay.Transactions.Model.TransactionStatus;

public interface TransactionStatusFilterDAO {
    public List<Transaction> getTransactionsByStatus(TransactionStatus status) throws SQLException, ClassNotFoundException;
}