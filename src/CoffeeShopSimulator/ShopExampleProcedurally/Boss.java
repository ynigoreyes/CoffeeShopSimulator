package CoffeeShopSimulator.ShopExampleProcedurally;

public class Boss{

	private String name;
	private Hashtable Supplies = new HashTable();
	private String[] Menu1 = {"Mocha", "Frappe", "Latte", "Coffee"};
	private String[] Menu2 = {"Machiato", "Latte", "Coffee"};
	private String[] Menu3 = {"Mocha", "Frappe", "Latte"};

	public Boss(String name)
	{
		this.name = name;
	}

	public double PayEmployee(int Orders) // Based on Orders Served Pays Employee 50c on the Order
	{
		double pay = Orders * .50;
		return pay;
	}

}
