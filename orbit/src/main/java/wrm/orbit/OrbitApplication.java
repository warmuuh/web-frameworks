package wrm.orbit;


import java.lang.management.ManagementFactory;

import com.ea.orbit.container.Container;

public class OrbitApplication {

	public static void main(String[] args) throws Exception {

		Container container = new Container();
		container.start();
		System.out.println("Server started in "  + ManagementFactory.getRuntimeMXBean().getUptime() + "ms");
		
	}
}
