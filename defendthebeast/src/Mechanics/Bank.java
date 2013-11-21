package Mechanics;

public class Bank {
	private int totalMoney;

	public Bank(int money) {
		setMoney(money);
	}

	public int getMoney() {
		return totalMoney;
	}

	public void addMoney(int money) {
		totalMoney += money;
	}

	public void setMoney(int money) {
		totalMoney = money;
	}
	
	public String toString(){
		return getMoney() + "";
		
	}
}
