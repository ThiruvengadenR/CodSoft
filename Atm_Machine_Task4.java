package codSoftInternship;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Atm_Machine_Task4 {
	
	Atm_Machine_Task4()
	{
		//----->         Display-1       <-----\\
		// Frame Related Things
		JFrame jframe = new JFrame("ATM Interface");
		jframe.setBounds(700, 350, 500, 350);
		jframe.setLayout(null);
		
		//Label for a Window 
		JLabel jlabel = new JLabel("Welcome to Bharath ATM");
		jlabel.setBounds(170,50,200,30);
		jframe.add(jlabel);
		// label for account number
		JLabel jlabel_AccountNO = new JLabel("Enter your Account Number");
		jlabel_AccountNO.setBounds(50,110,200,30);
		jframe.add(jlabel_AccountNO);
		// button for account number
		JTextField jtextfield_Ac = new JTextField("123456789");
		jtextfield_Ac.setBounds(300, 110, 130, 30);
		jframe.add(jtextfield_Ac);
		//label for password 
		JLabel jlabel_Password = new JLabel("Enter your Password");
		jlabel_Password.setBounds(50,160,200,30);
		jframe.add(jlabel_Password);
		//Button for Password 
		JTextField jtextfield_pwd = new JTextField("1234");
		jtextfield_pwd.setBounds(300,160,130,30);
		jframe.add(jtextfield_pwd);
		
		//Button for submit 
		JButton jbutton = new JButton("Submit");
		jbutton.setBounds(200, 220, 100, 30);
		jframe.add(jbutton);
		
		//Label for output result 
		JLabel jlabel_output = new JLabel();
		jlabel_output.setBounds(175, 275, 200, 30);
		jframe.add(jlabel_output);
		jframe.setVisible(true);
		//----->         Display-1 End        <-----\\
		
		//----->         Display-2       <-----\\
		JFrame jframe2 = new JFrame("ATM Interface2");
		jframe2.setBounds(700, 350, 500, 350);
		jframe2.setLayout(null);
		
		//button_withdraw
		JButton jbutton_withdraw = new JButton("Cash WithDrawal");
		jbutton_withdraw.setBounds(50, 50, 170, 40);
		jframe2.add(jbutton_withdraw);

		//button_deposit
		JButton jbutton_deposit = new JButton("Deposit Amount");
		jbutton_deposit.setBounds(270,50, 170, 40);
		jframe2.add(jbutton_deposit);
		
		//button_balance
		JButton jbutton_balance = new JButton("Balance Enquiry");
		jbutton_balance.setBounds(50, 150,170, 40);
		jframe2.add(jbutton_balance);
		
		//button_password
		JButton jbutton_password = new JButton("Change Password");
		jbutton_password.setBounds(270, 150,170, 40);
		jframe2.add(jbutton_password);
		
		//button_Back
		JButton jbutton_back = new JButton("<-Back");
		jbutton_back.setBounds(200, 250,100, 40);
		jframe2.add(jbutton_back);
		
		jframe2.setVisible(false);
		//----->         Display-2-End      <-----\\
		
		
		//----->        Display For Password Change     <------\\
		JFrame jframePassword = new JFrame("Password Update");
		jframePassword.setBounds(700, 350, 500, 350);
		jframePassword.setLayout(null);
		
		//label for new password 
		JLabel jlabelNewPassword = new JLabel("New Password");
		jlabelNewPassword.setBounds(75,80, 200, 40);
		jframePassword.add(jlabelNewPassword);
		
		//textfield for new password
		JTextField jtextfieldNewPassword = new JTextField();
		jtextfieldNewPassword.setBounds(250, 80, 170, 40);
		jframePassword.add(jtextfieldNewPassword);
		
		//label for confrom password 
		JLabel jlabelConfromPassword = new JLabel("Confrom Password");
		jlabelConfromPassword.setBounds(75,150, 200, 40);
		jframePassword.add(jlabelConfromPassword);
		
		//textfield for confrom password
		JTextField jtextfieldConfromPassword = new JTextField();
		jtextfieldConfromPassword.setBounds(250, 150, 170, 40);
		jframePassword.add(jtextfieldConfromPassword);
		
		//submit button 
		JButton jbuttonSubmitPassword = new JButton("Submit");
		jbuttonSubmitPassword.setBounds(200, 230, 100, 40);
		jframePassword.add(jbuttonSubmitPassword);
		jframePassword.setVisible(false);
		
		//----->        Display For Password Change End       <------\\
		
		//----->        Display For Cash Withdrawal     <------\\ 
		JFrame jframeCashWithdrawal = new JFrame("Cash Withdrawal");
		jframeCashWithdrawal.setBounds(700, 350, 500, 350);
		jframeCashWithdrawal.setLayout(null);
		
		//label for statement 
		JLabel jlabelCashWithdrawal= new JLabel("Please Enter The WithDrawal Amount Mutiples of Rs 500");
		jlabelCashWithdrawal.setBounds(50,30, 500, 40);
		jframeCashWithdrawal.add(jlabelCashWithdrawal);
		
		//textfield for enterAmount 
		JTextField jtextfieldCashWithdrawal = new JTextField();
		jtextfieldCashWithdrawal.setBounds(200, 80, 100, 40);
		jframeCashWithdrawal.add(jtextfieldCashWithdrawal);
		
		//button for Press If Correct 
		JButton jbuttonPressIfCorrectWithDrawal = new JButton("Press If Correct");
		jbuttonPressIfCorrectWithDrawal.setBounds(250, 150, 180, 40);
		jframeCashWithdrawal.add(jbuttonPressIfCorrectWithDrawal);
		
		//button for Reset Input
		JButton jbuttonResetInputWithDrawal = new JButton("Reset Input");
		jbuttonResetInputWithDrawal.setBounds(50, 150, 180, 40);
		jframeCashWithdrawal.add(jbuttonResetInputWithDrawal);
		
		//button_Cancel
		JButton jbuttonCancelWithDrawal = new JButton("Cancel Transaction");
		jbuttonCancelWithDrawal.setBounds(250, 225,180, 40);
		jframeCashWithdrawal.add(jbuttonCancelWithDrawal);
		
		//button_Back
		JButton jbutton_BackCashWithdrawal = new JButton("<-Back");
		jbutton_BackCashWithdrawal.setBounds(50, 225,180, 40);
		jframeCashWithdrawal.add(jbutton_BackCashWithdrawal);
		
		jframeCashWithdrawal.setVisible(false);
		//----->        Display For Cash Withdrawal End      <------\\ 
		
		//----->        Display For Cash Deposit     <------\\ 
		JFrame jframeCashDeposit = new JFrame("Cash Deposit");
		jframeCashDeposit.setBounds(700, 350, 500, 350);
		jframeCashDeposit.setLayout(null);
		
		//label for statement 
		JLabel jlabelCashDeposit= new JLabel("Please Enter The Deposit Amount Mutiples of Rs 500");
		jlabelCashDeposit.setBounds(50,30, 500, 40);
		jframeCashDeposit.add(jlabelCashDeposit);
		
		//textfield for enterAmount 
		JTextField jtextfieldCashDeposit = new JTextField();
		jtextfieldCashDeposit.setBounds(200, 80, 100, 40);
		jframeCashDeposit.add(jtextfieldCashDeposit);
		
		//button for Press If Correct
		JButton jbuttonPressIfCorrectDeposit = new JButton("Press If Correct");
		jbuttonPressIfCorrectDeposit.setBounds(250, 150, 180, 40);
		jframeCashDeposit.add(jbuttonPressIfCorrectDeposit);
		
		//button for Reset Input 
		JButton jbuttonResetInputDeposit = new JButton("Reset Input");
		jbuttonResetInputDeposit.setBounds(50, 150, 180, 40);
		jframeCashDeposit.add(jbuttonResetInputDeposit);
		
		//button_Cancel
		JButton jbuttonCancelDeposit = new JButton("Cancel Transaction");
		jbuttonCancelDeposit.setBounds(250, 225,180, 40);
		jframeCashDeposit.add(jbuttonCancelDeposit);
		
		//button_Back
		JButton jbutton_BackCashDeposit = new JButton("<-Back");
		jbutton_BackCashDeposit.setBounds(50, 225,180, 40);
		jframeCashDeposit.add(jbutton_BackCashDeposit);
		
		jframeCashDeposit.setVisible(false);
		
		//----->        Display For Cash Deposit End      <------\\ 
		
		//-----> jframe for final answer <------//
		
		JFrame jframeFinalAnswer = new JFrame("Final Output");
		jframeFinalAnswer.setBounds(700, 350, 500, 350);
		jframeFinalAnswer.setLayout(null);
		
		JLabel jlabelForFinalOutput = new JLabel();
		jlabelForFinalOutput.setBounds(150, 100, 300, 50);
		jframeFinalAnswer.add(jlabelForFinalOutput);
		
		JLabel jlabelForThanks = new JLabel("Thank you For Banking with us");
		jlabelForThanks.setBounds(150, 150, 300, 50);
		jframeFinalAnswer.add(jlabelForThanks);
		
		JLabel jlabelAdditionalInfo = new JLabel();
		jlabelAdditionalInfo.setBounds(150, 200, 300, 50);
		jframeFinalAnswer.add(jlabelAdditionalInfo);
		
		jframeFinalAnswer.setVisible(false);
		
		//-----> jframe for final answer end  <------//
		
		//-----> Display for Empty Input <-------//
		JFrame jframeInputRequired = new JFrame();
		jframeInputRequired.setBounds(700, 450, 300, 200);
		jframeInputRequired.setLayout(null);
		
		//JLabel 
		JLabel jlabelForMessage = new JLabel();
		jlabelForMessage.setBounds(50, 50, 200, 40);
		jframeInputRequired.add(jlabelForMessage);
		
		jframeInputRequired.setVisible(false);
		//-----> Display for Empty Input End  <-------//
		
		jbutton.addActionListener(new ActionListener() {
			String output="";

			@Override
			public void actionPerformed(ActionEvent e) {
				int accountNumber = Integer.parseInt(jtextfield_Ac.getText());
				int password = Integer.parseInt(jtextfield_pwd.getText());
				if(Atm_UserDetails.getAccountno()==accountNumber)
				{
					if(Atm_UserDetails.getPassword()==password)
					{
						output="Successfully Login";
						jframe.setVisible(false);
						jframe2.setVisible(true);
					}
					else {
						output="Password Mismatch";
					}
				}
				else {
					output="Invalid Account Number";
				}
				
				jlabel_output.setText(output);
			}
			
		});
		
		//action Listener for back
		jbutton_back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jframe2.setVisible(false);
				jframe.setVisible(true);	
			}
			
		});
		
		//action Listener for password reset 
		jbutton_password.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						jframe2.setVisible(false);
						jframePassword.setVisible(true);
						//submit action listnere work
						if(jtextfieldNewPassword.getText()==jtextfieldConfromPassword.getText())
						{
							Atm_UserDetails.setPassword(Integer.parseInt(jtextfieldNewPassword.getText()));
							jlabelForFinalOutput.setText("Password Update Successfully");
							jframeFinalAnswer.setVisible(true);
						}
						else {
							jlabelForFinalOutput.setText("Password Mismatch");
							jframeFinalAnswer.setVisible(true);
						}
					}
				});
		
		//action Listener for Balance Check // pending for show result 
		jbutton_balance.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe2.setVisible(false);
				jlabelForFinalOutput.setText("Your Account Balance is " + Atm_UserDetails.getBalance());
				jframeFinalAnswer.setVisible(true);
				
			}
		});
		
		//Action Listener for cash deposit 
		jbutton_deposit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe2.setVisible(false);
				jframeCashDeposit.setVisible(true);
				
			}
		});
		
		//Action Listener for Amount withdrawal
		jbutton_withdraw.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe2.setVisible(false);
				jframeCashWithdrawal.setVisible(true);
				
			}
		});
		
		//Action Listener for Password Submit
		jbuttonSubmitPassword.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				jframePassword.setVisible(false);
				jframeFinalAnswer.setVisible(true);
				String newPwd = jtextfieldNewPassword.getText();
				String confromPwd=jtextfieldConfromPassword.getText();
				if(newPwd.equals(confromPwd))
				{
					Atm_UserDetails.setPassword(Integer.parseInt(jtextfieldNewPassword.getText()));
					jlabelForFinalOutput.setText("Password Update Successfully");
					jframeFinalAnswer.setVisible(true);
				}
				else {
					jlabelForFinalOutput.setText("New and Confrom Password Mismatch");
					jframeFinalAnswer.setVisible(true);
				}
				
			}
		});
		
		//action Listener for back cashwithdrawal 
		jbutton_BackCashWithdrawal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jframeCashWithdrawal.setVisible(false);
				jframe2.setVisible(true);	
			}	
		});
		
		//action Listener for back  cash deposit 
		jbutton_BackCashDeposit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jframeCashDeposit.setVisible(false);
				jframe2.setVisible(true);	
			}	
		});
		
		
		//General Method action Listener for cancel transcation
		ActionListener cancelTransaction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}	
		};
		//action listener implementation
		jbuttonCancelDeposit.addActionListener(cancelTransaction);
		jbuttonCancelWithDrawal.addActionListener(cancelTransaction);
		
		//Press If Correct WithDrawal
		jbuttonPressIfCorrectWithDrawal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				long accountBalance = Atm_UserDetails.getBalance();
				long withdrawal =Long.parseLong(jtextfieldCashWithdrawal.getText());
				jframeCashWithdrawal.setVisible(false);
				if(withdrawal>accountBalance)
				{
					jlabelForFinalOutput.setText("Insufficient Balance");
					jframeFinalAnswer.setVisible(true);	
				}
				else {
					jlabelForFinalOutput.setText("Collect Your Cash "+ withdrawal);
					jlabelAdditionalInfo.setText("Current Balance " +(accountBalance-withdrawal));
					jframeFinalAnswer.setVisible(true);
				}
			}
			
		});
		
		//Press If Correct Deposit
		jbuttonPressIfCorrectDeposit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				long accountBalance = Atm_UserDetails.getBalance();
				long deposit =Long.parseLong(jtextfieldCashDeposit.getText());
				jtextfieldCashDeposit.setVisible(false);
				if(deposit<=0)
				{
					jlabelForFinalOutput.setText("Deposit Amount Cannot be Negative");
					jframeFinalAnswer.setVisible(true);	
				}
				else {
					jlabelForFinalOutput.setText("Newly Added Amount"+ deposit);
					jlabelAdditionalInfo.setText("Current Balance " +(accountBalance+deposit));
					jframeFinalAnswer.setVisible(true);
				}
			}
			
		});
		
		//action listener for reset input withdrawal
		jbuttonResetInputWithDrawal.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						jtextfieldCashWithdrawal.setText("");
						jframeCashWithdrawal.setVisible(true);		
					}
				});
		
		//action listener for reset input deposit
		jbuttonResetInputDeposit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				jtextfieldCashDeposit.setText("");
				jframeCashDeposit.setVisible(true);		
			}
		});
		
		
		//closing window to stop program 
		WindowAdapter closing = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		};
		
		jframe.addWindowListener(closing);
		jframe2.addWindowListener(closing);
		jframePassword.addWindowListener(closing);
		jframeCashWithdrawal.addWindowListener(closing);
		jframeCashDeposit.addWindowListener(closing);
		jframeFinalAnswer.addWindowListener(closing);
		jframeInputRequired.addWindowListener(closing);
	}
	
	public static void main(String[] args) {
		new Atm_Machine_Task4();
	}

}

class Atm_UserDetails{
	private static final long accountNO = 123456789;
	private static  int password=1234;
	private static long  balance=10000;

	public static void setPassword(int password) {
		Atm_UserDetails.password = password;
	}

	
	
	public static long getBalance() {
		return balance;
	}
	
	public static void setBalance(long balance) {
		Atm_UserDetails.balance = balance;
	}
	
	public static long getAccountno() {
		return accountNO;
	}
	
	public static int getPassword() {
		return password;
	}
	
	
}
