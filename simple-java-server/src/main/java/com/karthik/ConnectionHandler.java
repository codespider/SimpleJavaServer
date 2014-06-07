package com.karthik;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class ConnectionHandler extends Thread {
	private final Socket socket;

	public ConnectionHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.print("HTTP/1.1 200 OK\r\n");
			writer.print("Content-Type: text/html; charset=UTF-8\r\n\r\n");
			writer.println("<html> <body> <b>Hello Guru 123 </b> </body> </html>");
			writer.flush();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
