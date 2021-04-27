public class Order {
    public String typeMovement; 
    public String dateAndHour; 
    public String nameBasket; 
    public int quantityBasket; 

    public Order(String typeMovement, String dateAndHour, String nameBasket, int quantityBasket){
        this.typeMovement = typeMovement; 
        this.dateAndHour = dateAndHour;
        this.nameBasket = nameBasket; 
        this.quantityBasket = quantityBasket;
    }

    public String toString(){
        System.out.println("Tipo de movimiento: " + typeMovement); 
        System.out.println("Fecha y hora: " + dateAndHour); 
        System.out.println("Nombre de la canastilla: " + nameBasket); 
        System.out.println("Cantidad canastilla: " + quantityBasket); 
        return "Holi";
    }
}