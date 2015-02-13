package com.test.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.CharBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*{  user:jiangwh }*/

public class Client {

	public static final Object locked = new Object();
	public static final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(
			1024 * 100);

	class ReceiveThread extends Thread {
		private Socket socket;

		public ReceiveThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {

			FileWriter fw;
			try {
				fw = new FileWriter("c:\\Test.txt");

				while (true) {
					try {
						Reader reader = new InputStreamReader(socket
								.getInputStream());
						char[] mychr = new char[1024];
						int index = 0;
						while ((index = reader.read(mychr)) != -1) {

							// System.out.println(charBuffer.toString());
							fw.write(mychr);
							fw.flush();
						}

					} catch (Exception e) {
						e.printStackTrace();

					}
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void start() throws UnknownHostException, IOException {
		Socket socket = new Socket("192.168.1.102", 33002);
		// new SendThread(socket).start();
		new ReceiveThread(socket).start();
	}

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		new Client().start();
	}
}
