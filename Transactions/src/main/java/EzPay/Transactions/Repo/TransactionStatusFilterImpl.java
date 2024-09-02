package EzPay.Transactions.Repo;
 
import org.hibernate.Session;
import org.hibernate.query.Query;

import EzPay.Transactions.Model.Transaction;
import EzPay.Transactions.Model.TransactionStatus;
 
import java.util.List;

public class TransactionStatusFilterImpl {
  
    public List<Transaction> getTransactionsByStatus(TransactionStatus status) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Transaction> transactions = null;
        try { 
            String hql = "FROM Transaction WHERE status = :status";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("status", status);
            
            transactions = query.list();
        } catch (Exception e) { 
            e.printStackTrace();
        } finally { 
            session.close();
        }
        return transactions;
    } 
}
