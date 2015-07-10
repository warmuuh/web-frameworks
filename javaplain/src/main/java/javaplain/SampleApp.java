package javaplain;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.management.ManagementFactory;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

public class SampleApp {
	
	public static void main(String[] args) throws Exception {
		System.out.println("jvmUptime: " + ManagementFactory.getRuntimeMXBean().getUptime() + "ms");
		
		HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
		server.setExecutor(Executors.newCachedThreadPool());
		
		server.createContext("/s", ex -> {
			System.out.println(ex.getRequestMethod() +" " + ex.getRequestURI());
			Headers rHeaders = ex.getResponseHeaders();
			rHeaders.set("Content-Type", "text/plain");
			ex.sendResponseHeaders(200, 0);
			
			try(OutputStream response  = ex.getResponseBody()){
				response.write("Hello world".getBytes());
			} catch (Exception e ){
				e.printStackTrace();
			}
		}).getFilters().add(new Filter(){
			@Override
			public String description() {
				return "Filter 1";
			}

			@Override
			public void doFilter(HttpExchange ex, Chain chain) throws IOException {
				System.out.println("Filter 1");
				chain.doFilter(ex);
			}});
		
		
		server.createContext("/s/s2", ex -> {
			System.out.println(ex.getRequestMethod() +" 2 " + ex.getRequestURI());
			Headers rHeaders = ex.getResponseHeaders();
			rHeaders.set("Content-Type", "text/plain");
			ex.sendResponseHeaders(200, 0);
			
			try(OutputStream response  = ex.getResponseBody()){
				response.write("Hello world2".getBytes());
			} catch (Exception e ){
				e.printStackTrace();
			}
		});
		server.start();
		System.out.println("Server started in "  + ManagementFactory.getRuntimeMXBean().getUptime() + "ms");
		
	}
}
