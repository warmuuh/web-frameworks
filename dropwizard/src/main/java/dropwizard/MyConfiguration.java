package dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class MyConfiguration extends Configuration {
  
	String name;
	
	
	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty
	public String getName() {
		return name;
	}
	
}