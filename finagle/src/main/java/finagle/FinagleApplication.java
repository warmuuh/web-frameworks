package finagle;

import java.lang.management.ManagementFactory;

import com.twitter.finagle.Httpx;
import com.twitter.finagle.ListeningServer;
import com.twitter.finagle.Service;
import com.twitter.finagle.httpx.Request;
import com.twitter.finagle.httpx.Response;
import com.twitter.finagle.httpx.Status;
import com.twitter.util.Await;
import com.twitter.util.Future;

public class FinagleApplication {

	public static void main(String[] args) throws Exception {
		
		Service<Request, Response> service = new Service<Request, Response>() {

			@Override
			public Future<Response> apply(Request req) {
				Response response = Response.apply(req.version(), Status.Ok());
				response.getHttpResponse().getContent().writeBytes("Hello World".getBytes());
				return Future.value(response);
			}
		};
		
		ListeningServer server = Httpx.serve(":8080", service);
		Await.ready(server);
		System.out.println("Server started in "  + ManagementFactory.getRuntimeMXBean().getUptime() + "ms");
	}
}
