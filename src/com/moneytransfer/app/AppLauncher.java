package com.moneytransfer.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class AppLauncher { 
    private static final String JERSEY_SERVLET_NAME = "jersey-container-servlet";
	
    public static void main(String[] args) throws Exception {
        new AppLauncher().start();
    }

    void start() throws Exception { 

        String port = System.getenv("PORT");
        if (port == null || port.isEmpty()) {
            port = "8080";
        }

        Server server = new Server(Integer.valueOf(port));
        ServletContextHandler context = new ServletContextHandler(server, "/");

        ServletHolder servlet = new ServletHolder(JERSEY_SERVLET_NAME,
                new ServletContainer(new AppMain()));
        context.addServlet(servlet, "/api/*");

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            // log exception
        }
    }	
}
