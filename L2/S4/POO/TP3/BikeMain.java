public class BikeMain{

  public static void main(String[] args){
    Bike first = new Bike("b001", BikeModel.CLASSICAL);
    Bike second = new Bike ("b002", BikeModel.ELECTRIC);
    System.out.println(first.equals(second));
    System.out.println(first.toString());
    System.out.println(first.price());
  }
}
