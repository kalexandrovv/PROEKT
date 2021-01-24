package project;

//importing packages
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
		
		File file = new File("bill.txt");
		File totalFile = new File("total.txt");
		
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("");
		    fw.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		try {
			FileWriter fw = new FileWriter(totalFile);
			fw.write("");
		    fw.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int amount = Integer.parseInt(amountText.getText());
				String product = productText.getText();
				double price = Double.parseDouble(priceText.getText());
				
				String bill=""+product+ "----------" + price*amount+" лв\n";
				double totalPrice=price*amount;
				
				try {
					FileWriter fw = new FileWriter(file,true);
					fw.write(bill);
				    fw.close();
				} catch (IOException e) {
				    e.printStackTrace();
				}
								
				Scanner sc;
				try {
					sc = new Scanner(totalFile);
					if(sc.hasNextLine()) {
						totalPrice+=Double.parseDouble(sc.nextLine());
					}
					sc.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					FileWriter fw = new FileWriter(totalFile);
					fw.write(""+totalPrice);
				    fw.close();
				} catch (IOException e) {
				    e.printStackTrace();
				}
				
				
				
			}
		});
		addButton.setBounds(400, 50, 120, 50);
		this.add(addButton); 
		
		JButton printBill = new JButton("Print Bill");
		printBill.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		printBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String total="";
				Scanner sc;
				try {
					sc = new Scanner(totalFile);
					total = sc.nextLine();
					sc.close();
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				String print="";
				try {
					Scanner scan = new Scanner(file);
					while (scan.hasNextLine()) {
						print += scan.nextLine() + "\n";
					}
					scan.close();
					print+="\nОбщо---------------"+total+"лв";
				} catch (FileNotFoundException e) {
					try {
						file.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				printText.setText(print);
				
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
        
        double totalPrice = 0.0; 
		String bill = "";
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