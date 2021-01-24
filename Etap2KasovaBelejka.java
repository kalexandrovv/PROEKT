package project;

//importing packages
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class kasovaBelejka extends JPanel {
	
	public kasovaBelejka() {
				
		this.setLayout(null);
		
		JLabel label1 = new JLabel("Enter an amount, a product and the price for each one");
		label1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label1.setBounds(30, 10, 370, 30);
		this.add(label1); 
		
		JTextField amountText = new JTextField();
		amountText.setBounds(30, 50, 50, 40);
		this.add(amountText);
		amountText.setColumns(10);
				
		JTextField productText = new JTextField();
		productText.setColumns(10);
		productText.setBounds(100, 50, 200, 40);
		this.add(productText);
		
		JTextField priceText = new JTextField();
		priceText.setBounds(320, 50, 60, 40);
		this.add(priceText);
		priceText.setColumns(10);
	    
		JTextArea printText = new JTextArea();
		printText.setBounds(50, 150, 600, 400);
		this.add(printText);
		printText.setColumns(10);
		
		JButton addButton = new JButton("Add product");
		addButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		addButton.setBounds(400, 50, 120, 50);
		this.add(addButton); 
		
		JButton printBill = new JButton("Print Bill");
		printBill.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		printBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		printBill.setBounds(550, 50, 130, 50);
		this.add(printBill);

	}
	
	//Create and show GUI
	private static void createAndShowGUI() {
		JFrame f=new JFrame("Bill");//creating a frame 
		
		f.setSize(750, 650);  
        f.setLayout(null);  
        f.setVisible(true);
        
        kasovaBelejka newContentPane = new kasovaBelejka();
        newContentPane.setOpaque(true);
        f.setContentPane(newContentPane);
        
	}
	
	public static void main(String[] args) {
		
	    //Create and show this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});		
	}

}