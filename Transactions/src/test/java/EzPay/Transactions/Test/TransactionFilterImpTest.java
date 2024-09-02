package EzPay.Transactions.Test;

import org.hibernate.Session;
import org.junit.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.Assert.*;

import EzPay.Transactions.Model.Transaction;
import EzPay.Transactions.Model.TransactionMode;
import EzPay.Transactions.Model.TransactionType;
import EzPay.Transactions.Repo.HibernateUtil;
import EzPay.Transactions.Repo.TransactionFiltersImpl;

public class TransactionFilterImpTest {

    private static TransactionFiltersImpl transactionFilters;
    private static Session session;

    @BeforeClass
    public static void setupClass() {
        transactionFilters = new TransactionFiltersImpl();
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
    public void testGetTransactionsByDateRange() throws SQLException {
        LocalDateTime startDate = LocalDateTime.of(2024, 8, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, 8, 31, 23, 59);

        List<Transaction> transactions = transactionFilters.getTransactionsByDateRange(startDate, endDate);

        assertNotNull(transactions);
        // Replace with the expected size or other relevant checks
        assertTrue(transactions.size() > 0);
        assertEquals("TXN001", transactions.get(0).getTransactionId());
    }

    @Test
    public void testGetTransactionsByAmount() throws SQLException {
        double amount = 500.00;

        List<Transaction> transactions = transactionFilters.getTransactionsByAmount(amount);

        assertNotNull(transactions); 
        assertTrue(transactions.size() > 0);
        assertTrue(transactions.stream().allMatch(t -> t.getAmount() == amount));
    }

    @Test
    public void testGetTransactionsByMinAmount() throws SQLException {
        double minAmount = 1000.00;

        List<Transaction> transactions = transactionFilters.getTransactionsByMinAmount(minAmount);

        assertNotNull(transactions);
        assertTrue(transactions.size() > 0);
        assertTrue(transactions.stream().allMatch(t -> t.getAmount() >= minAmount));
    }

    @Test
    public void testGetTransactionsByMaxAmount() throws SQLException {
        double maxAmount = 1000.00;

        List<Transaction> transactions = transactionFilters.getTransactionsByMaxAmount(maxAmount);

        assertNotNull(transactions);
        assertTrue(transactions.size() > 0);
        assertTrue(transactions.stream().allMatch(t -> t.getAmount() <= maxAmount));
    }

    @Test
    public void testGetTransactionsByType() throws SQLException {
        TransactionType type = TransactionType.CREDIT;

        List<Transaction> transactions = transactionFilters.getTransactionsByType(type);

        assertNotNull(transactions);
        assertTrue(transactions.size() > 0);
        assertTrue(transactions.stream().allMatch(t -> t.getType() == type));
    }

    @Test
    public void testGetTransactionsByMode() throws SQLException {
        TransactionMode mode = TransactionMode.CREDIT_CARD;

        List<Transaction> transactions = transactionFilters.getTransactionsByMode(mode);

        assertNotNull(transactions);
        assertTrue(transactions.size() > 0);
        assertTrue(transactions.stream().allMatch(t -> t.getMode() == mode));
    }

    @Test
    public void testGetTransactionsByDescription() throws SQLException {
        String keyword = "services";

        List<Transaction> transactions = transactionFilters.getTransactionsByDescription(keyword);

        assertNotNull(transactions);
        assertTrue(transactions.size() > 0);
        assertTrue(transactions.stream().allMatch(t -> t.getDescription().toLowerCase().contains(keyword.toLowerCase())));
    }

    @Test
    public void testGetTransactionByTransactionId() throws SQLException {
        String transactionId = "TXN001";

        List<Transaction> transactions = transactionFilters.getTransactionByTransactionId(transactionId);

        assertNotNull(transactions);
        assertEquals(1, transactions.size());
        assertEquals(transactionId, transactions.get(0).getTransactionId());
    }

    @Test
    public void testGetTransactionsBySenderAccount() throws SQLException {
        String senderAccount = "ACC001";

        List<Transaction> transactions = transactionFilters.getTransactionsBySenderAccount(senderAccount);

        assertNotNull(transactions);
        assertTrue(transactions.size() > 0);
        assertTrue(transactions.stream().allMatch(t -> t.getSenderAccount().equals(senderAccount)));
    }

    @Test
    public void testGetTransactionsByReceiverAccount() throws SQLException {
        String receiverAccount = "ACC002";

        List<Transaction> transactions = transactionFilters.getTransactionsByReceiverAccount(receiverAccount);

        assertNotNull(transactions);
        assertTrue(transactions.size() > 0);
        assertTrue(transactions.stream().allMatch(t -> t.getRecieverAccount().equals(receiverAccount)));
    }

    @Test
    public void testGetTransactionsByCurrency() throws SQLException {
        String currency = "USD";

        List<Transaction> transactions = transactionFilters.getTransactionsByCurrency(currency);

        assertNotNull(transactions);
        assertTrue(transactions.size() > 0);
        assertTrue(transactions.stream().allMatch(t -> t.getCurrency().equals(currency)));
    }

    @Test
    public void testGetAllTransactions() throws SQLException {
        List<Transaction> transactions = transactionFilters.getAllTransactions();

        assertNotNull(transactions);
        // Adjust the expected size based on your test data
        assertTrue(transactions.size() > 0);
    }
}
