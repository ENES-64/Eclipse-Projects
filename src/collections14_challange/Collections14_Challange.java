package collections14_challange;

import java.util.*;
import java.io.*;

class Account implements Serializable {
	private int accno;
	private String name;
	private double balance;
	
	public int getAccNo() {
		return accno;
	}
	
	Account() {}
	
	Account(int accno, String name, double balance) {
		this.accno = accno;
		this.name = name;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account no: " + accno + ". Name: " + name + ". Balance: $" + balance;
	}
}

//Menu driven program for accounts using hashmap:
public class Collections14_Challange {
	public static void main(String[] args) {
		File file =new File("/Users/enesy/MyJava/Eclipse/MyEclipse/src/collections14_challange/account.txt");
		HashMap<Integer, Account> map=new HashMap<>();
		Scanner sc =new Scanner(System.in);
		Account acc = null;
		Random rand = new Random();
		
		try {
			FileInputStream fis =new FileInputStream(file);
			ObjectInputStream ois =new ObjectInputStream(fis);
			//Check how many accounts are in the file.
			int count = ois.readInt();
			for(int i=0;i<count;i++) {
				acc = (Account) ois.readObject();
				System.out.println(acc);
				map.put(acc.getAccNo(), acc);
			}
			fis.close();
			ois.close();
			
		} catch(Exception e) {}
		
		try {
			FileOutputStream fos =new FileOutputStream(file);
			ObjectOutputStream oos =new ObjectOutputStream(fos);
			
			System.out.println("Menu");
			
			int choice, accno;
			String name;
			double balance;
			
			boolean suggestSaving = false;
			
			do {
				System.out.println("\n1. Create an account");
				System.out.println("2. Delete an account");
				System.out.println("3. View an account");
				System.out.println("4. View all accounts");
				System.out.println("5. Save all accounts");
				System.out.println("6. Exit");
				choice = sc.nextInt();
				
				sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				
				switch(choice) {
					case 1:
						System.out.println("Enter name and balance: ");
						accno = rand.nextInt(999);
						name = sc.nextLine();
						balance = sc.nextDouble();
						acc =new Account(accno, name, balance);
						map.put(accno, acc);
						System.out.println("Account created for " + name + " With an ID of " + accno + '.');
						suggestSaving = true;
						break;
					case 2:
						System.out.println("Enter the number of the account you want to delete: ");
						accno = sc.nextInt();
						map.remove(accno);
						suggestSaving = true;
						break;
					case 3:
						System.out.println("Enter the number of the account you want to check: ");
						accno = sc.nextInt();
						acc = map.get(accno);
						System.out.println(acc);
						break;
					case 4:
						System.out.println("All accounts: ");
						for(Account a : map.values())
							System.out.println(a);
						break;
					case 6:
						if(suggestSaving == true) {
							System.out.println("Are you sure you want to exit without saving? (Y/N)");
							if(sc.next().equalsIgnoreCase("y")==false)
								break;
						}else
							break;
					case 5:
						oos.writeInt(map.size());
						for(Account a : map.values())
							oos.writeObject(a);
						suggestSaving = false;
						System.out.println("Saved successfully.");
				}
			} while(choice!=6);
			oos.flush();
			oos.close();
			fos.close();
		} catch(Exception e) {}
	}
}