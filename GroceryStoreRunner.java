import java.util.Scanner;

public class GroceryStoreRunner {

  public static void main(String[] args) {

    UserStory groceryAnalyzer = new UserStory(
      "stores.txt",
      "ingredients.txt",
      "prices.txt",
      "qualityRatings.txt"
    );

    System.out.println(groceryAnalyzer);
  }
}
