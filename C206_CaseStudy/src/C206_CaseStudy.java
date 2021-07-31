import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		
		int option = -1;
		
		while (option != 5) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				Helper.line(80, "=");
				System.out.println("Manage User");
				Helper.line(80, "=");
				System.out.println("1. View all Users");
				System.out.println("2. Add User Account");
				System.out.println("3. Delete User Account");
				
				int UserOption = Helper.readInt("Enter an option > ");
				
				if (UserOption == 1) {
					
				} else if (UserOption == 2) {
					
				} else if (UserOption == 3) {
					
				}
			} else if (option == 2) {
				Helper.line(80, "=");
				System.out.println("Manage Academic Cluster");
				Helper.line(80, "=");
				System.out.println("1. View all Academic Clusters");
				System.out.println("2. Add Academic Cluster");
				System.out.println("3. Delete Academic Cluster");
				
				int ACOption = Helper.readInt("Enter an option > ");
				
				if (ACOption == 1) {
					
				} else if (ACOption == 2) {
					
				} else if (ACOption == 3) {
					
				}
			} else if (option == 3) {
				Helper.line(80, "=");
				System.out.println("Manage Career Information");
				Helper.line(80, "=");
				System.out.println("1. View all Career Information");
				System.out.println("2. Add Career Information");
				System.out.println("3. Delete Career Information");
				
				int CIOption = Helper.readInt("Enter an option > ");
				
				if (CIOption == 1) {
					
				} else if (CIOption == 2) {
					
				} else if (CIOption == 3) {
					
				}
			} else if (option == 4) {
				Helper.line(80, "=");
				System.out.println("Manage Subject");
				Helper.line(80, "=");
				System.out.println("1. View all Subjects");
				System.out.println("2. Add Subject");
				System.out.println("3. Delete Subject");
				
				int SubjectOption = Helper.readInt("Enter an option > ");
				
				if (SubjectOption == 1) {
					
				} else if (SubjectOption == 2) {
					
				} else if (SubjectOption == 3) {
					
				}
			} else if (option == 5) {
				System.out.println("Goodbye!");
			}
			
		}
	}
	
	public static void menu() {
		Helper.line(80, "=");
		System.out.println("CAREER PLANNING APPLICATION");
		Helper.line(80, "=");
		System.out.println("1. Manage User");
		System.out.println("2. Manage Academic Cluster");
		System.out.println("3. Manage Career Information");
		System.out.println("3. Manage Subject");
	}

}
