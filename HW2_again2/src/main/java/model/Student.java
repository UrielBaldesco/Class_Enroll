package model;

public class Student {
	private String name;
	private String parent;
	private String parentEmail;
	private int age;
	private String groupName;
	private int id;
//	private int groupId;
//	static int idSeed=1;
	
//	public Student(String name, String parent, String parentEmail, String age, String groupName) {
//		this.name = name;
//		this.parent = parent;
//		this.parentEmail = parentEmail;
//		this.age = Integer.parseInt(age);
//		this.groupName = groupName;
//		this.id=idSeed++;
//	}
	public Student() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


//	public int getGroupId() {
//		return groupId;
//	}
//
//	public void setGroupId(int groupId) {
//		this.groupId = groupId;
//	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
