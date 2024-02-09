//Jake Green
//CITC 1314-N40
//Capstone Project Dog Class
//4/2/2023
//This class will be used to store data about different dogs entered by the user.

public class Dog
{
	//variables
	private String name, owner, breed, color;
	private int age;
	private static int count;
	private double weight;
	private boolean food;

	Dog()
	{

	}

	Dog(String n, String o, int a, String b, double w, boolean f, String c)
	{
		name = n;
		owner = o;
		age = a;
		breed = b;
		weight = w;
		food = f;
		color = c;
		count++;
	}

	//gets the count
	public static int getCount()
	{
		return count;
	}

	//subtracts 1 from the count
	public static void subtractCount()
	{
		count -= 1;
	}

	//set and get name
	public void setName(String n)
	{
		name = n;
	}

	public String getName()
	{
		return name;
	}

	//set and get owner
	public void setOwner(String o)
	{
		owner = o;
	}

	public String getOwner()
	{
		return owner;
	}

	//set and get age
	public void setAge(int a)
	{
		age = a;
	}

	public int getAge()
	{
		return age;
	}

	//set and get breed
	public void setBreed(String b)
	{
		breed = b;
	}

	public String getBreed()
	{
		return breed;
	}

	//set and get weight
	public void setWeight(double w)
	{
		weight = w;
	}

	public double getWeight()
	{
		return weight;
	}

	//set and get food
	public void setFood(boolean f)
	{
		food = f;
	}

	public boolean getFood()
	{
		return food;
	}

	//set and get color
	public void setColor(String c)
	{
		color = c;
	}

	public String getColor()
	{
		return color;
	}

	//finds the life stage of the dog and returns it
	public String determineLife()
	{
		//if the dog is < 1 year old it will be classified as a puppy
		if(age < 1)
		{
			return "Puppy";
		}

		//if the dog is >= 1 year old and <= 3 years old it will be classified as an adolescent
		else if(age >= 1 && age <= 3)
		{
			return "Adolescent";
		}

		//if the dog is >= 4 years old and <= 8 years old it will be classified as an adult
		else if(age >= 4 && age <= 8)
		{
			return "Adult";
		}

		//if the dog is > 8 years old it will be classified as a senior
		else if(age > 8)
		{
			return "Senior";
		}

		else
		{
			return "";
		}

	}

	public String determineSize()
	{
		//if the dog is between 0 and 10 pounds it will be classified as small
		if(weight >= 0 && weight <= 10)
		{
			return "Small";
		}

		//if the dog is between 11 and 30  pounds it will be classified as medium
		else if(weight >= 11 && weight <= 30)
		{
			return "Medium";
		}

		//if the dog is between 31 and 100 pounds it will be classified as large
		else if(weight >= 31 && weight <= 100)
		{
			return "Large";
		}

		//if the dog is greater than 100 pounds it will be classified as Xlarge
		else if(weight > 100)
		{
			return "XLarge";
		}

		else
		{
			return "";
		}

	}

	//calculates the price with the size as a parameter
	public double priceForDay(String s)
	{
		if(s.equals("Small") || s.equals("Medium"))
		{
			if(food = false)
			{
				return 50;
			}
			else
			{
				return 45;
			}
		}
		else
		{
			return 45+0.1*weight;
		}
	}

	//calculates the price with the food as a parameter
	public double priceForDay(boolean f)
	{

		if(determineSize().equals("Small") || determineSize().equals("Medium"))
		{
			if(food = false)
			{
				return 50;
			}
			else
			{
				return 45;
			}
		}
		else
		{
			return 45+0.1*weight;
		}
	}

}