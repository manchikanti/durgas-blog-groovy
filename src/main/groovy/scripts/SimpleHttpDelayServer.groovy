#!/usr/bin/env groovy
package scripts

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer

import java.util.concurrent.Executors

/**
 * This script can be used to test how long client can wait for response
 * To test connection timeout in application client or timeouts by proxies
 */
int port = 1234
int numberOfThreads = 20
server = HttpServer.create(new InetSocketAddress(port), 0)
server.createContext("/delayInSecs", new HttpHandler() {
    @Override
    void handle(HttpExchange httpExchange) throws IOException {
        String requestURI = httpExchange.requestURI
        byte[] messageBytes
        try {
            int startPoint = '/delayInSecs/'.length()
            //Extracting delay can be handled better...
            Integer waitTimeInSecs = requestURI[startPoint..-1] as Integer
            String requestId = UUID.randomUUID()
            println "${new Date()} :: Request Id:${requestId}  Waiting for ${waitTimeInSecs}"
            Thread.sleep(waitTimeInSecs * 1000)
            println "Request Id:${requestId}  Waited for ${waitTimeInSecs}"
            messageBytes = "${new Date()} :: Waited ${waitTimeInSecs} seconds.. ".bytes
            httpExchange.sendResponseHeaders(200, messageBytes.length)
        } catch (NumberFormatException nfe) {
            messageBytes = "request should be like /delayInSecs/123".bytes
            httpExchange.sendResponseHeaders(500, messageBytes.length)
        } catch (Exception e) {
            e.printStackTrace()
            messageBytes = "Error: ${e.message}".bytes
            httpExchange.sendResponseHeaders(500, messageBytes.length)
        }
        OutputStream outputStream
        try {
            outputStream = httpExchange.getResponseBody()
            outputStream.write(messageBytes)
        } finally {
            outputStream.flush()
            outputStream?.close()
        }
    }
})
server.setExecutor(Executors.newFixedThreadPool(20))
server.start()

