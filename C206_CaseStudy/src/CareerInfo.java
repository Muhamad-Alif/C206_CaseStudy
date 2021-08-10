
public class CareerInfo {
	private String careerID;
	private String careerName;
	private String careerSect;

	public CareerInfo(String careerID, String careerName, String careerSect) {
		this.careerID = careerID;
		this.careerName = careerName;
		this.careerSect = careerSect;
	}

	public String getCareerID() {
		return careerID;
	}

	public void setCareerID(String careerID) {
		this.careerID = careerID;
	}

	public String getCareerName() {
		return careerName;
	}

	public void setCareerName(String careerName) {
		this.careerName = careerName;
	}

	public String getCareerSect() {
		return careerSect;
	}

	public void setCareerSect(String careerSect) {
		this.careerSect = careerSect;
	}

}
