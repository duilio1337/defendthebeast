package Mechanics;

public class Bank {
	private int totalMoney;

	public Bank(int money) {
		setInitialMoney(money);
	}

	public int getMoney() {
		return totalMoney;
	}

	public void addMoney(int money) {
		totalMoney += money;
	}

	public void setInitialMoney(int money) {
		totalMoney = money;
	}

}
