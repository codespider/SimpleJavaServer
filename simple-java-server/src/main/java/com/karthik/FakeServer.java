package com.karthik;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FakeServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(7050);
		while (true) {
			Socket s = serverSocket.accept();
			new ConnectionHandler(s).start();
		}
	}

}
