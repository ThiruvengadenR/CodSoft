package codSoftInternship;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddressBook extends AddressBookMethod{
	private static final int maxAttempt=5;
	private static int count=0;
	Scanner sc = new Scanner(System.in);
	public AddressBook(String filePath) {
		super(filePath);
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		AddressBook obj = new AddressBook("/home/gods/Videos/codSoft/AddressBook.txt");
		obj.readFromFile();
		obj.AddressBookFlow();
		
	}
	
	protected int selectOption()
	{
		while(maxAttempt>count)
		{
			try {
				int option = sc.nextInt();
				//sc.nextLine();
				return option;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid Input . Please Enter Correct Option ");
				sc.nextLine();
				count++;
				if(count==maxAttempt)
				{
					System.out.println("Your cross the Max Attempt Limit Please Restart the program ");
					System.exit(0);
				}
			}
		}
		return 0;
	}
	
	private void AddressBookFlow()
	{
		showInstruction();
		System.out.println("\nEnter Your Option");
		int option =selectOption();
		switch(option) {
		case 1:
			{
				addContact();
				writeToFile();
				AddressBookFlow();
			}
		case 2:
			{
				removeContact();
				writeToFile();
				AddressBookFlow();
			}
		case 3:
			{
				searchContact();
				AddressBookFlow();
			}
		case 4:
			{
				System.out.println("Total Contacts In our Address Book");
				System.out.println();
				displayAllContact();
				System.out.println("----------------------------------------");
				AddressBookFlow();
			}
		case 5:
			{
				updateContent();
				writeToFile();
				AddressBookFlow();
			}
		case 6:
			{
				System.out.println("Thank for Using Address Book ");
				writeToFile();
				System.exit(0);
			}
		default:{
			System.out.println("Select The option with in Range "); 
			count++;
			writeToFile();
			AddressBookFlow();
		}
		}
	}

}

class ContactTemplate implements Serializable{
	
	private String name ;
	private long mobile;
	private String email;
	private String address;
	
	
	@Override
	public String toString() {
		return "ContactTemplate [name=" + name + ", mobile=" + mobile + ", email=" + email + ", address=" + address
				+ "]";
	}

	public ContactTemplate(String name, long mobile, String email, String address) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobileupdate) {
		this.mobile = mobileupdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

	
}

class AddressBookMethod{
	protected static int count=0;
	protected static final int maxAttempt=5;
	
	private ArrayList<ContactTemplate> addressImplementation ;
	private String filePath;
	
	
    public void writeToFile() {
        try {
        	FileOutputStream fos = new FileOutputStream(filePath);
        	ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(addressImplementation);
            fos.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void readFromFile() {
        try{
        	FileInputStream fis = new FileInputStream(filePath);
        	ObjectInputStream inputStream = new ObjectInputStream(fis);
        	addressImplementation = (ArrayList<ContactTemplate>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	
	protected void showInstruction()
	{
        System.out.println("Address Book");
        System.out.println("Enter 1 for  Add Contact");
        System.out.println("Enter 2 for Remove Contact");
        System.out.println("Enter 3 for Search Contact");
        System.out.println("Enter 4 for Display All Contact");
        System.out.println("Enter 5 for Update Contact");
        System.out.println("Enter 6 for Exit");
	}
	
	public AddressBookMethod(String filePath)
	{
		this.filePath=filePath;
		addressImplementation = new ArrayList<ContactTemplate>();
	}
	
	protected void addContact()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Contact Name ");
		String name = sc.nextLine();
		System.out.println("Enter Contact Mobile Number For Add Contact ");
		long mobile =gettingMobileNumberAsInput();
		System.out.println("Enter Your Contact Email Id ");
		String email = sc.nextLine();
		System.out.println("Enter Your Contact Address ");
		String address = sc.nextLine();
		ContactTemplate contacttemplateObj = new ContactTemplate(name,mobile,email,address);
		addressImplementation.add(contacttemplateObj);
		//sc.close();
	}
	
	protected void removeContact()
	{
		System.out.println("Enter Contact Mobile Number For Remove Contact ");
		long mobile =gettingMobileNumberAsInput();
		boolean contactRemoved=false;
		for(ContactTemplate contact:addressImplementation)
		{
			if(contact.getMobile()==mobile)
			{
				addressImplementation.remove(contact);
				System.out.println("Contact Removed Sucessfully ");
				contactRemoved=true;
			}
		}
		if(!contactRemoved)
		{
			System.out.println("No Contact is Saved on the Enter Mobile NUmber " + mobile);
		}	
	}
	
	protected void displayAllContact()
	{
		for(ContactTemplate contact:addressImplementation)
		{
			System.out.println(contact);
		}
	}
	
	protected void searchContact()
	{
		System.out.println("Enter Contact Mobile Number For Search ");
		long mobile =gettingMobileNumberAsInput();
		boolean contactRemoved=false;
		for(ContactTemplate contact:addressImplementation)
		{
			if(contact.getMobile()==mobile)
			{
				System.out.println(contact);
				contactRemoved=true;
				break;
			}
		}
		if(!contactRemoved)
		{
			System.out.println("No Contact is Saved on the Enter Mobile NUmber " + mobile);
		}
	}
	
	protected void updateContent() {
		
		System.out.println("Enter Contact Mobile Number For Update Contact ");
		long mobile =gettingMobileNumberAsInput();
		boolean contactRemoved=false;
		for(ContactTemplate contactOuter:addressImplementation)
		{
			if(contactOuter.getMobile()==mobile)
			{
				contactRemoved=true;
				System.out.println("Enter->1 For Update Mobile Number ");
				System.out.println("Enter->2 For Update Name ");
				System.out.println("Enter->3 For Update Email ");
				System.out.println("Enter->4 For Update Address ");
				System.out.println("Enter->5 For Exit");
				System.out.println("\nEnter Your Option for Update Content ");
				Scanner sc = new Scanner(System.in);
				int option=0;
				while(count<maxAttempt)
				{
					try {
						option = sc.nextInt();
						sc.nextLine();
						break;
					}
					catch(InputMismatchException e)
					{
						System.out.println("Invalid Input . Please Enter Correct Option ");
						count++;
						if(count==maxAttempt)
						{
							System.out.println("Your cross the Max Attempt Limit Please Restart the program ");
							System.exit(0);
						}
					}
				}
				switch(option)
				{
					case 1:{
						long mobileupdate = gettingMobileNumberAsInput(); 
						for(ContactTemplate contact :addressImplementation)
						{
							if(contact.getMobile()==mobile)
							{
								contact.setMobile(mobileupdate);
								System.out.println("Mobile Number Updated Successfully");
								break;
							}
						}
						break;
					}
					case 2:{
						System.out.println("Enter The Name For Update ");
						String nameUpdate = sc.nextLine();
						for(ContactTemplate contact :addressImplementation)
						{
							if(contact.getMobile()==mobile)
							{
								contact.setName(nameUpdate);
								System.out.println("Name Updated Successfully");
								break;
							}
						}
						break;
					}
					case 3:{
						System.out.println("Enter The Email For Update ");
						String emailUpdate = sc.nextLine();
						for(ContactTemplate contact :addressImplementation)
						{
							if(contact.getMobile()==mobile)
							{
								contact.setEmail(emailUpdate);
								System.out.println("Email Updated Successfully");
								break;
							}
						}
						break;
					}
					case 4:{
						System.out.println("Enter The Address For Update ");
						String addressUpdate = sc.nextLine();
						for(ContactTemplate contact :addressImplementation)
						{
							if(contact.getMobile()==mobile)
							{
								contact.setAddress(addressUpdate);
								System.out.println("Address Updated Successfully");
								break;
							}
						}
						break;
					}
					case 5:{
						break;
					}
					default :{
						System.out.println("Enter the Number Within 1 to 5 ");
						updateContent();
					}
				}
			}
		}
		if(!contactRemoved)
		{
			System.out.println("No Contact is Saved on the Enter Mobile NUmber " + mobile);
			System.out.println();
		}
		System.out.println("----------------------------------------------------");
		
	}
	
	private long gettingMobileNumberAsInput()
	{
		Scanner sc = new Scanner(System.in);
		while(count<maxAttempt)
		{
			try {
				long mobile = sc.nextLong();
				sc.nextLine();
				return mobile;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Invalid Input . Please Enter Correct Mobile Number");
				count++;
				if(count==maxAttempt)
				{
					System.out.println("Your cross the Max Attempt Limit Please Restart the program ");
					System.exit(0);
				}
			}
		}
		return 0;	
	}
}

