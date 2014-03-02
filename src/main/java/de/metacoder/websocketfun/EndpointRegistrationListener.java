package de.metacoder.websocketfun;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.websocket.DeploymentException;
import javax.websocket.server.ServerContainer;

public class EndpointRegistrationListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("registering endpoint");
		ServerContainer container = (ServerContainer) sce.getServletContext().getAttribute("javax.websocket.server.ServerContainer");
		try {
			container.addEndpoint(TestServerEndpoint.class);
		} catch (DeploymentException e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
