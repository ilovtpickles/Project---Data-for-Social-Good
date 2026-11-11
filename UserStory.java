import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class UserStory {

  // Arrays to store the grocery information
  private String[] names;
  private String[] ingredients;
  private double[] prices;
  private double[] ratings;

  // Arrays to store grocery objects and their value scores
  private GroceryStore[] stores;
  private double[] valueScores;

  /**
   * Reads information from four files and stores the data in arrays
   */
  public UserStory(String nameFile, String ingredientFile,
                   String priceFile, String ratingFile) {

    // Create arrays that can hold 6 grocery listings
    names = new String[6];
    ingredients = new String[6];
    prices = new double[6];
    ratings = new double[6];

    stores = new GroceryStore[6];
    valueScores = new double[6];

    try {

      // Read store names from the file
      Scanner nameInput = new Scanner(new File(nameFile));

      for (int i = 0; i < 6; i++) {
        names[i] = nameInput.nextLine();
      }

      nameInput.close();

      // Read ingredient names from the file
      Scanner ingredientInput =
        new Scanner(new File(ingredientFile));

      for (int i = 0; i < 6; i++) {
        ingredients[i] = ingredientInput.nextLine();
      }

      ingredientInput.close();

      // Read prices from the file
      Scanner priceInput = new Scanner(new File(priceFile));

      for (int i = 0; i < 6; i++) {
        prices[i] = priceInput.nextDouble();
      }

      priceInput.close();

      // Read quality ratings from the file
      Scanner ratingInput =
        new Scanner(new File(ratingFile));

      for (int i = 0; i < 6; i++) {
        ratings[i] = ratingInput.nextDouble();
      }

      ratingInput.close();

      // Create a GroceryStore object for each listing
      for (int i = 0; i < 6; i++) {

        stores[i] = new GroceryStore(
          names[i], ingredients[i], prices[i], ratings[i]
        );

        // Divide the quality rating by the price to find the value
        if (prices[i] > 0) {
          valueScores[i] = ratings[i] / prices[i];
        }
      }

    } catch (IOException e) {
      // Print an error if the files cannot be read
      System.out.println("Error reading files.");
    }
  }

  /**
   * Finds the average price of all grocery listings.
   */
  public double getAveragePrice() {

    // Start the total at 0
    double total = 0;

    // Go through each price and add it to the total
    for (int i = 0; i < prices.length; i++) {
      total += prices[i];
    }

    // Divide the total by the number of prices
    return total / prices.length;
  }

  /**
   * Finds the ingredient with the highest quality.
   */
  public GroceryStore findBestQuality() {

    
    int highest = 0;

    // Check the rest of the ratings
    for (int i = 1; i < ratings.length; i++) {

      // If the current rating is higher, update the index
      if (ratings[i] > ratings[highest]) {
        highest = i;
      }
    }

    // Return the grocery listing with the highest rating
    return stores[highest];
  }

  /**
   * Finds the grocery listing with the best quality for its price.
   */
  public GroceryStore getBestValue() {

    // Start by assuming the first listing has the best value
    int best = 0;

    // Go through the rest of the value scores
    for (int i = 1; i < valueScores.length; i++) {

      // Check if the current value score is higher
      if (valueScores[i] > valueScores[best]) {

        // Save the index of the new best value
        best = i;
      }
    }

    // Return the grocery listing with the best value
    return stores[best];
  }

  /**
   * Returns general information about the grocery data.
   */
  public String toString() {

    // Display the number of listings, average price, best quality, and best value
    return "Grocery Store Ingredient Analyzer"
      + "\nNumber of Listings: " + stores.length
      + "\nAverage Price: $" + getAveragePrice()
      + "\nBest Quality: " + findBestQuality()
      + "\nBest Value: " + getBestValue();
  }
}
