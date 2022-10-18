package mypackage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class NoSuchFileException extends Exception{
	NoSuchFileException(String msg){
		super(msg);
	}
}
public class Main {
	static int choice;
	static int subChoice;
	public static void fileAscendingOrder(){
		File file = new File("D:\\Project\\Course2");
		if(file.isDirectory()) {
			File[] fileList = file.listFiles();
			
			for(File files:fileList) {
				System.out.println(files.getName());
			}
		}
	}
	
	public static void addFile() throws IOException {
		System.out.println("Enter the file name to be added: ");
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		File file = new File("D:\\Project\\Course2\\"+fileName+".txt");
		try {
		if(file.createNewFile()) {
			System.out.println("New file is created");
		}
		else {
			System.out.println("File already exists");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteFile() throws NoSuchFileException  {
		System.out.println("Enter the file name to be deleted: ");
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		File file = new File("D:\\Project\\Course2\\"+fileName+".txt");
		if(file.delete()) {
			System.out.println("File deleted successfully");
		}
		else {
			throw new NoSuchFileException("Such file does not exist");
		}
	}
	
	public static void searchFile() throws NoSuchFileException {
		System.out.println("Enter the file name to be searched: ");
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		File file = new File("D:\\Project\\Course2\\"+fileName+".txt");
		if(file.exists()) {
			System.out.println("The file "+ file.getName()+ " is available in the directory");
		}
		else {
			throw new NoSuchFileException("Such file does not exist");
		}
	}
	
	public static void showPrimaryMenu() {
			System.out.println("<===========================================================================>");
			System.out.println("Enter your choice:(1 or 2 or 3)" +'\n'+ "1.Current file names in ascending order"
					+'\n'+"2.To do business operations such as add, delete and search through files"
					+'\n'+"3.Close the application");
			System.out.println("<===========================================================================>");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			}
	
	public static void showSecondaryMenu() {
		System.out.println("<===========================================================================>");
		System.out.println("Enter your choice:(1 or 2 or 3 or 4)"
				+'\n'+"1.Add a file"+'\n'+"2.Delete a file"+
				'\n'+"3.Search a file"+'\n'+"4.Back to main menu");
		System.out.println("<===========================================================================>");
	}
	

	
	public static void main(String[] args) throws IOException, NoSuchFileException {
		// TODO Auto-generated method stub
		System.out.println("<===========================================================================>");
		System.out.println("Application Name     : Lockers.in");
		System.out.println("Developer Details    : Joe Maarian X");
		System.out.println("DIRECTORY            : /Simplilearn_Course2_Project01/src/mypackage/Main.java");
		System.out.println("<===========================================================================>");
		
		while(true) {
			showPrimaryMenu();
			
			
			if(choice == 1) {
				fileAscendingOrder();
			}
			else if(choice == 2) {
				int subChoice = 3;
				while(subChoice <4 && subChoice >0 ) {
					showSecondaryMenu();
					Scanner sc1 = new Scanner(System.in);
					subChoice = sc1.nextInt();
					switch(subChoice) {
					case 1:{
						addFile();
						break;
					}
					case 2:{
						deleteFile();
						break;
					}
					case 3:{
						searchFile();
						break;
					}
					case 4:{
						System.out.println("Back to primary menu: ");
						break;
					}
					default:{
						System.out.println("Invalid input");
					}
					}
				}
			}
			else if(choice == 3) {
				System.out.println("Application closed successfully");
				System.exit(choice);
			}
		}
	}
	
}	