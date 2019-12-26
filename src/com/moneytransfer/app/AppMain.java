package com.moneytransfer.app;

import org.glassfish.jersey.server.ResourceConfig;

public class AppMain extends ResourceConfig {
	public AppMain() {
		packages("com.moneytransfer.services");
	}
}