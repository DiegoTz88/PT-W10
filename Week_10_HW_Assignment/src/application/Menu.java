package application;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.FoodDao;
import entity.Food;


public class Menu {

	private FoodDao foodDao = new FoodDao();
	private Scanner scanner = new Scanner(System.in);
	
	private List<String> options = Arrays.asList(
			" Display Foods",
			" Create Food",
			" Delete Food");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try{
				if(selection.equals("1")) {
					displayFoods();
				} else if (selection.equals("2")) {
					createFood();
				} else if (selection.equals("3")) {
					deleteFood();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n-----------------");
		for(int i = 0; i < options.size(); i++) {
			System.out.println(i+1 + options.get(i));
		}
	}
	
	private void displayFoods() throws SQLException {
		List<Food> foods = foodDao.getFood();
		for(Food food : foods) {
			System.out.println(food.getFoodId() + ": " + food.getName());
		}
	}
	
	private void createFood() throws SQLException {
		System.out.print("Enter new food name: ");
		String foodName = scanner.nextLine();
		foodDao.createNewFood(foodName);
	}
	
	private void deleteFood() throws SQLException {
		System.out.print("Enter food id to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		foodDao.deleteFoodById(id);
	}
}
