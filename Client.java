import java.time.*;
import java.util.Scanner;

public class Client extends User {

    //Definir cuantas ordenes son 
    public Order [] ordersClient = new Order[30]; 
    public int totalLoans = 0; 
    public int totalReturns = 0; 
    public int totalDebt = 0; 
    public int index = 0; 
    static Scanner sc = new Scanner(System.in);

    

    public Client(String name, String password, int phone){
        super(name, password, phone); 
    }
     

    //Prestar canastas
    public void loanBasket(){
        if(index <= 29){
            //Calcular la fecha y la hora
            String date;
            LocalDate dateOne = LocalDate.now();
            LocalTime time = LocalTime.now();
            String hour = String.valueOf(time.getHour());
            String minute = String.valueOf(time.getMinute());
            date = dateOne + " Hora: "+ hour + ":" + minute;

            String nameBasket = ""; 
            int quantityBasket = 0; 
            System.out.println("Nombre de la canasta a prestar: "); 
            nameBasket = sc.nextLine(); 
            System.out.println("Cantidad a prestar: "); 
            quantityBasket = Integer.parseInt(sc.nextLine()); 
            ordersClient[index] = new Order("Préstamo",date,nameBasket,quantityBasket); 
            index += index;
            totalLoans += quantityBasket; 
            totalDebt += quantityBasket; 
            System.out.println("Transacción terminada");
        } else 
            System.out.println("No se pueden crear más préstamos, ya supero el limite permitido");

      
    }

    //Devolver canastas
    public void returnBasket(){
        if(index <= 29){
            //Calcular la fecha y la hora
            String date;
            LocalDate dateOne = LocalDate.now();
            LocalTime time = LocalTime.now();
            String hour = String.valueOf(time.getHour());
            String minute = String.valueOf(time.getMinute());
            date = dateOne + " Hora: "+ hour + ":" + minute;

            String nameBasket = ""; 
            int quantityBasket = 0; 
            System.out.println("Nombre de la canasta a devolver: "); 
            nameBasket = sc.nextLine(); 
            System.out.println("Cantidad a devolver: "); 
            quantityBasket = Integer.parseInt(sc.nextLine()); 
            ordersClient[index] = new Order("Devolución",date,nameBasket,quantityBasket); 
            index += index;
            totalReturns += quantityBasket; 
            totalDebt -= quantityBasket;
            System.out.println("Transacción terminada");
        } else 
            System.out.println("No se pueden crear más devoluciones, ya supero el limite permitido");
    }
    
}