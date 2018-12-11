package com.pinnet.jetty;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyStart {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8090);
        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setResourceBase("./");
        context.setDescriptor("./src/main/resources/web.xml");
        server.setHandler(context);
        server.start();
    }
}
