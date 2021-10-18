package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.*;

import Command.*;
import Game.Football;
import Parser.*;


public class ScoreboardGui extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	
	private JTextPane scorePanel;
	private JTextField inputPanel;
	private JButton inputButton;
	private JButton saveButton;
	
	private Parser gameParser;
	private Football football;

	
	
	public ScoreboardGui(Parser gameParser,Football football) { //making frame
		
		this.gameParser = gameParser;
		this.football=football;
		
		setTitle("Football scoreboard");
		setResizable(false);
		setBounds(350, 350, 700, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		scorePanel();
		inputPanel();
		inputButton();
		saveButton();
		
		getContentPane().add(scorePanel);
		getContentPane().add(inputPanel);
		getContentPane().add(inputButton);
		getContentPane().add(saveButton);
		

		
		inputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommandInterface comm = gameParser.parse(inputPanel.getText());
				scorePanel.setText(comm.execute());
				inputPanel.setText("");
			}
		});
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    try{
			        // Create file 
			        FileWriter fstream = new FileWriter(System.currentTimeMillis() + "games.txt");
			            BufferedWriter out = new BufferedWriter(fstream);
			      
			        out.write(football.getHomeTeam());
			        out.write(football.getHomeScore());
			        
			        out.write("-");
			        
			        out.write(football.getGuestTeam());
			        out.write(football.getGuestScore());
			        
			        //Close the output stream
			        out.close();
			        }catch (Exception ex){//Catch exception if any
			          System.err.println("Error: " + ex.getMessage());
			        }
				
			}
		});
	}


	private void scorePanel() {	//panel for score
		scorePanel = new JTextPane();
		scorePanel.setText("Welcome to Football World Cup Scoreboard!");
		scorePanel.setBounds(50, 35, 600, 150);
		scorePanel.setEditable(false);
	}
	
	
	
	private void inputPanel() { //panel for input
		
		inputPanel = new JTextField();
		inputPanel.setBounds(100, 225, 337, 37);
		inputPanel.setColumns(10);	
	}
	
	
	private void inputButton() { //button for input
		inputButton = new JButton("Submit");
		inputButton.setBounds(500, 200, 100, 30);	
		inputButton.setFont(new Font("Arial", Font.PLAIN, 16));
	}
	
	private void saveButton() { //button for showing all games
		saveButton=new JButton("Save game");
		saveButton.setBounds(500,228,120,30);
		saveButton.setFont(new Font("Arial",Font.PLAIN,16));
		
	}
}
