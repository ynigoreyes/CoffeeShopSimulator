package CoffeeShopSimulator.ShopExampleProcedurally;
import java.util.Random;

public class Boss{

	private String name;
	private Random random = new Random();	// Random Number Generator

	public Boss(String name)
	{
		this.name = name;
	}

	public void PayEmployee(int Orders) // Based on Orders Served Pays Employee 50c on the Order
	{
		double pay = Orders * .50;
		System.out.println("*Boss has paid Employee " + pay +  "*\n");
	}

	public String[] NextMenu()	// Alternates Menu Between 3 Pre-Determined Menus Randomly
	{
		int num = random.nextInt(3);
		String[] Current = {};
		String[] Menu1 = {"Mocha", "Frappe", "Latte", "Coffee"};
		String[] Menu2 = {"Machiato", "Latte", "Coffee"};
		String[] Menu3 = {"Mocha", "Frappe", "Latte"};

		switch(num)
		{
			case 0: Current = Menu1;
			case 1: Current = Menu2;
			case 2: Current = Menu3;
		}
		return Current;
	}
}
