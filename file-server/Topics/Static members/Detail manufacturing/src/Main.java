class ManufacturingController {
  private static int counter = 0;

  public static String requestProduct(String product) {
    // write your code here
    counter++;
    return counter + ". Requested " + product;
  }

  public static int getNumberOfProducts() {
    // write your code here
    return counter;
  }
}
