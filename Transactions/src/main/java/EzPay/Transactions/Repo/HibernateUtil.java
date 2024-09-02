package EzPay.Transactions.Repo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import EzPay.Transactions.Model.Transaction;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            // Create the StandardServiceRegistry
            StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();

            // Create MetadataSources
            MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

            // Add annotated class
            metadataSources.addAnnotatedClass(Transaction.class);

            // Create Metadata
            Metadata metadata = metadataSources.getMetadataBuilder().build();

            // Create SessionFactory
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
