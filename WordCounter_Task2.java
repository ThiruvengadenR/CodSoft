package codSoftInternship;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;

public class WordCounter_Task2 {
	
	//private static String inputForTheFileStorage ="";
	private static String filePath="";
	private static String output;
	
	WordCounter_Task2()
	{
		JFrame frame = new JFrame("Word Counter");
		frame.setBounds(700, 400, 500, 250);
		
			//frameObj.setLayout(new FlowLayout());
		frame.setLayout(null);
		//label 
		JLabel label = new JLabel("Enter your File location");
		label.setBounds(50, 50, 180, 30);
		frame.add(label);
		
		JLabel answer = new JLabel ();
		answer.setBounds(150, 150, 250, 30);
		frame.add(answer);
		//TextField
		JTextField textfield = new JTextField("Enter the File for WordCounter");
		textfield.setBounds(250, 50, 200, 30);
		frame.add(textfield);
		//windowlistener
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		//button
		JButton btn = new JButton("Submit");
		btn.setBounds(200, 100, 100, 30);
		frame.add(btn);
		
		frame.setVisible(true);
		
		//Anonymous Object
		btn.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						filePath=textfield.getText();
			// code for verification in console
//						System.out.println("Method Getting input from user-->"+textfield.getText());
//						System.out.println("Value stored in file path--->"+filePath);
						try {
							wordCounterFromTheFile();
							answer.setText(output);
							System.out.println(output);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				});
	}

	public static void main(String[] args) throws IOException {
		WordCounter_Task2 obj= new WordCounter_Task2();
//		local file path for testing 
//		"/home/gods/Videos/codSoft/wordcounter_Task2.txt"
//		/home/gods/Videos/codSoft/sample2.txt
		
		//Before Implement Swing scanner is used for Get the input 
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Enter your File Path to Read your File ");
//			String filePath = sc.next();
	}
	public void wordCounterFromTheFile() throws IOException
	{
		String inputForTheFileStorage ="";
		File f = new File(filePath);
		int inputForTheFile;
		if(f.exists())
		{
			FileReader fw = new FileReader(f);
			while((inputForTheFile=fw.read())!=-1)
			{
				inputForTheFileStorage = inputForTheFileStorage +(char) inputForTheFile;
			}
			//System.out.println(inputForTheFileStorage);
			String [] stringArray = inputForTheFileStorage.split(" ");
			int totalwords=0;
			for (String s:stringArray)
			{
				totalwords++;
			}
			fw.close();
			//System.out.println("total count of words --> "+ totalwords);
			output ="total count of words --> "+ totalwords;
		}
		else {
			System.out.println("File doesn't Exits on the path");
			output = "File doesn't Exits on the path";
		}
	}

}
