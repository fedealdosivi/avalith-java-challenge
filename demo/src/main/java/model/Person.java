package model;

public class Person {
	long id;
	String firsName;

	String lastName;
	int age;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirsName() {
		return firsName;
	}
	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Person(long id, String firsName, String lastName, int age) {
		this.id = id;
		this.firsName = firsName;
		this.lastName = lastName;
		this.age = age;
	}


	/**
	 * Returns haschcode from person
	 * @return hashcode
	 */
	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (firsName != null ? firsName.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + age;
		return result;
	}

	/**
	 * Compares obj with another object from the same type
	 *
	 * @param o
	 * @return true or false
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		if (id != person.id) return false;
		if (age != person.age) return false;
		if (firsName != null ? !firsName.equals(person.firsName) : person.firsName != null) return false;
		return lastName != null ? lastName.equals(person.lastName) : person.lastName == null;
	}



}

