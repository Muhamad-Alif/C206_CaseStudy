import java.util.ArrayList;

public class CareerPlanningApp {

	static ArrayList<AcademicCluster> clusterList = new ArrayList<AcademicCluster>();
	static ArrayList<UserAccounts> userAccList = new ArrayList<UserAccounts>();
	static ArrayList<Subjects> subjectList = new ArrayList<Subjects>();
	static ArrayList<CareerInfo> careerList = new ArrayList<CareerInfo>();

	public static void main(String[] args) {

		clusterList.add(new AcademicCluster("R1", "Agriculture, Food & Natural Resources", "Chef"));

		userAccList.add(new UserAccounts("1", "Kelsy Seah"));
		subjectList.add(new Subjects("1", "Mathematics"));

		careerList.add(new CareerInfo("C1", "Elementary School Teacher", "Education and Training"));
		careerList.add(new CareerInfo("C2", "Computer Programmers", "Information Technology"));

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
				} else if (UserOption == 2) {
					CareerPlanningApp.addUserAcc(userAccList);
				} else if (UserOption == 3) {
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
					CareerPlanningApp.viewCluster(clusterList);

				} else if (ACOption == 2) {
					CareerPlanningApp.addCluster(clusterList);

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
					CareerPlanningApp.viewAllInformation(careerList);

				} else if (CIOption == 2) {
					CareerPlanningApp.addInformation(careerList, inputCareer());

				} else if (CIOption == 3) {
					CareerPlanningApp.deleteInformation(careerList);

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
			output += String.format("%-15s %-40s %-10s\n", clusterList.get(i).getClusterID(),
					clusterList.get(i).getClusterName(), clusterList.get(i).getClusterRole());
		}
		return output;
	}

	public static void viewCluster(ArrayList<AcademicCluster> clusterList) {
		String output = String.format("%-15s %-40s %-10s\n", "CLUSTER ID", "NAME", "ROLE");
		output += retrieveCluster(clusterList);
		System.out.println(output);
	}

	public static void addCluster(ArrayList<AcademicCluster> clusterList) {
		String clusterID = Helper.readString("Enter Cluster ID > ");
		String clusterName = Helper.readString("Enter Cluster Name > ");
		String clusterRole = Helper.readString("Enter Cluster Role > ");
		boolean isDupe = false;

		for (int i = 0; i < clusterList.size(); i++) {
			if (!clusterID.equalsIgnoreCase(clusterList.get(i).getClusterID())
					|| !clusterName.equals(clusterList.get(i).getClusterName())) {
				if (clusterID.isEmpty() || clusterName.isEmpty()) {
					System.out.println("Fill in the blanks");
					isDupe = true;
					break;
				}
			}
		}
		if (isDupe == false) {
			clusterList.add(new AcademicCluster(clusterID, clusterName, clusterRole));
			System.out.println("Academic Cluster added");

		}
	}

	public static ArrayList<AcademicCluster> removeCluster(ArrayList<AcademicCluster> clusterList) {
		String clusterID = Helper.readString("Enter Cluster ID > ");
		char confirm = Helper.readChar("Are you sure you want to delete " + clusterID + "? (y/n) >");
		if (confirm == 'Y' || confirm == 'y') {
			for (int i = 0; i < clusterList.size(); i++) {
				if (clusterID.equalsIgnoreCase(clusterList.get(i).getClusterID())) {
					clusterList.remove(i);

					System.out.println("Cluster " + clusterID + " has been removed");
					break;
				}
			}
		} else {
			System.out.println("Invalid Cluster ID");
		}
		return clusterList;
	}

	public static String retrieveAllInformation(ArrayList<CareerInfo> careerList) { //gordon
		String output = "";

		for (int i = 0; i < careerList.size(); i++) {
			if (careerList.get(i).getCareerSect() == null || careerList.get(i).getCareerSect().isEmpty()) {
				String sect = "-";
				output += String.format("%-10s %-30s %-30s\n", careerList.get(i).getCareerID(),
						careerList.get(i).getCareerName(), sect);

			} else if (careerList.get(i).getCareerName() == null || careerList.get(i).getCareerName().isEmpty()) {
				String name = "-";
				output += String.format("%-10s %-30s %-30s\n", careerList.get(i).getCareerID(), name,
						careerList.get(i).getCareerSect());

			} else {
				output += String.format("%-10s %-30s %-30s\n", careerList.get(i).getCareerID(),
						careerList.get(i).getCareerName(), careerList.get(i).getCareerSect());
			}
		}

		return output;
	}

	public static void viewAllInformation(ArrayList<CareerInfo> careerList) { //gordon

		Helper.line(80, "-");
		System.out.println("CAREER INFORMATION");
		Helper.line(80, "-");

		String output = String.format("%-10s %-30s %-30s\n", "CAREER ID", "CAREER NAME", "CAREER CLUSTER");
		output += retrieveAllInformation(careerList);

		System.out.println(output);
	}

	public static CareerInfo inputCareer() { //gordon

		Helper.line(80, "-");
		System.out.println("ADD CAREER INFORMATION");
		Helper.line(80, "-");

		String ID = Helper.readString("Enter career ID > ");
		String name = Helper.readString("Enter career name > ");
		String sect = Helper.readString("Enter career cluster > ");

		CareerInfo inf = new CareerInfo(ID, name, sect);

		return inf;

	}

	public static boolean duplicate(ArrayList<CareerInfo> careerList, CareerInfo inf) { //gordon
		boolean duplicate = false;

		for (int i = 0; i < careerList.size(); i++) {
			if (careerList.get(i).getCareerID().equalsIgnoreCase(inf.getCareerID())
					&& careerList.get(i).getCareerName().equalsIgnoreCase(inf.getCareerName())) {
				duplicate = true;
			}
		}

		return duplicate;
	}

	public static boolean addInfo(ArrayList<CareerInfo> careerList, CareerInfo inf) { //gordon
		boolean added = false;

		if (added == false) {
			careerList.add(inf);
			added = true;
		}

		return added;
	}

	public static void addInformation(ArrayList<CareerInfo> careerList, CareerInfo inf) { //gordon

		if (duplicate(careerList, inf)) {
			System.out.println("The career you are trying to add exists.");
			viewAllInformation(careerList);
			addInformation(careerList, inputCareer());

		} else {
			String option = Helper.readString("Are you sure you want to add new career? > ");
			if (option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes")) {
				if (addInfo(careerList, inf)) {
					System.out.println("Career is added successfully.");
				} else {
					System.out.println("Career add unsuccessful");
				}
			} else {
				System.out.println("Career add cancelled.");
			}
		}

	}

	public static boolean existing(ArrayList<CareerInfo> careerList, String id, String name) { //gordon
		boolean existing = false;

		for (int i = 0; i < careerList.size(); i++) {
			if (careerList.get(i).getCareerID().equalsIgnoreCase(id)
					&& careerList.get(i).getCareerName().equalsIgnoreCase(name)) {

				existing = true;
			}
		}

		return existing;
	}

	public static boolean deleteInfo(ArrayList<CareerInfo> careerList, String id, String name) { //gordon
		boolean delete = false;

		for (int i = 0; i < careerList.size(); i++) {
			if (careerList.get(i).getCareerID().equalsIgnoreCase(id)
					&& careerList.get(i).getCareerName().equalsIgnoreCase(name)) {

				careerList.remove(i);

				delete = true;
			}
		}

		return delete;
	}

	public static void deleteInformation(ArrayList<CareerInfo> careerList) { //gordon
		viewAllInformation(careerList);

		Helper.line(80, "-");
		System.out.println("DELETE CAREER INFORMATION");
		Helper.line(80, "-");

		String id = Helper.readString("Enter Career ID > ");
		String name = Helper.readString("Enter Career Name > ");

		if (existing(careerList, id, name)) {
			String option = Helper.readString("Are you sure you want to delete " + id + ", " + name + "? > ");

			if (option.equalsIgnoreCase("yes") || option.equalsIgnoreCase("y")) {

				Boolean delete = deleteInfo(careerList, id, name);

				if (delete) {
					System.out.println("Career Information deleted!");

				} else {
					System.out.println("Career Information not deleted!");
				}
			} else {
				System.out.println("Career Information delete cancelled!");

			}

		} else {
			System.out.println("Career does not exist!");
		}

	}

	public static ArrayList<UserAccounts> addUserAcc(ArrayList<UserAccounts> addUserList) {
		String userAccID = Helper.readString("Enter User ID: ");
		String userAccName = Helper.readString("Enter User Name: ");

		UserAccounts addUser = new UserAccounts(userAccID, userAccName);
		addUserList.add(addUser);

		System.out.println("User Account Has Been Added!");
		return addUserList;
	}

	public static ArrayList<UserAccounts> removeUserAcc(ArrayList<UserAccounts> removeUserList) {
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
			output += String.format("%-15s %-15s\n", userAccList.get(i).getUserID(), userAccList.get(i).getUserName());
		}
		return output;
	}

	public static void viewAllUsers(ArrayList<UserAccounts> userAccList) {
		String output = String.format("%-15s %-10s\n", "USER ID", "NAME");
		output += retrieveAllUsers(userAccList);

		System.out.println(output);
	}

	public static String retrieveSubjects(ArrayList<Subjects> subjectList) {
		String output = "";

		for (int i = 0; i < subjectList.size(); i++) {
			output += String.format("%-15s %-15s\n", subjectList.get(i).getSubjectID(),
					subjectList.get(i).getSubjectName());
		}
		return output;
	}

	public static void viewSubjects(ArrayList<Subjects> subjectList2) {

		String output = String.format("%-14s %-15s\n", "SUBJECT ID", " SUBJECT NAME");

		output += retrieveSubjects(subjectList);
		System.out.println(output);

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
		boolean deleteSubject = false;
		String subjectID = Helper.readString("Enter Subject ID > ");
		char confirm = Helper.readChar("Confirmation of delete? (Y/N) > ");
		
		if (confirm == 'Y' || confirm == 'y') {
			for (int i = 0; i < subjectList.size(); i++) {
			if (subjectID.equalsIgnoreCase(subjectList.get(i).getSubjectID())) {
				subjectList.remove(i);
				deleteSubject = true;
				System.out.println("Subject " + subjectID + " has been successfully removed!");
				break;
				}
			}
			
		} else {
				System.out.println("Invalid Subject ID!");
			
			}
			
			return deleteSubjectList;	
	
	
	}
}
