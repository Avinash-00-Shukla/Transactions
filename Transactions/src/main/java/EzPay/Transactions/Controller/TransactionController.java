package EzPay.Transactions.Controller; 
import EzPay.Transactions.Service.*;

public class TransactionController { 
    
    private TransactionService transactionService; 
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    } 
}
