package EzPay.Transactions.Repo;
 
import java.time.LocalDateTime;
import java.util.List;
 

import org.hibernate.Session;
import org.hibernate.query.Query;

import EzPay.Transactions.Model.Transaction;
import EzPay.Transactions.Model.TransactionMode;
import EzPay.Transactions.Model.TransactionType;

public class TransactionFiltersImpl implements TransactionFiltersDAO {

    @Override
    public List<Transaction> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Transaction WHERE date BETWEEN :startDate AND :endDate";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            return query.getResultList();
        }
    }

    @Override
    public List<Transaction> getTransactionsByAmount(double amount) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Transaction WHERE amount = :amount";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("amount", amount);
            return query.getResultList();
        }
    }

    @Override
    public List<Transaction> getTransactionsByMinAmount(double minAmount) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Transaction WHERE amount >= :minAmount";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("minAmount", minAmount);
            return query.getResultList();
        }
    }

    @Override
    public List<Transaction> getTransactionsByMaxAmount(double maxAmount) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Transaction WHERE amount <= :maxAmount";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("maxAmount", maxAmount);
            return query.getResultList();
        }
    }

    @Override
    public List<Transaction> getTransactionsByType(TransactionType type) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Transaction WHERE type = :type";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("type", type);
            return query.getResultList();
        }
    }

    @Override
    public List<Transaction> getTransactionsByMode(TransactionMode mode) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Transaction WHERE mode = :mode";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("mode", mode);
            return query.getResultList();
        }
    }

    @Override
    public List<Transaction> getTransactionsByDescription(String descriptionKeyword) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Transaction WHERE UPPER(description) LIKE UPPER(:descriptionKeyword)";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("descriptionKeyword", "%" + descriptionKeyword + "%");
            return query.getResultList();
        }
    }

    @Override
    public List<Transaction> getTransactionByTransactionId(String transactionId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Transaction WHERE transactionId = :transactionId";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("transactionId", transactionId);
            return query.getResultList();
        }
    }

    @Override
    public List<Transaction> getTransactionsBySenderAccount(String senderAccount) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Transaction WHERE senderAccount = :senderAccount";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("senderAccount", senderAccount);
            return query.getResultList();
        }
    }

    @Override
    public List<Transaction> getTransactionsByReceiverAccount(String receiverAccount) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Transaction WHERE recieverAccount = :receiverAccount";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("receiverAccount", receiverAccount);
            return query.getResultList();
        }
    }

    @Override
    public List<Transaction> getTransactionsByCurrency(String currency) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Transaction WHERE currency = :currency";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            query.setParameter("currency", currency);
            return query.getResultList();
        }
    }

    @Override
    public List<Transaction> getAllTransactions() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Transaction";
            Query<Transaction> query = session.createQuery(hql, Transaction.class);
            return query.getResultList();
        }
    } 
}
