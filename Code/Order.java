public class Order {
    public String typeMovement; 
    public String dateAndHour; 
    public String nameBasket; 
    public int quantityBasket; 

    //Crear orden
    public Order(String typeMovement, String dateAndHour, String nameBasket, int quantityBasket){
        this.typeMovement = typeMovement; 
        this.dateAndHour = dateAndHour;
        this.nameBasket = nameBasket; 
        this.quantityBasket = quantityBasket;
    }

    //Mostrar los valores de los atributos de la orden
    public String toString(){
        return "*Tipo de movimiento: " + typeMovement + "\n*Fecha: " + dateAndHour + "\n*Nombre de la canastilla: " + nameBasket + "\n*Cantidad canastilla: " + quantityBasket;
    }
}