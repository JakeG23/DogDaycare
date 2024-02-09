//This program has a menu that allows the user to add or remove a dog from a stored array using the class.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DogDaycare
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		String name, owner, breed, color, foodAnswer, lifeStage;
		int tempIndex, selection, age, dogCount = 0;
		double weight;
		boolean found, food, validAge, validWeight, validSelection, menu = true;
		final int MAX_DOGS = 30;

		Dog[] dogs = new Dog[MAX_DOGS];

		//menu
		while(menu == true)
		{
			selection = 0;
			System.out.println("Welcome to this Doggy Day Care!");
			System.out.println("");
			System.out.println("Please enter the number corresponding to your selection.");
			System.out.println("1: Check In Dog.");
			System.out.println("2: Check Out Dog.");
			System.out.println("3: Exit.");

			validSelection = false;
			//loops until the user inputs an int
			while (validSelection == false)
			{

				//checks to see if user input is an int
				if(keyboard.hasNextInt())
				{
					selection = keyboard.nextInt();
					if(selection == 1 || selection == 2 || selection == 3)
					{
						validSelection = true;
					}
					else
					{
						System.out.println("Invalid input. Please Only Enter a 1, 2, or 3.");
					}
				}

				else
				{
					System.out.println("Invalid input. Please input a number.");

					//gets rid of incorrect input
					keyboard.next();
				}
			}
			//CHECK IN
			if(selection == 1)
			{
				//checks if the count is thirty
				if(Dog.getCount() != MAX_DOGS)
				{
					System.out.println("");
					System.out.println("You have chosen to check in a dog.");

					//dog name
					System.out.println("");
					System.out.println("Please enter the name of the dog you wish to check in: ");
					keyboard.nextLine();
					name = keyboard.nextLine();

					//loops until the user inputs something that isnt a blank space
					while(name.trim() == "")
					{
						System.out.println("Nothing was entered. Please enter the name of the dog: ");
						name = keyboard.nextLine();
					}
					name = name.toLowerCase();
					System.out.println("The dog's name is " + name + ".");

					//owner name
					System.out.println("");
					System.out.println("Please enter the owner's name: ");
					owner = keyboard.nextLine();

					//loops until the user inputs something that isnt a blank space
					while(owner.trim() == "")
					{
						System.out.println("Nothing was entered. Please enter the owner's name: ");
						owner = keyboard.nextLine();
					}
					owner = owner.toLowerCase();
					System.out.println("The owner's name is " + owner + ".");

					//dog breed
					System.out.println("");
					System.out.println("Please enter the dog's breed: ");
					breed = keyboard.nextLine();

					//loops until the user inputs something that isnt letters or is empty
					while(!breed.matches("[a-zA-Z ]+") || breed.trim() == "")
					{
						if(breed.trim() == "")
						{
							System.out.println("Nothing was entered. Please enter the dog's breed: ");
							breed = keyboard.nextLine();
						}
						else
						{
							System.out.println("Please only enter letters.");
							breed = keyboard.nextLine();
						}
					}
					breed = breed.toLowerCase();
					System.out.println("The dog's breed is " + breed + ".");

					//dog color
					System.out.println("");
					System.out.println("Please enter the dog's color: ");
					color = keyboard.nextLine();

					//loops until the user inputs something that isnt a blank space
					while(!color.matches("[a-zA-Z ]+")|| color.trim() == "")
					{
						//if the user entered nothing
						if(color.trim() == "")
						{
							System.out.println("Nothing was entered. Please enter the dog's color: ");
							color = keyboard.nextLine();
						}
						//if the user enters numbers
						else
						{
							System.out.println("Please only enter letters.");
							color = keyboard.nextLine();
						}
					}
					color = color.toLowerCase();
					System.out.println("The dog's color is " + color + ".");

					//dog's age
					age = 0;
					System.out.println("");
					System.out.println("Please enter the dog's age in years: ");
					validAge = false;
					//loops until the user inputs an int
					while (validAge == false)
					{

						//checks to see if user input is an int
						if(keyboard.hasNextInt())
						{
							age = keyboard.nextInt();
							validAge = true;
						}

						else
						{
							System.out.println("Invalid input. Please input a number.");

							//gets rid of incorrect input
							keyboard.next();
						}
					}
					System.out.println("The dog's age is " + age + ".");

					//dog's weight
					weight = 0;
					System.out.println("");
					System.out.println("Please enter the dog's weight in pounds: ");
					validWeight = false;
					//loops until the user inputs a double
					while (validWeight == false)
					{

						//checks to see if user input is a double
						if(keyboard.hasNextDouble())
						{
							weight = keyboard.nextDouble();
							validWeight = true;
						}

						else
						{
							System.out.println("Invalid input. Please input a number.");

							//gets rid of incorrect input
							keyboard.next();
						}
					}
					System.out.println("The dog's weight is " + weight + ".");

					//food brought
					System.out.println("");
					System.out.println("Did this dog bring its own food? ");
					System.out.println("Please enter 'yes' or 'no':");
					keyboard.nextLine();
					foodAnswer = keyboard.nextLine();
					foodAnswer = foodAnswer.toLowerCase();

					//loops until the user inputs yes or no
					while(!foodAnswer.equals("yes") && !foodAnswer.equals("no"))
					{
						System.out.println("Incorrect input. Please enter either 'yes' or 'no': ");
						foodAnswer = keyboard.nextLine();
						foodAnswer = foodAnswer.toLowerCase();

					}
					if(foodAnswer.equals("yes"))
					{
						food = true;
						System.out.println("This dog did bring its own food.");
					}
					else
					{
						food = false;
						System.out.println("This dog did not bring its own food.");
					}
					System.out.println("");

					found = false;
					for(int a = 0; a < MAX_DOGS; a++)
					{
						//catches nulls to avoid error
						try
						{
							//if the dog name matches the search name
							if(dogs[a].getName().equals(name))
							{
								//checks to see if the owner name matches the search name
								if(dogs[a].getOwner().equals(owner))
								{
									//removes the dog and its info from the array
									System.out.println("This dog has already been registered.");
									found = true;
								}
							}
						}
						catch(Exception ex)
						{

						}
					}
					//if the dog was never found
					if(found == false)
					{
						Dog dog = new Dog(name, owner, age, breed, weight, food, color);

						tempIndex = 0;
						//loops through the array to find an empty spot and places the current object into that spot
						while(tempIndex < MAX_DOGS && tempIndex != -1)
						{
							if(dogs[tempIndex] == null)
							{
								dogs[tempIndex] = dog;
								System.out.println("The price of one day for this dog is: $" + String.format("%.2f", dogs[tempIndex].priceForDay(dogs[tempIndex].getFood())));
								tempIndex = -1;
							}
							if(tempIndex != -1)
							{
								tempIndex++;
							}
						}
					}
				}
				else
				{
					System.out.println("We are at maximum capacity. Sorry for the inconvience.");
				}
			}
			//CHECK OUT
			else if(selection == 2)
			{
				keyboard.nextLine();
				System.out.println("");
				System.out.println("You have chosen to check out a dog.");

				//check out owner name
				System.out.println("Please enter the owner's name of the dogs you wish to check out: ");

				owner = keyboard.nextLine();

				//loops until the user inputs something that isnt a blank space
				while(owner.trim() == "")
				{
					System.out.println("Nothing was entered. Please enter the name of the owner: ");
					owner = keyboard.nextLine();
				}

				owner = owner.toLowerCase();
				//searches for dog name
				found = false;
				System.out.println("");
				for(int x = 0; x < MAX_DOGS; x++)
				{
					//catches nulls to avoid error
					try
					{
						//if the dog name matches the search name
						if(dogs[x].getOwner().equals(owner))
						{
							System.out.println(dogs[x].getName());
							//removes the dog and its info from the array
							dogs[x] = null;
							found = true;
							Dog.subtractCount();
						}
					}
					catch(Exception ex)
					{

					}
				}
				//if the dog was never found
				if(found == false)
				{
					System.out.println("There were no dogs found that were registered under this owner.");
				}
				//if it was found, fill in the space in the array that it left.
				else
				{
					System.out.println("These dogs were found and checked out.");
					for(int y = 0; y < MAX_DOGS; y++)
					{
						if(dogs[y] == null)
						{

							for(int z = y + 1; z < MAX_DOGS; z++)
							{
								if(dogs[z] != null)
								{
									dogs[y] = dogs[z];
									dogs[z] = null;
									break;
								}
							}
						}
					}
				}

			}
			//EXIT
			else if(selection == 3)
			{
				try
				{
				FileWriter fileWriter = new FileWriter("YesterdaysLatePickups.txt");

				fileWriter.write("Total Dogs: " + Dog.getCount() + "\n");
				for(int dis = 0; dis < MAX_DOGS; dis++)
				{
					if(dogs[dis] != null)
					{
						fileWriter.write("\nDog " + (dis + 1));
						fileWriter.write("\n");
						fileWriter.write("\nName: " + dogs[dis].getName());
						fileWriter.write("\nOwner: " + dogs[dis].getOwner());
						fileWriter.write("\nBreed: " + dogs[dis].getBreed());
						fileWriter.write("\nColor: " + dogs[dis].getColor());
						fileWriter.write("\nAge: " + dogs[dis].getAge());
						fileWriter.write("\nLife Stage: " + dogs[dis].determineLife());
						fileWriter.write("\nWeight: " + String.format("%.2f", dogs[dis].getWeight()) + " lbs");
						fileWriter.write("\nSize: " + dogs[dis].determineSize());
						if(dogs[dis].getFood() == true)
						{
							fileWriter.write("\nBrought Food?: Yes");
						}
						else
						{
							fileWriter.write("\nBrought Food?: No");
						}
						fileWriter.write("\nPrice for Day: $" + String.format("%.2f", dogs[dis].priceForDay(dogs[dis].determineSize())));
						fileWriter.write("\n");
					}
				}
				fileWriter.close();
				System.out.println("Successfully wrote to the file.");
				}

				catch (IOException e)
				{
				System.out.println("An error occurred while writing to the file.");
				e.printStackTrace();
        		}

				System.out.println("");
				System.out.println("Goodbye!");
				menu = false;
			}
		}
	}
}