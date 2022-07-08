package entity;

public class Food {

	private int foodId;
	private String name;
	
	public Food(int foodId, String name) {
		this.setFoodId(foodId);
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
}
