package com.hatrick.test;



import com.hatrick.graphic.*;
import com.hatrick.logic.ServerLogic;
import com.hatrick.server.Server;

public class IntegratedTestServer{

	public IntegratedTestServer() {
	}

	public static void main(String [] args){
		new Thread(new Server()).start();
		Map map = new Map(Map.SNOW);
		ServerLogic.initMap(map.getHeight(), map.getWidth(), map.getAssets());
		new Thread(new ServerLogic()).start();
	}

}