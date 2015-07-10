package dropwizard;

import java.lang.management.ManagementFactory;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class DropwizardApplication extends Application<MyConfiguration> {

	public static void main(String[] args) throws Exception{
		new DropwizardApplication().run(args);
	}
	
	
	@Override
	public String getName() {
		return "HelloWorld";
	}


	@Override
	public void run(MyConfiguration cfg, Environment env) throws Exception {
		env.jersey().register(new HelloWorldResource());
		System.out.println("Server started in "  + ManagementFactory.getRuntimeMXBean().getUptime() + "ms");
	}
}
