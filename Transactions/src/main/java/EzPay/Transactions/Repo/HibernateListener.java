package EzPay.Transactions.Repo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HibernateListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// Initialize the SessionFactory when the application starts
		HibernateUtil.getSessionFactory();
		System.out.println("SessionFactory initialized on application startup.");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// Shutdown the SessionFactory when the application stops
		HibernateUtil.shutdown();
		System.out.println("SessionFactory shut down on application shutdown.");
	}
}