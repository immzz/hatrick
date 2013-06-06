package com.hatrick.server;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class RoomClientScreen {

	
	JFrame roomframe;
	JButton startButton;
	JButton quitButton;
	//JComboBox teamCombo;
	JButton charButton;
	
	JButton[] member = new JButton[6];
	
	RoomClientScreen(){
		//create panel and roomframe
		roomframe = new JFrame("Game Room");
				
				
		//outlook on surface
		try{
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel") ;
		}catch (Exception e) {
		    System.err.println("Oops!  Something went wrong!");
		}
		SwingUtilities.updateComponentTreeUI(roomframe);
	
		//button
		startButton = new JButton("准备/开始");
		quitButton = new JButton("退出房间");
		charButton = new JButton("角色选择");
		
		//member button
		member[0] = new JButton("用户名：哈哈      角色：大师");
		member[1] = new JButton();
		member[2] = new JButton();
		member[3] = new JButton();
		member[4] = new JButton();
		member[5] = new JButton();
		
		/*member[0].setBorder(new TitledBorder(""));
		member[1].setBorder(new TitledBorder(""));
		member[2].setBorder(new TitledBorder(""));
		member[3].setBorder(new TitledBorder(""));
		member[4].setBorder(new TitledBorder(""));
		member[5].setBorder(new TitledBorder(""));*/
		
		//panel
		JPanel buttonPanel = new JPanel();
		JPanel charPanel = new JPanel();
		
		//panel setting
		buttonPanel.setLayout(new GridLayout(1, 5, 5, 5));
		charPanel.setLayout(new GridLayout( 2, 3, 5, 5 ));
		buttonPanel.setBorder(new TitledBorder(""));
		charPanel.setBorder(new TitledBorder("游戏房间"));
		
		//button setting
		quitAction quitlisten = new quitAction();
		quitButton.addActionListener(quitlisten) ;
		charAction charlisten = new charAction();
		charButton.addActionListener(charlisten) ;
		
		
		//add button to panel
		buttonPanel.add(startButton);
		buttonPanel.add(charButton);
		buttonPanel.add(quitButton);
		
		
		//member
		//
		JPanel wholeApanel = new JPanel();
		buttonAPanel bApanel = new buttonAPanel();
		wholeApanel.add(bApanel,BorderLayout.CENTER);
		wholeApanel.add(member[0],BorderLayout.SOUTH);
		buttonAction bAction = new buttonAction(bApanel,member[0]);
		member[0].addActionListener(bAction);
		
		//
		charPanel.add(member[0]);
		charPanel.add(member[1]);
		charPanel.add(member[2]);
		charPanel.add(member[3]);
		charPanel.add(member[4]);
		charPanel.add(member[5]);
		
		//frame add
		roomframe.add(buttonPanel, BorderLayout.SOUTH);
		roomframe.add(charPanel, BorderLayout.CENTER);
		
		
		roomframe.setSize(800,600);
		roomframe.setLocationRelativeTo(null);
		roomframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		roomframe.setVisible(true);
	
	}
	
	public static void main(String[] args){
		
		RoomClientScreen roomscreen = new RoomClientScreen();
	}
	
	
}


class charAction implements ActionListener{

	charAction(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Game character");

		
		//create image panel
		CrusaderImagePanel crusaderimagepanel = new CrusaderImagePanel();
		DaemonImagePanel daemonimagepanel = new DaemonImagePanel();
		WitchImagePanel witchimagepanel = new WitchImagePanel();
		
		//create panel
		JPanel crusaderPanel = new JPanel();
		JPanel daemonPanel = new JPanel();
		JPanel witchPanel = new JPanel();
		
		//crusaderimagepanel.setBorder(new TitledBorder(""));
		//for crusaderPanel
		crusaderPanel.setLayout(new GridLayout(2, 1, 5, 5));
		crusaderPanel.add(crusaderimagepanel);
		JButton crusaderButton = new JButton("十字军骑士");
		crusaderButton.setPreferredSize(new Dimension(100,40));
		crusaderPanel.add(crusaderButton);
		
		//for daemonPanel
		daemonPanel.setLayout(new GridLayout(2, 1, 5, 5));
		daemonPanel.add(daemonimagepanel);
		JButton daemonButton = new JButton("肉山大魔王");
		daemonButton.setPreferredSize(new Dimension(100,40));
		daemonPanel.add(daemonButton);

		//for witchPanel
		witchPanel.setLayout(new GridLayout(2, 1, 5, 5));
		witchPanel.add(witchimagepanel);
		JButton witchButton = new JButton("伪娘");
		witchButton.setPreferredSize(new Dimension(100,40));
		witchPanel.add(witchButton);
		
		
		//add panel
		frame.setLayout(new GridLayout(1, 3, 5, 5));
		frame.add(crusaderPanel);
		frame.add(daemonPanel);
		frame.add(witchPanel);
		//frame.add(new JPanel());
		
		frame.setSize(300,250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}
class buttonAction implements ActionListener{

	private buttonAPanel panel = null;
	private JButton button;
	private boolean isEmpty = true;
	
	buttonAction(buttonAPanel panel, JButton button){
		this.panel = panel;
		this.button = button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//this.panel.switchEmpty();
		//this.panel.repaint();
		if(isEmpty)
			button.setText("你点我了");
		else
			button.setText("");
		
		isEmpty = !isEmpty;
	}

}
class buttonAPanel extends JPanel{
	private int isEmpty = 1;
	private Image img = new ImageIcon("res/game/graphic/avatars/crusader1a_head1.jpg").getImage();
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		if(isEmpty == 0){
			g.drawImage(null, 0, 0, WIDTH, HEIGHT, this);
		}else{
			g.drawImage(img, 0, 0, WIDTH, HEIGHT, this);
		}
	}
	public void switchEmpty(){
		isEmpty = 1 - isEmpty;
	}
}
class CrusaderImagePanel extends JPanel{
	private ImageIcon icon = new ImageIcon("res/game/graphic/avatars/crusader1a_head1.jpg");
	private Image image = icon.getImage();
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(image != null){
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
class WitchImagePanel extends JPanel{
	private ImageIcon icon = new ImageIcon("res/game/graphic/avatars/witch3a_head1.jpg");
	private Image image = icon.getImage();
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(image != null){
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
class DaemonImagePanel extends JPanel{
	private ImageIcon icon = new ImageIcon("res/game/graphic/avatars/daemon2a_head1.jpg");
	private Image image = icon.getImage();
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if(image != null){
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
}