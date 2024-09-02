package EzPay.Transactions.Test;

import org.hibernate.Session; 
import org.junit.*;
import java.util.List;
import static org.junit.Assert.*;

import EzPay.Transactions.Model.Transaction;
import EzPay.Transactions.Model.TransactionStatus;
import EzPay.Transactions.Repo.HibernateUtil;
import EzPay.Transactions.Repo.TransactionStatusFilterImpl;

public class TransactionStatusImplTest {
    private static TransactionStatusFilterImpl transactionFilters;
    private static Session session;

    @BeforeClass
    public static void setupClass() {
        transactionFilters = new TransactionStatusFilterImpl();
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @AfterClass
    public static void tearDownClass() {
        if (session != null && session.isOpen()) {
            session.close();
        }
        HibernateUtil.shutdown();
    }

    @Test
    public void testGetTransactionsByStatusSUCCESS() {
        TransactionStatus status = TransactionStatus.SUCCESS;
        List<Transaction> transactions = transactionFilters.getTransactionsByStatus(status);

        assertNotNull(transactions);
        assertTrue(!transactions.isEmpty());
        assertTrue(transactions.stream().allMatch(t -> t.getStatus() == status));
    }

    @Test
    public void testGetTransactionsByStatusFAILED() {
        TransactionStatus status = TransactionStatus.FAILED;
        List<Transaction> transactions = transactionFilters.getTransactionsByStatus(status);

        assertNotNull(transactions);
        assertTrue(!transactions.isEmpty());
        assertTrue(transactions.stream().allMatch(t -> t.getStatus() == status));
    }

    @Test
    public void testGetTransactionsByStatusCANCELLED() {
        TransactionStatus status = TransactionStatus.CANCELLED;
        List<Transaction> transactions = transactionFilters.getTransactionsByStatus(status);

        assertNotNull(transactions);
        assertTrue(!transactions.isEmpty());
        assertTrue(transactions.stream().allMatch(t -> t.getStatus() == status));
    }

    @Test
    public void testGetTransactionsByStatusPENDING() {
        TransactionStatus status = TransactionStatus.PENDING;
        List<Transaction> transactions = transactionFilters.getTransactionsByStatus(status);

        assertNotNull(transactions);
        assertTrue(!transactions.isEmpty());
        assertTrue(transactions.stream().allMatch(t -> t.getStatus() == status));
    }
}
