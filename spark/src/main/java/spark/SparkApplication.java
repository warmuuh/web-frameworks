package spark;

import java.lang.management.ManagementFactory;

import com.ea.orbit.container.Container;

public class SparkApplication {

	public static void main(String[] args) throws Exception {

		Spark.port(8080);
		Container container = new Container();
		container.start();
//		
		Spark.awaitInitialization();
		System.out.println("Server started in "  + ManagementFactory.getRuntimeMXBean().getUptime() + "ms");
//		
//		container.join();
//				com.ea.orbit.container.Bootstrap.main(args);
//		get("/", (req, res) -> {
//			return "Hello World";
//		});
//		
		
	}
}
