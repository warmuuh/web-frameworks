package wrm.ratpack;

import java.lang.management.ManagementFactory;

import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;
 
public class Application {
	public static void main(String[] args) throws Exception {
		System.out.println("Starting...");
		RatpackServer.start(spec -> spec
				.handlers(chain -> chain
								.get(ctx -> {
									ctx.render("Hello !");
								})
								.get(":name", ctx -> {
									String name = ctx.getPathTokens().get("name");
									ctx.render("Hello " + name);
								})));
		System.out.println("Server started in "  + ManagementFactory.getRuntimeMXBean().getUptime() + "ms");
	}
}
