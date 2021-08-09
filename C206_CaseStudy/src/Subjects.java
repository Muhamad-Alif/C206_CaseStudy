/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Starlyn Ong
 * Student ID: 20014394
 * Class: E66E
 * Date/Time created: Monday 09-08-2021 20:10
 */

/**
 * @author starlyn
 *
 */
public class Subjects {
	
	private String subjectID;
	private String subjectName;
	
	public Subjects(String subjectID, String subjectName) {
		this.subjectID = subjectID;
		this.subjectName = subjectName;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	

}
