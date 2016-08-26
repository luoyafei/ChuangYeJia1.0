package com.chuangyejia.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServiceDestoryListener
 *
 */
@WebListener
public class ServiceDestoryListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServiceDestoryListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	/**
    	 * 当服务器开启时，将SessionFactory创建出来
    	 */
    	//HibernateSessionFactory.createSessionFactory();
System.out.println("SessionFactory has been built!");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	// TODO Auto-generated method stub
    	/**
    	 * 当服务器关闭时，将SessionFactory关闭
    	 */
    	//HibernateSessionFactory.closeSessionFactory();
System.out.println("SessionFactory had been closed!");
    }
	
}
