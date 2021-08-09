import java.util.ArrayList;

public class CareerPlanningApp {

	static ArrayList<AcademicCluster> clusterList = new ArrayList<AcademicCluster>();
	static ArrayList<UserAccounts> userAccList = new ArrayList<UserAccounts>();
	static ArrayList<Subjects> subjectList = new ArrayList<Subjects>();
	
	public static void main(String[] args) {
		
		clusterList.add(new AcademicCluster("R1", "Agriculture, Food & Natural Resources"));
		userAccList.add(new UserAccounts("1", "Kelsy Seah"));
		subjectList.add(new Subjects("1", "Mathematics"));
		
		int option = -1;
		
		while (option != 5) {
			CareerPlanningApp.menu();
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
					CareerPlanningApp.viewAllUsers(userAccList);
				} 
				
				else if (UserOption == 2) {
					CareerPlanningApp.addUserAcc(userAccList);
				} 
				
				else if (UserOption == 3) {
					CareerPlanningApp.removeUserAcc(userAccList);
					
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
					CareerPlanningApp.retrieveCluster(clusterList);
				} else if (ACOption == 2) {
					clusterList = CareerPlanningApp.addCluster(null);
					
				} else if (ACOption == 3) {
					clusterList = CareerPlanningApp.removeCluster(clusterList);
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
					CareerPlanningApp.viewSubjects(subjectList);
					
				} else if (SubjectOption == 2) {
					CareerPlanningApp.addSubjects(subjectList);
					
				} else if (SubjectOption == 3) {
					CareerPlanningApp.deleteSubjects(subjectList);
					
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
		System.out.println("4. Manage Subject");
		System.out.println("5. Quit");
	}
	public static String retrieveCluster(ArrayList<AcademicCluster> clusterList) {
		String output = "";
		
		for (int i = 0; i < clusterList.size(); i++) {
			output += String.format("%-15s %-15s", clusterList.get(i).getClusterID(), clusterList.get(i).getClusterName());
		}
		return output;
	}
	
	public static void viewCluster(ArrayList<AcademicCluster> clusterList) {
		String output = String.format("%-15s %-10s\n", "CLUSTER ID", "NAME");
		for (int i = 0; i < clusterList.size(); i++) {
			output += retrieveCluster(clusterList);
			System.out.println(output);
		}
	}
	
	public static ArrayList<AcademicCluster> addCluster(ArrayList<AcademicCluster> acList) {
		String clusterID = Helper.readString("Enter Cluster ID > ");
		String clusterName = Helper.readString("Enter Cluster Name > ");
		
		AcademicCluster ac = new AcademicCluster(clusterID, clusterName);
		acList.add(ac);
		
		System.out.println("Academic Cluster added");
		return acList;
	}
	
	public static ArrayList<AcademicCluster> removeCluster(ArrayList<AcademicCluster> clusterList) {
		String clusterID = Helper.readString("Enter Cluster ID > ");
		
		for (int i = 0; i < clusterList.size(); i++) {
			if (clusterID.equalsIgnoreCase(clusterList.get(i).getClusterID())) {
			clusterList.remove(i);
			
			System.out.println("Cluster " + clusterID + " is removed");
			break;
			} else {
				System.out.println("Invalid Cluster ID");
			}
		}
		return clusterList;
	}
	
	public static ArrayList<UserAccounts> addUserAcc (ArrayList<UserAccounts> addUserList){
		String userAccID = Helper.readString("Enter User ID: ");
		String userAccName = Helper.readString("Enter User Name: ");
		
		UserAccounts addUser = new UserAccounts(userAccID, userAccName);
		addUserList.add(addUser);
		
		System.out.println("User Account Has Been Added!");
		return addUserList;
	}
	
	public static ArrayList<UserAccounts> removeUserAcc (ArrayList<UserAccounts> removeUserList){
		String userID = Helper.readString("Enter User ID > ");
		
		for (int i = 0; i < userAccList.size(); i++) {
			if (userID.equalsIgnoreCase(userAccList.get(i).getUserID())) {
			userAccList.remove(i);
			
			System.out.println("User " + userID + " have been removed!");
			break;
			} 
			
			else {
				System.out.println("Invalid User ID!");
			}
		}
		
		return removeUserList;
	}
	
	public static String retrieveAllUsers(ArrayList<UserAccounts> userAccList) {
		String output = "";
		
		for (int i = 0; i < userAccList.size(); i++) {
			output += String.format("%-15s %-15s", userAccList.get(i).getUserID(), userAccList.get(i).getUserName());
		}
		return output;
	}
	
	public static void viewAllUsers (ArrayList<UserAccounts> userAccList) {
		String output = String.format("%-15s %-10s\n", "USER ID", "NAME");
		
		for (int i = 0; i < userAccList.size(); i++) {
			output += retrieveAllUsers(userAccList);
			System.out.println(output);
		}
	}
	
	
	public static String retrieveSubjects(ArrayList<Subjects> subjectList) {
		String output = "";
		
		for (int i = 0; i < subjectList.size(); i++) {
			output += String.format("%-15s %-15s", subjectList.get(i).getSubjectID(), subjectList.get(i).getSubjectName());
		}
		return output;
	}
	
	public static void viewSubjects(ArrayList<Subjects> subjectList2) {
		
		String output = String.format("%-14s %-15s\n", "SUBJECT ID", " SUBJECT NAME");
		
		for (int i = 0; i < subjectList.size(); i++) {
			output += retrieveSubjects(subjectList);
			System.out.println(output);
		}
		
	}

	public static ArrayList<Subjects> addSubjects(ArrayList<Subjects> addSubjectList) {

		String subjectID = Helper.readString("Enter Subject ID: ");
		String subjectName = Helper.readString("Enter Subject Name: ");
		
		Subjects addSubject = new Subjects(subjectID, subjectName);
		addSubjectList.add(addSubject);
		
		System.out.println("Subject Successfully Added!");
		return addSubjectList;
		
	}

	public static ArrayList<Subjects> deleteSubjects(ArrayList<Subjects> deleteSubjectList) {

		String subjectID = Helper.readString("Enter Subject ID > ");
		
		for (int i = 0; i < subjectList.size(); i++) {
			if (subjectID.equalsIgnoreCase(subjectList.get(i).getSubjectID())) {
			subjectList.remove(i);
			
			System.out.println("Subject " + subjectID + " has been successfully removed!");
			break;
			} 
			
			else {
				System.out.println("Invalid Subject ID!");
			}
		}
		
		return deleteSubjectList;
		
	}
	
}
