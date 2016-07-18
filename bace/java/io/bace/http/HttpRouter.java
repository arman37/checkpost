package io.bace.http;

import io.bace.core.BaceRegistry;
import io.bace.http.handler.HttpReqResHandler;
import io.bace.http.handler.HttpRouteHandler;
import io.bace.http.handler.HttpRoutingContextHandler;
import io.vertx.core.http.HttpMethod;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class HttpRouter<R> {

    private Map<String, HttpRoute> mapOfHttpRoutes = new HashMap<>();
    private String mountPoint;

    public R subRouteOf(String mountPoint) {
        this.mountPoint = mountPoint;
        return (R)this;
    }

    public R get(String path, HttpReqResHandler handler) {
        registerHttpRoute(path, HttpMethod.GET, handler);
        return (R)this;
    }

    public R post(String path, HttpRoutingContextHandler handler) {
        registerHttpRoute(path, HttpMethod.POST, handler);
        return (R)this;
    }

    private R route(String path, HttpMethod httpMethod, HttpRouteHandler handler) {
        registerHttpRoute(path, httpMethod, handler);
        return (R)this;
    }

    public void registerHttpRoute(String path, HttpMethod httpMethod, HttpRouteHandler handler) {
        mapOfHttpRoutes.put(path, new HttpRoute(path, httpMethod, handler));
    }

    public static void register(Class<? extends HttpRouter> httpRouterClass) {
        BaceRegistry.registerHttpRouter(httpRouterClass);
    }
}
