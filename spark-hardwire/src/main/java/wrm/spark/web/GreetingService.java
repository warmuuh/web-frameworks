package wrm.spark.web;

import javax.inject.Singleton;

@Singleton
public class GreetingService {

	public String getGreeting(String name) {
		return "Hello " + name;
	}

}
