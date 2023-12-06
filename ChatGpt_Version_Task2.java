package codSoftInternship;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.io.*;

	public class ChatGpt_Version_Task2 {
	    private static String filePath = "";
	    private static String output;

	    ChatGpt_Version_Task2() {
	        JFrame frame = new JFrame("Word Counter");
	        frame.setBounds(700, 400, 500, 200);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(new BorderLayout());

	        JPanel panel = new JPanel();
	        panel.setLayout(new FlowLayout());

	        JLabel label = new JLabel("Enter your File location:");
	        JTextField textField = new JTextField("Enter the File for WordCounter", 25);
	        JButton btn = new JButton("Submit");
	        JLabel answer = new JLabel();

	        panel.add(label);
	        panel.add(textField);
	        panel.add(btn);

	        frame.add(panel, BorderLayout.CENTER);
	        frame.add(answer, BorderLayout.SOUTH);

	        btn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                filePath = textField.getText();
	                try {
	                    wordCounterFromTheFile();
	                    answer.setText(output);
	                } catch (IOException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        });

	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new ChatGpt_Version_Task2());
	    }

	    public void wordCounterFromTheFile() throws IOException {
	        String inputForTheFileStorage = "";
	        File file = new File(filePath);

	        if (file.exists()) {
	            try (FileReader fileReader = new FileReader(file);
	                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

	                String line;
	                while ((line = bufferedReader.readLine()) != null) {
	                    inputForTheFileStorage += line + " ";
	                }
	                String[] stringArray = inputForTheFileStorage.split("\\s+");
	                int totalWords = stringArray.length;
	                output = "Total count of words: " + totalWords;
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } else {
	            output = "File doesn't exist at the given path.";
	        }
	    }
	}



