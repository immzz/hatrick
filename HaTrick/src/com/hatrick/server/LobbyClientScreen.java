package com.hatrick.server;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class LobbyClientScreen extends JPanel {

	private final static int MAX_ROOM_LIST = 30;

	private JFrame frame;
	private JPanel option;
	
	private JButton[] roomListButton = new JButton[MAX_ROOM_LIST];
	private JPanel[] roomPanel = new JPanel[MAX_ROOM_LIST];
	private int currentRoomSize = 0;

	private ArrayList<Room> roomList = new ArrayList<Room>();

	LobbyClientScreen(){


		//create panel and frame
		frame = new JFrame("Game Lobby");


		//outlook on surface
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel") ;
		}catch (Exception e) {
			System.err.println("Oops!  Something went wrong!");
		}
		SwingUtilities.updateComponentTreeUI(frame);


		//room list button
		for(int i = 0; i < MAX_ROOM_LIST; i++){
			roomListButton[i] = new JButton("选择房间:" + i );
			roomListButton[i].setPreferredSize(new Dimension(100,70));
			roomPanel[i] = new JPanel(new BorderLayout());
			roomPanel[i].setBorder(new TitledBorder(""));
		}

		//layout
		this.setLayout(new GridLayout(MAX_ROOM_LIST, 1));

		//option
		option = new JPanel();

		//room is created
		//Room room = new Room();

		//set layout
		option.setLayout(new GridLayout(1, 10, 50, 50));

		//create button
		JButton createButton = new JButton("创建房间");
		JButton enterButton = new JButton("进入房间");
		JButton quitButton = new JButton("退出游戏");

		//create panel
		JPanel createPanel = new JPanel();
		JPanel enterPanel = new JPanel();
		JPanel quitPanel = new JPanel();

		//button setting
		createButton.setPreferredSize(new Dimension(150, 30));
		enterButton.setPreferredSize(new Dimension(150, 30));
		quitButton.setPreferredSize(new Dimension(150, 30));
		createButton.setToolTipText("你可以创建一个新的房间");
		enterButton.setToolTipText("选择一个房间然后点击加入");
		quitButton.setToolTipText("点击退出游戏");
		//createButton.setSize(100, 200);
		//enterButton.setSize(50, 80);
		//quitButton.setSize(100, 50);

		//button action
		quitAction quitlistener = new quitAction();
		quitButton.addActionListener(quitlistener);

		//button panel's border
		createPanel.setBorder(BorderFactory.createTitledBorder(""));
		enterPanel.setBorder(BorderFactory.createTitledBorder(""));
		quitPanel.setBorder(BorderFactory.createTitledBorder(""));
		//createButton.setBorder(BorderFactory.createTitledBorder(""));
		//createPanel.add(createButton);

		//lobby panel
		JPanel lobbyPanel = new JPanel();
		lobbyPanel.setBorder(new TitledBorder(""));
		lobbyPanel.add(this,BorderLayout.CENTER);


		//add button
		option.add(createButton);
		option.add(enterButton);
		option.add(quitButton);

		// title of option
		JPanel optionOuter = new JPanel();
		optionOuter.setLayout(new BorderLayout());
		optionOuter.setBorder(new TitledBorder(""));
		JLabel welcomeLabel =  new JLabel("Welcome to BTOOOM Game!",SwingConstants.CENTER);
		welcomeLabel.setBackground(Color.LIGHT_GRAY);
		welcomeLabel.setFont(new Font("",Font.BOLD,23));
		//welcomeTextField.set
		optionOuter.add(welcomeLabel,BorderLayout.NORTH);
		optionOuter.add(option,BorderLayout.CENTER);

		//frame add
		frame.add(new JScrollPane(optionOuter),BorderLayout.NORTH);
		frame.add(new JScrollPane(lobbyPanel),BorderLayout.CENTER);

		this.addnewRoom( new Room());
		this.addnewRoom( new Room());
		this.addnewRoom( new Room());
		this.addnewRoom( new Room());
		this.addnewRoom( new Room());
		this.addnewRoom( new Room());
		this.addnewRoom( new Room());
		this.addnewRoom( new Room());
		this.addnewRoom( new Room());

		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


		//new Thread(lobby).start();

	}
	public void addnewRoom(Room r) {
		// TODO Auto-generated method stub
		JTextArea textarea = new JTextArea("房间号：			房主名：" +
				"\n当前人数:			是否满员：" +
				"\n房间状态：");
		textarea.setPreferredSize(new Dimension(550,70));
		textarea.setEditable(false);
		textarea.setBackground(Color.LIGHT_GRAY);
		textarea.setOpaque(true);
		roomPanel[currentRoomSize].add(textarea,BorderLayout.CENTER);
		roomPanel[currentRoomSize].add(roomListButton[currentRoomSize],BorderLayout.EAST);
		//roomPanel[currentRoomSize].setOpaque(false);
		//roomPanel[currentRoomSize].setBackground(Color.YELLOW);
		this.add( roomPanel[currentRoomSize]);
		roomList.add( r );
		currentRoomSize++;
	}

	public static void main(String[] args){


		//lobby and option
		LobbyClientScreen lobby = new LobbyClientScreen();

	}



}
class quitAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//send message to quit

		//action quit the main
		System.exit(-1);
	}

}
