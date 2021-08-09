import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private ArrayList<AcademicCluster> clusterList = new ArrayList<AcademicCluster>();
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void viewCluster() {
		//fail("Not yet implemented"); 

		// Test if clusterList is not null but empty, so that can view list
		assertNotNull("Test if there is valid Cluster arrayList to add to", clusterList);
		
		//Test if the list of clusters retrieved from the CareerPlanningApp is empty
		String allCluster = CareerPlanningApp.retrieveCluster(clusterList);
		String output = "";
		assertEquals("Check that viewCluster", output, allCluster);
		
		//Given an empty list, after adding 1 item, test if the size of the list is 1
		clusterList = CareerPlanningApp.addCluster(clusterList);
		assertEquals("Test if that clusterList size is 1?", 1, clusterList.size());
		
		//Test if the expected output string same as the list of clusters retrieved from the CareerPlanningApp
		allCluster = CareerPlanningApp.retrieveCluster(clusterList);
		
		output += String.format("%-15s %-10s", "R1", "Agriculture, Food & Natural Resources");
		
		assertEquals("Check that viewCluster", output, allCluster);
	}
	
	@Test
	public void removeCluster() {
		//fail("Not yet implemented"); 
		
		// Test if clusterList is not null, so that can delete cluster
		assertNotNull("Test if there is valid clusterList to delete from", clusterList);
		
		//Given a list with 1 item, after deleting 1 item, the size of the list is 0
		CareerPlanningApp.removeCluster(clusterList);
		assertEquals("Test if the clusterList size is 0?", 0, clusterList.size());
	}
	
	@Test
	public void addCluster() {
		//fail("Not yet implemented"); 
		
		// Test if clusterList is not null, so that can add cluster
		assertNotNull("Test if there is valid clusterList to add to", clusterList);
		
		//Given an empty list, after adding 1 item, the size of the 
		clusterList = CareerPlanningApp.addCluster(clusterList);
		assertEquals("Test if that clusterList size is 1?", 1, clusterList.size());
	}

	@After
	public void tearDown() throws Exception {
		clusterList = null;
	}
}
