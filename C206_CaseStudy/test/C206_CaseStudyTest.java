import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private ArrayList<AcademicCluster> clusterList = new ArrayList<AcademicCluster>();
	private ArrayList<UserAccounts> userAccList = new ArrayList<UserAccounts>();
	private ArrayList<Subjects> subjectList = new ArrayList<Subjects>();

	private CareerInfo career1;
	private CareerInfo career2;
	private ArrayList<CareerInfo> careerList;

	@Before
	public void setUp() throws Exception {

		career1 = new CareerInfo("C1", "Social Worker", "Human Services");
		career2 = new CareerInfo("C2", "Cashier", "Marketing");

		careerList = new ArrayList<CareerInfo>();

	}

	@Test
	public void viewCluster() {
		// fail("Not yet implemented");

		// Test if clusterList is not null but empty, so that can view list
		assertNotNull("Test if there is valid Cluster arrayList to add to", clusterList);

		// Test if the list of clusters retrieved from the CareerPlanningApp is empty.
		String allCluster = CareerPlanningApp.retrieveCluster(clusterList);
		String output = "";
		assertEquals("Check that viewCluster", output, allCluster);

		// Given an empty list, after adding 1 item, test if the size of the list is 1
		clusterList.add(new AcademicCluster("R1", "Agriculture, Food & Natural Resources", "Chef"));
		assertEquals("Test if that clusterList size is 1?", 1, clusterList.size());
	}

	@Test
	public void removeCluster() {
		// fail("Not yet implemented");

		// Test if clusterList is not null, so that can delete cluster
		assertNotNull("Test if there is valid clusterList to delete from", clusterList);

		// Given a list with 1 item, after deleting 1 item, the size of the list is 0
		CareerPlanningApp.removeCluster(clusterList);
		assertEquals("Test if the clusterList size is 0?", 0, clusterList.size());
	}

	@Test
	public void addCluster() {
		// fail("Not yet implemented");

		// Test if clusterList is not null, so that can add cluster
		assertNotNull("Test if there is valid clusterList to add to", clusterList);

		// Given an empty list, after adding 1 item, the size of the
		clusterList.add(new AcademicCluster("R2", "Finance", "Accountant"));
		assertEquals("Test if that clusterList size is 1?", 1, clusterList.size());
	}

	@Test
	public void deleteInformationTest() { //gordon

		// Test career list is not null, so that there is a valid list to delete from.
		assertNotNull("Test career is empty not null", careerList);

		CareerPlanningApp.addInfo(careerList, career1);
		CareerPlanningApp.addInfo(careerList, career2);

		assertEquals("Test that careerList size is 2, after adding 2 career", 2, careerList.size());

		// Test that system checks for existing currencies.
		Boolean exist = CareerPlanningApp.existing(careerList, "C1", "Social Worker");
		assertTrue("Test that C1 exists in careerList", exist);

		CareerPlanningApp.deleteInfo(careerList, "C1", "Social Worker");
		exist = CareerPlanningApp.existing(careerList, "C1", "Social Worker");
		assertFalse("Test that C1 does not exist in careerList after removing", exist);

		// Test that careerList size reduces after removing 1.
		assertEquals("Test that careerList size is 1", 1, careerList.size());

		// Test that careerList is empty but not null if all career is removed from
		// careerList.
		CareerPlanningApp.deleteInfo(careerList, "C2", "Cashier");
		assertNotNull("Test that careerList is empty, not null", careerList);

		// Test that careerList size is 0 when all career is removed.
		assertEquals("Test that careerList size is 0", 0, careerList.size());

	}

	@Test
	public void addInformationTest() { //gordon

		// Test career list is not null, so that there is a valid list to add to.
		assertNotNull("Test career is empty not null", careerList);

		// Test that career list retrieved from main class is empty
		String testOutput = "";
		String testList = CareerPlanningApp.retrieveAllInformation(careerList);
		assertEquals("Check careerList is empty", testOutput, testList);

		// Test that when 1 career is added, the careerList size increases.
		CareerPlanningApp.addInfo(careerList, career1);
		assertEquals("Test that careerList size is 1", 1, careerList.size());

		// Test that system checks for duplicate entries
		Boolean duplicate = CareerPlanningApp.duplicate(careerList, career1);
		assertTrue("Test that system checks for duplicate entries", duplicate);

		// Test that system returns false if there is no duplicate entries
		duplicate = CareerPlanningApp.duplicate(careerList, career2);
		assertFalse("Test that system checks for duplicate entries", duplicate);

		// Test that details in careerList is same as added details
		CareerPlanningApp.addInfo(careerList, career2);

		testList = CareerPlanningApp.retrieveAllInformation(careerList);

		testOutput = String.format("%-10s %-30s %-30s\n", "C1", "Social Worker", "Human Services");
		testOutput += String.format("%-10s %-30s %-30s\n", "C2", "Cashier", "Marketing");

		assertEquals("Test that details is the same", testOutput, testList);

	}

	@Test 
	public void viewInformationTest() { //gordon

		// Test career list is not null, so that there is a valid list to retrieve from.
		assertNotNull("Test career is empty not null", careerList);

		// Test that career list retrieved from main class is empty
		String testOutput = "";
		String testList = CareerPlanningApp.retrieveAllInformation(careerList);
		assertEquals("Check careerList is empty", testOutput, testList);

		// Test that details in careerList is same as retrieved details
		CareerPlanningApp.addInfo(careerList, career1);
		CareerPlanningApp.addInfo(careerList, career2);

		testList = CareerPlanningApp.retrieveAllInformation(careerList);

		testOutput = String.format("%-10s %-30s %-30s\n", "C1", "Social Worker", "Human Services");
		testOutput += String.format("%-10s %-30s %-30s\n", "C2", "Cashier", "Marketing");

		assertEquals("Test that details is the same", testOutput, testList);

		// Test that when one career is removed, careerList does not delete other
		// details.
		CareerPlanningApp.deleteInfo(careerList, "C1", "Social Worker");

		assertEquals("Test that after removing 1 career, careerList size is 1", 1, careerList.size());

		testList = CareerPlanningApp.retrieveAllInformation(careerList);
		testOutput = String.format("%-10s %-30s %-30s\n", "C2", "Cashier", "Marketing");

		assertEquals("Test that details is the same", testOutput, testList);

	}

	@After
	public void tearDown() throws Exception {
		clusterList = null;
	}

	@Test
	public void viewAllUsers() {
		// fail("Not yet implemented");

		// Test if userAccList is not null but empty, so that it can view the list of
		// ALL users
		assertNotNull("Test if there is valid UserAcc arrayList to add to", userAccList);

		// Test if the list of all users retrieved from the CareerPlanningApp is empty
		String allUserAcc = CareerPlanningApp.retrieveAllUsers(userAccList);
		String output = "";
		assertEquals("Check that viewAllUsers", output, allUserAcc);

		// Given an empty list, after adding 1 item, test if the size of the list is 1
		userAccList = CareerPlanningApp.addUserAcc(userAccList);
		assertEquals("Test if that userAccList size is 1?", 1, userAccList.size());
	}

	@Test
	public void removeUserAcc() {
		// fail("Not yet implemented");

		// Test if userAccList is not null, so that it can delete User Account
		assertNotNull("Test if there is valid userAccList to delete from", userAccList);

		// Given a list with 1 item, after deleting 1 item, the size of the list is 0
		CareerPlanningApp.removeUserAcc(userAccList);
		assertEquals("Test if the userAccList size is 0?", 0, userAccList.size());
	}

	@Test
	public void addUserAcc() {
		// fail("Not yet implemented");

		// Test if userAccList is not null, so that it can add User Account
		assertNotNull("Test if there is valid userAccList to add to", userAccList);

		// Given an empty list, after adding 1 item, the size of the
		userAccList = CareerPlanningApp.addUserAcc(userAccList);
		assertEquals("Test if that userAccList size is 1?", 1, userAccList.size());
	}

	@After
	public void tearDownUC() throws Exception {
		userAccList = null;
	}

	@Test
	public void viewSubjects() {
		// fail("Not yet implemented");

		// Test that if subjectList is not null but empty, so that it can view the list
		// of ALL subjects
		assertNotNull("Test that if there is valid Subjects arrayList to add to", subjectList);

		// Test if the list of all subjects are retrieved from the CareerPlanningApp is
		// empty
		String allSubjects = CareerPlanningApp.retrieveSubjects(subjectList);
		String output = "";
		assertEquals("Check that viewSubjects", output, allSubjects);

		// Given an empty list, after adding 1 item, test if the size of the list is 1
		subjectList = CareerPlanningApp.addSubjects(subjectList);
		assertEquals("Test if that subjectList size is 1?", 1, subjectList.size());

		// Test if the expected output string same as the list of all subjects retrieved
		// from the CareerPlanningApp
		allSubjects = CareerPlanningApp.retrieveSubjects(subjectList);

		output += String.format("%-14s %-15s", "1", "Mathematics");

		assertEquals("Check that viewSubjects", output, allSubjects);
	}

	@Test
	public void addSubjects() {
		// fail("Not yet implemented");

		// Test that if subjectList is not null, so that it can add Subjects
		assertNotNull("Test if there is valid subjectList to add to", subjectList);

		// Given an empty list, after adding 1 item, the size of the
		subjectList = CareerPlanningApp.addSubjects(subjectList);
		assertEquals("Test if that subjectList size is 1?", 1, subjectList.size());
	}

	@Test
	public void deleteSubjects() {
		// fail("Not yet implemented");

		// Test if subejectList is not null, so that it can delete Subjects
		assertNotNull("Test if there is valid subjectList to delete from", subjectList);

		// Given a list with 1 item, after deleting 1 item, the size of the list is 0
		CareerPlanningApp.deleteSubjects(subjectList);
		assertEquals("Test if the subjectList size is 0?", 0, subjectList.size());
	}

	@After
	public void tearDownSubjects() throws Exception {
		subjectList = null;
	}

}
