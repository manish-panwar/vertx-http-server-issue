package issue;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by manishk on 11/24/2015.
 */
public class HttpServerIssueTest extends AbstractVerticle {

    // Convenience method so you can run it in your IDE
    public static void main(String[] args) {
        Runner.runExample(HttpServerIssueTest.class);
    }

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        router.get("/lookup/:lookupKey").handler(this::getPolicy);
        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }

    private void getPolicy(RoutingContext routingContext) {
        routingContext
                .response()
                .setChunked(true)
                .write("Lookup key is " + routingContext.request().getParam("lookupKey"))
                .end();
    }
}
