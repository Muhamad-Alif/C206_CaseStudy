import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private ArrayList<AcademicCluster> clusterList = new ArrayList<AcademicCluster>();
	static ArrayList<UserAccounts> userAccList = new ArrayList<UserAccounts>();
	private ArrayList<Subjects> subjectList = new ArrayList<Subjects>();

	@Before
	public void setUp() throws Exception {

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
	public void deleteInformationTest() {

		// Test career list is not null, so that there is a valid list to delete from.
		assertNotNull("Test career is empty not null", clusterList);

		// Test that system checks for existing career. System returns true when there
		// is same career in the list.
		clusterList.add(new AcademicCluster("R3", "Finance", "Accountant"));

		CareerPlanningApp.addInfo(clusterList, "R3", "Finance", "Tellers");

		Boolean check = CareerPlanningApp.existing(clusterList, "R3", "Finance");
		assertTrue(check);

		// Test that career information added is the same as test.

		assertEquals("Tellers", clusterList.get(0).getCareerInformation());

		// Test that system checks for existing career. System returns false when there
		// is no same career in the list.
		clusterList.remove(0);

		check = CareerPlanningApp.existing(clusterList, "R3", "Finance");
		assertFalse(check);

	}

	@Test
	public void addInformationTest() {

		// Test career list is not null, so that there is a valid list to add to.
		assertNotNull("Test career is empty not null", clusterList);

		// Test that career retrieved from main class is empty.
		String testOutput = "";
		String testList = CareerPlanningApp.retrieveCluster(clusterList);
		assertEquals(testOutput, testList);

		// Test that when career information is added, career information is the same as
		// the test.
		clusterList.add(new AcademicCluster("R3", "Finance", "Accountant"));
		CareerPlanningApp.addInfo(clusterList, "R3", "Finance", "Tellers");

		testOutput = "Tellers";
		assertEquals(testOutput, clusterList.get(0).getCareerInformation());

	}

	@Test
	public void viewInformationTest() {
		// Test career list is not null, so that there is a valid list to retrieve from.
		assertNotNull("Test career is empty not null", clusterList);

		// Test that career retrieved from main class is empty.
		String testOutput = "";
		String testList = CareerPlanningApp.retrieveCluster(clusterList);
		assertEquals(testOutput, testList);

		// Test that when career information is added, career information is the same as
		// the test.
		clusterList.add(new AcademicCluster("R3", "Finance", "Accountant"));
		CareerPlanningApp.addInfo(clusterList, "R3", "Finance", "Tellers");

		testOutput = "Tellers";
		assertEquals(testOutput, clusterList.get(0).getCareerInformation());

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

		// Test if the expected output string same as the list of all users retrieved
		// from the CareerPlanningApp
		allUserAcc = CareerPlanningApp.retrieveAllUsers(userAccList);

		output += String.format("%-15s %-10s", "1", "Kelsy Seah");

		assertEquals("Check that viewAllUsers", output, allUserAcc);
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
