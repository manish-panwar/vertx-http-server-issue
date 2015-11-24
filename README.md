# vertx-http-server-issue with version 3.1.0
Issue with Vertx 3.1.0 HTTP Server when we access the URL with special characters in it.

# What's the issue
  
  When starting server in vertx 3.1.0 following URL return 404(execute HttpServerIssueTest class which starts the server on 8080).
    
    http://localhost:8080/lookup/Apple-iPhone%3B%20AWInbox%2FiOS%2F2.1.0
  
  This URL has 2 components.
    
    http://localhost:8080/{context path}/{lookup key}
    
    In above example, "Apple-iPhone%3B%20AWInbox%2FiOS%2F2.1.0" is the look-up key.
    
  When same URL is executed against Vertx 3.0.0 then it works fine(change vertx version in pom.xml and restart HttpServerIssueTest).