package wrm.spark;

import java.lang.management.ManagementFactory;

import wrm.spark.web.WebModule;

public class Application {

	public static void main(String[] args) {
		new WebModule().start();
		System.out.println("Server started in "  + ManagementFactory.getRuntimeMXBean().getUptime() + "ms");
		
	}
}
