package EzPay.Transactions.Test; 
import org.junit.BeforeClass;

import EzPay.Transactions.Service.TransactionService;

public class TransactionRepositoryTest {
    private TransactionService service;

    @BeforeClass
    public void setUp() {
        service = new TransactionService();
    }
}
