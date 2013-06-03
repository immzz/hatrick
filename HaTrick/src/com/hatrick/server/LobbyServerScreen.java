package com.hatrick.server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LobbyServerScreen {

	JFrame roomframe;
	JPanel userlistPanel;
	JPanel roomPanel;
	
	
	LobbyServerScreen (){
		roomframe = new JFrame("Game Center of Server");
		roomframe.setLayout(new GridLayout(1,2,5,5));
		
		//outlook on surface
		try{
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel") ;
		}catch (Exception e) {
		    System.err.println("Oops!  Something went wrong!");
		}
		SwingUtilities.updateComponentTreeUI(roomframe);
		
		//new panel
		userlistPanel = new JPanel();
		roomPanel = new JPanel();
		
		//panel layout
		userlistPanel.setLayout(new GridLayout(30,1,5,5));
		roomPanel.setLayout(new GridLayout(30,1,5,5));
		
		//add button
		JButton jb1 = new JButton("某用户1");
		jb1.setPreferredSize(new Dimension(100,50));
		userlistPanel.add(jb1);
		userlistPanel.add(new JButton("某用户2"));
		userlistPanel.add(new JButton("某用户3"));
		JButton rb1 = new JButton("某房间1");
		rb1.setPreferredSize(new Dimension(100,50));
		roomPanel.add(rb1);
		roomPanel.add(new JButton("某房间2"));
		roomPanel.add(new JButton("某房间3"));
		roomPanel.add(new JButton("某房间4"));
		
		//add panel
		roomframe.add(new JScrollPane(userlistPanel));
		roomframe.add(new JScrollPane(roomPanel));
		
		roomframe.setSize(800,600);
		roomframe.setLocationRelativeTo(null);
		roomframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		roomframe.setVisible(true);
	}
	
	
	public static void main(String[] args){
		
		LobbyServerScreen lsScreen = new LobbyServerScreen();
		
		
		
		
	}
	
}
