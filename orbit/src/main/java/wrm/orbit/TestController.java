package wrm.orbit;


import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.ea.orbit.container.Startable;

@Singleton
@Path("/")
public class TestController implements Startable {

	
	@Inject 
	TestService service;
	
	@GET
	public String getRoot(){
		return service.getMessage();
	}
	
	
}
