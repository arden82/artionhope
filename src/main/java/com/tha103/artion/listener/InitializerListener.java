package com.tha103.artion.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.tha103.artion.util.HibernateUtil;
import com.tha103.artion.util.JedisUtil;


public class InitializerListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {  //web啟動時，產生session factory，hibernatUtil.java
		System.out.println("context started");
		HibernateUtil.getSessionFactory();  //載入HibernateUtil工具類別
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context ended");
		HibernateUtil.shutdown();
		JedisUtil.shutdownJedisPool();
	}

}
