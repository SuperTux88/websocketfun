package de.metacoder.websocketfun;

import java.io.IOException;
import java.util.Date;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/foo")
public class TestServerEndpoint {

	private Session socketSession;

	public TestServerEndpoint(){
		System.out.println("================== SERVER ENDPOINT");
	}

	@OnOpen public void onOpen(final Session socketSession){
		System.out.println("Websocket session open " + socketSession);
		this.socketSession = socketSession;
		new Thread(new Runnable() {
			
			public void run() {
				while (true) {
					socketSession.getAsyncRemote().sendText(new Date().toString());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	@OnMessage public void onMessage(String msg) throws IOException {
		System.out.println("received message " + msg);
		socketSession.getAsyncRemote().sendText("Greetings " + msg);
	}
	
	@OnError public void onError(Throwable t){
		t.printStackTrace();
	}
	
	@OnClose public void onClose(CloseReason reason){
		System.out.println("Closing - reason: " + reason);
	}
	
}
