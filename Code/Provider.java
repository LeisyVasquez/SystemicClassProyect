import java.time.*;
import java.util.Scanner;


public class Provider extends User {
    static Scanner sc = new Scanner(System.in);
    public int totalLoans = 0; 
    public int index = 0; //Controlador para el límite de ordenes

    public Provider(String name, String password, int phone){
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
            date = dateOne + " \n*Hora: "+ hour + ":" + minute;

            String nameBasket = ""; 
            int quantityBasket = 0; 
            System.out.println("\nIngrese toda la información necesaria"); 
            System.out.print("Nombre de la canasta a prestar: "); 
            nameBasket = sc.nextLine(); 
            System.out.print("Cantidad a prestar: "); 
            quantityBasket = Integer.parseInt(sc.nextLine()); 
            ordersUser[index] = new Order("Préstamo",date,nameBasket,quantityBasket); 
            index ++;
            totalLoans += quantityBasket; 
            System.out.println("\n\n«Transacción terminada»");    
        } else System.out.println("\n\n¡Error: no se pueden crear más préstamos, ya supero el limite permitido!");
    }

    //Ver totales de lo que la empresa le debe
    public void seeConsolidates(){
        System.out.println("Total canastas prestadas: " + totalLoans); 
    }



}