
/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * Alif, Aug 9, 2021 10:22:10 AM 
 */

public class AcademicCluster {
	
	private String clusterID;
	private String clusterName;
	private String clusterRole;
	private String careerInformation;

	public AcademicCluster(String clusterID, String clusterName, String clusterRole) {
		this.clusterID = clusterID;
		this.clusterName = clusterName;
		this.clusterRole = clusterRole;
	}

	public AcademicCluster(String clusterID, String clusterName, String clusterRole, String careerInformation) {
		super();
		this.clusterID = clusterID;
		this.clusterName = clusterName;
		this.careerInformation = careerInformation;
	}

	public String getClusterID() {
		return clusterID;
	}

	public void setClusterID(String clusterID) {
		this.clusterID = clusterID;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getCareerInformation() {
		return careerInformation;
	}

	public void setCareerInformation(String careerInformation) {
		this.careerInformation = careerInformation;
	}

	public String getClusterRole() {
		return clusterRole;
	}

	public void setClusterRole(String clusterRole) {
		this.clusterRole = clusterRole;
	}

}
