package wrm.spark.web;

import static spark.Spark.get;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.Data;
import spark.Request;
import spark.Response;

@Singleton
@Data
public class Controller {

	@Inject
	GreetingService service;
	
	
	
	@PostConstruct
	void init(){
		get("/hello/:name", this::greeting);
	}
	
	
	public String greeting(Request req, Response res){
		return service.getGreeting(req.params("name"));
	}
	
	
	
}
