import java.time.*;
import java.util.Scanner;

public class Client extends User {
    static Scanner sc = new Scanner(System.in);
    public int totalLoans = 0; 
    public int totalReturns = 0; 
    public int totalDebt;
    public int index = 0; //Controlador para el límite de ordenes

    //Crear cliente
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
            date = dateOne + " *Hora: "+ hour + ":" + minute;

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
        totalDebt = totalLoans - totalReturns; 
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
            date = dateOne + " *Hora: "+ hour + ":" + minute;

            String nameBasket = ""; 
            int quantityBasket = 0; 
            System.out.println("\nIngrese toda la información necesaria"); 
            System.out.print("Nombre de la canasta a devolver: "); 
            nameBasket = sc.nextLine(); 
            System.out.print("Cantidad a devolver: "); 
            quantityBasket = Integer.parseInt(sc.nextLine()); 
            ordersUser[index] = new Order("Devolución",date,nameBasket,quantityBasket); 
            index ++;
            totalReturns += quantityBasket; 
            System.out.println("\n\n«Transacción terminada»"); 
        } else System.out.println("\n\n¡Error: no se pueden crear más préstamos, ya supero el limite permitido!");
        totalDebt = totalLoans - totalReturns; 
    }    

    //Ver totales de lo que se presta, devuelve y debe
    public void seeConsolidates(){
        System.out.println("Total canastas prestadas: " + totalLoans); 
        System.out.println("Total canastas devueltas: " + totalReturns);
        System.out.println("Canastas que debe en estos momentos: " + totalDebt +"\n\n");
    }
}