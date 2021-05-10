package estrutura;

public class Client {
	
	private String name;
	private int age;
	
	public Client(String name, int age) {
		super();
		if (name.length() < 5)
			throw new IllegalArgumentException("Name is not valid, Name required at least 5 characters");
		if (age < 16)
			throw new IllegalArgumentException("Age is invalid! Too young!");
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public boolean isElderly() {
		if (this.age >= 60)
			return true;
		return false;
	}
}
