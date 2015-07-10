package spark;

import static spark.Spark.get;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.ea.orbit.concurrent.Task;
import com.ea.orbit.container.Startable;

@Singleton
public class TestController implements Startable {

	
	@Inject 
	TestService service;
	
	public Task<?> start(){
		get("/", this::getRoot);
		return Task.done();
	}
	
	
	public String getRoot(Request req, Response res){
		return service.getMessage();
	}
	
	
}
