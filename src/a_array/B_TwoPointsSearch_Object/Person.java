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
	 * ��ʾ��Ϣ
	 */
	public void displaysPersion() {
		System.out.println("lastName:" + lastName);
		System.out.println("firstName:" + firstName);
		System.out.println("age:" + age);

	}

	/**
	 * ������
	 * 
	 * @return
	 */
	public String getLast() {
		return lastName;
	}

}
