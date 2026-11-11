public class GroceryStore {

  private String storeName;
  private String ingredient;
  private double price;
  private double quality;

  // No-argument constructor
  public GroceryStore() {
    storeName = "Unknown";
    ingredient = "Unknown";
    price = 0.0;
    quality = 0.0;
  }

  // Parameterized constructor
  public GroceryStore(String storeName, String ingredient,
                      double price, double quality) {
    this.storeName = storeName;
    this.ingredient = ingredient;
    this.price = price;
    this.quality = quality;
  }

  // Accessor methods

  public String getStoreName() {
    return storeName;
  }

  public String getIngredient() {
    return ingredient;
  }

  public double getPrice() {
    return price;
  }

  public double getQuality() {
    return quality;
  }

  // Returns information about the grocery listing
  public String toString() {
    return storeName + " - " + ingredient
      + " | $" + price
      + " | Quality: " + quality + "/10";
  }
}

