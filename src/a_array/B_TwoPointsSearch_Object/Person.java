package a_array.B_TwoPointsSearch_Object;

public class Person {
	private String lastName;
	private String firstName;
	private int age;

	public Person(String lastName, String firstName, int age) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}

	/**
	 * 显示信息
	 */
	public void displaysPersion() {
		System.out.println("lastName:" + lastName);
		System.out.println("firstName:" + firstName);
		System.out.println("age:" + age);

	}

	/**
	 * 返回姓
	 * 
	 * @return
	 */
	public String getLast() {
		return lastName;
	}

}
