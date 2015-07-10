package demo;

import java.lang.management.ManagementFactory;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements ApplicationListener<ContextRefreshedEvent> {

	@RequestMapping("/")
	public String getStuff(){
		return "Hello World";
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		System.out.println("Server started in "  + ManagementFactory.getRuntimeMXBean().getUptime() + "ms");
	}
}
