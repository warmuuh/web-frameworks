package wrm.spark.web;

import static spark.Spark.*;

public class WebModule extends Container{

	@Override
	protected void onStart() {
		port(8080);
	}
	
	@Override
	protected void onInitialized() {
		awaitInitialization();
	}
	
}
