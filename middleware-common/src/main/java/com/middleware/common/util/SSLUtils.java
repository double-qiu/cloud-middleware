package com.middleware.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLUtils {

    private static Logger logger = LoggerFactory.getLogger(SSLUtils.class);

    public static Socket getSocketInstance(SSLContext sslContext, int sslmode) {
        Socket socket = null;
        try {
            if (sslContext != null) {
                SSLSocketFactory factory = sslContext.getSocketFactory();
                socket = factory.createSocket();
                postSSLSocket((SSLSocket) socket, sslmode);
            }
        } catch (Exception e) {
            logger.error("create ssl socket error,start to use socket");
        }
        if (socket == null) {
            socket = new Socket();
        }
        return socket;
    }

    public static void postSSLSocket(SSLSocket socket, int sslmode) {
        String[] pwdsuits = socket.getSupportedCipherSuites();
        socket.setEnabledCipherSuites(pwdsuits);
        if (sslmode == 2) {
            //双向认证
            socket.setUseClientMode(false);
            socket.setNeedClientAuth(true);
        } else {
            socket.setUseClientMode(true);
            socket.setWantClientAuth(true);
        }
    }

    private static void postSSLServerSocket(SSLServerSocket sslServerSocket, int sslmode) {
        String[] pwdsuits = sslServerSocket.getSupportedCipherSuites();
        sslServerSocket.setEnabledCipherSuites(pwdsuits);
        sslServerSocket.setUseClientMode(false);
        if (sslmode == 2) {
            sslServerSocket.setNeedClientAuth(true);
        } else {
            sslServerSocket.setWantClientAuth(true);
        }
    }

    public static ServerSocket getServerSocketInstance(SSLContext sslContext, int sslmode) {
        ServerSocket serverSocket = null;
        try {
            if (sslContext != null) {
                SSLServerSocketFactory factory = sslContext.getServerSocketFactory();
                SSLServerSocket sslServerSocket = (SSLServerSocket) factory.createServerSocket();
                postSSLServerSocket(sslServerSocket, sslmode);
                sslServerSocket.setReuseAddress(true);
            }
        } catch (Exception e) {
            logger.error("create ssl server error,start to use socket");
        }
        try {
            serverSocket = new ServerSocket();
        } catch (Exception e) {
            logger.error("create ServerSocket error!");
        }
        return serverSocket;
    }
}