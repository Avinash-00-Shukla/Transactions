package EzPay.Transactions.Test; 
 

import EzPay.Transactions.Service.TransactionService;

public class TransactionControllerTest { 
	    private TransactionService service;   
        public void setUp() {
            service = new TransactionService();
        }
}
