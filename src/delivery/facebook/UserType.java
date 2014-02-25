package delivery.facebook;

public enum UserType {
	NORMAL("Энгийн"), BRONZE("Хүр�?л"), SILVER("Мөнгөн"), GOLD("�?лтан");

	private String name;

	private UserType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
