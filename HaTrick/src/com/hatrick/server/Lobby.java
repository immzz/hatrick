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

public class Lobby extends JPanel {
	
	private final static int MAX_ROOM_LIST = 30;
	
	private JButton[] roomListButton = new JButton[MAX_ROOM_LIST];
	private JPanel[] roomPanel = new JPanel[MAX_ROOM_LIST];
	private int currentRoomSize = 0;
	
	private ArrayList<Room> roomList = new ArrayList<Room>();
	
	Lobby(){
		
		//room list button
		for(int i = 0; i < MAX_ROOM_LIST; i++){
			roomListButton[i] = new JButton("ѡ�񷿼�:" + i );
			roomListButton[i].setPreferredSize(new Dimension(100,70));
			roomPanel[i] = new JPanel(new BorderLayout());
			roomPanel[i].setBorder(new TitledBorder(""));
		}
		
		//layout
		this.setLayout(new GridLayout(MAX_ROOM_LIST, 1));
		
		//socket
		//this.socketbuild();
		
	}
	
	/*public void run() {
		// TODO Auto-generated method stub
		try {
			// create a server socket
			ServerSocket serversocket = new ServerSocket(8000);
			int clientNo = 1;
			while (true) {
				Socket socket = serversocket.accept();
				System.out.printf("new a connection\n");
				InetAddress clientIP = socket.getInetAddress();
				int i = 0;
				for (i = 0; i < io; i++) {
					if (array_thread.get(i).gethostaddress().equals(clientIP))
						break;
				}
				if (i == array_thread.size()) {
					Machine_status status = new Machine_status();
					HandleAClient task = new HandleAClient(socket, status,
							socket.getInetAddress());
					array_thread.add(task);
					// Start the new thread
					task.start();
					// Increment clientNo
					clientNo++;
				} else {
					array_thread.get(i).get_status().set_online(true);
					array_thread.get(i).get_status()
							.set_heart_beat(new Heart_beat());
					array_thread.get(i).reset(socket);
					array_thread.get(i).resume();
					System.out.println(array_thread.get(i).gethostaddress()
							+ "is reconnected\n");
				}
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
*/
	public void addnewRoom(Room r) {
		// TODO Auto-generated method stub
		JTextArea textarea = new JTextArea("����ţ�			��������" +
											"\n��ǰ����:			�Ƿ���Ա��" +
											"\n����״̬��");
		textarea.setPreferredSize(new Dimension(550,70));
		textarea.setEditable(false);
		textarea.setBackground(Color.LIGHT_GRAY);
		roomPanel[currentRoomSize].add(textarea,BorderLayout.CENTER);
		roomPanel[currentRoomSize].add(roomListButton[currentRoomSize],BorderLayout.EAST);
		this.add( roomPanel[currentRoomSize]);
		roomList.add( r );
		currentRoomSize++;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		

		
		//create panel and frame
		JFrame frame = new JFrame("Game Lobby");
		
		
		//outlook on surface
		try{
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel") ;
		}catch (Exception e) {
            System.err.println("Oops!  Something went wrong!");
  		}
		SwingUtilities.updateComponentTreeUI(frame);
				
		//lobby and option
		Lobby lobby = new Lobby();
		JPanel option = new JPanel();
		
		//room is created
		Room room = new Room();
		
		//set layout
		option.setLayout(new GridLayout(1, 10, 50, 50));
		
		//create button
		JButton createButton = new JButton("��������");
		JButton enterButton = new JButton("���뷿��");
		JButton quitButton = new JButton("�˳���Ϸ");
		
		//create panel
		JPanel createPanel = new JPanel();
		JPanel enterPanel = new JPanel();
		JPanel quitPanel = new JPanel();
		
		//button setting
		createButton.setPreferredSize(new Dimension(150, 30));
		enterButton.setPreferredSize(new Dimension(150, 30));
		quitButton.setPreferredSize(new Dimension(150, 30));
		createButton.setToolTipText("����Դ���һ���µķ���");
		enterButton.setToolTipText("ѡ��һ������Ȼ��������");
		quitButton.setToolTipText("����˳���Ϸ");
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
		lobbyPanel.add(lobby,BorderLayout.CENTER);
		
		
		//add button
		option.add(createButton);
		option.add(enterButton);
		option.add(quitButton);
		
		// title of option
		JPanel optionOuter = new JPanel();
		optionOuter.setBorder(new TitledBorder(""));
		optionOuter.add(option);
		
		//frame add
		frame.add(new JScrollPane(optionOuter),BorderLayout.NORTH);
		frame.add(new JScrollPane(lobbyPanel),BorderLayout.CENTER);
		
		lobby.addnewRoom( new Room());
		lobby.addnewRoom( new Room());
		lobby.addnewRoom( new Room());
		lobby.addnewRoom( new Room());
		lobby.addnewRoom( new Room());
		lobby.addnewRoom( new Room());
		lobby.addnewRoom( new Room());
		lobby.addnewRoom( new Room());
		lobby.addnewRoom( new Room());
		
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		//new Thread(lobby).start();
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
