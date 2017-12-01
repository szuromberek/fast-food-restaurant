package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.LinkedList;
import java.util.List;

public class FastFoodRestaurant {

	public static void main(String[] args) throws InterruptedException {
		
		Cashier cashier = new Cashier();
		Robot robot = new Robot();
		Client firstClient = new Client("first client");
		Client secondClient = new Client("second client");
		OrderQueue orderQueue = new OrderQueue();
		
		cashier.setRobot(robot);
		cashier.setOrderQueue(orderQueue);
		cashier.addObserver(firstClient);
		cashier.addObserver(secondClient);
		
		robot.setCashier(cashier);
		robot.setOrderQueue(orderQueue);
		robot.addObserver(cashier);
		
		firstClient.setCashier(cashier);
		secondClient.setCashier(cashier);
		
		List<Extra> firstClientExtras = new LinkedList<Extra>();
		firstClientExtras.add(new Ketchup());
		firstClientExtras.add(new Mustard());
		
		List<Extra> secondClientExtras = new LinkedList<Extra>();
		secondClientExtras.add(new Ketchup());
		
		Order firstClientOrder = new Order(firstClient, new HotDog(), firstClientExtras);
		Order secondClientOrder = new Order(secondClient, new Chips(), secondClientExtras);
		
		firstClient.makeOrder(firstClientOrder);
		secondClient.makeOrder(secondClientOrder);
	}

}