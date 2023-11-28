package model;

public class StudentGroups {
	private String groupName;
	private int idGroup;
//	static int idSeed=1;
	
	public StudentGroups() {
		
	}

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
