import java.util.Scanner;

public class ClassMain{
    static Scanner sc = new Scanner(System.in);
    static SGBD SGBD = new SGBD(); 


    //Método para limpiar la consola
    static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //Método para iniciar sesión
    static void login(){
        int flagTwo = 0;  //Tipo de usuario
        String nameUser = ""; 
        String passwordUser = ""; 
        clearConsole();
        System.out.println("-----Bienvenido a SEIRC-----"); 
        System.out.println("Elija con que tipo de usuario desea iniciar sesión");
        System.out.println("1. Cliente");
        System.out.println("2. Proveedor");
        System.out.println("3. Sistema Gestor de base de datos");
        System.out.println("4. Salir");
        flagTwo = Integer.parseInt(sc.nextLine());                             
        if(flagTwo != 4){
            System.out.print("\nNombre del usuario: ");
            nameUser = sc.nextLine(); 
            System.out.print("Contraseña: "); 
            passwordUser = sc.nextLine(); 
        } 
            
        switch(flagTwo){
            case 1:
                if(SGBD.clients != null){
                    for(int i = 0; i < SGBD.clients.length; i++){
                        if((SGBD.clients[i].name).equals(nameUser)){
                            if((SGBD.clients[i].password).equals(passwordUser)){
                                loginClient(SGBD.clients[i]);
                                break; 
                            }
                        }
                    }
                    System.out.println("Los datos son incorrectos o no está registrado en SEIRC, intenté de nuevo o regrese más tarde"); 
                    } else 
                        System.out.println("Todavía no pueden iniciar sesión los clientes"); 
                    break; 

                case 2: 
                    System.out.println("Inicio sesión con el proveedor");
                    break; 

                case 3: 
                    if((nameUser.equals("SEIRC")) && (passwordUser.equals("1"))){
                        clearConsole();
                        boolean res = loginSGBD();
                        while(!res){
                            res = loginSGBD();
                        }
                        System.out.println("\nRegrese pronto, SEIRC te espera :)");
                        login();

                        
                        
                login();
                    } else {
                        System.err.println("Credenciales incorrectas, revise de nuevo sus datos.");
                        System.out.println("¿Desea reintentar? (S/N)"); 
                        if((sc.nextLine()).equalsIgnoreCase("S")){
                            login(); 
                        } else 
                            System.out.println("Regrese pronto, SEIRC te espera :)\n");
                    } 
                        
                    break; 
                case 4: 
                    System.out.println("Regrese pronto, SEIRC te espera :)\n");
                    break; 
            }
       
    }

    //Acciones del SGBD
    static boolean loginSGBD(){
        int flagOne = 0;   
        clearConsole();     
        System.out.println("****Ingresó como SEIRC****"); 
        System.out.println("\nElija la acción que desea realizar"); 
        System.out.println("1.Crear cliente"); 
        System.out.println("2.Crear proveedor"); 
        System.out.println("3.Crear video tutorial");
        System.out.println("4.Eliminar cliente");
        System.out.println("5.Eliminar proveedor");
        System.out.println("6.Eliminar video tutorial"); 
        System.out.println("7.Cerrar sesión");
        flagOne = Integer.parseInt(sc.nextLine());   
        switch(flagOne){
            case 1:
                SGBD.createClient();
                break; 
            case 2: 
                SGBD.createProvider(); 
                break;
            case 3: 
                SGBD.createVideoTutorial();
                break;
            case 4: 
                SGBD.deleteClient(); 
                break;
            case 5: 
                SGBD.deleteProvider(); 
                break; 
            case 6: 
                SGBD.deleteVideoTutorial();
                break; 
            case 7: 
                return true;
        }
        return false;
    }

    //Acciones del cliente
    static void loginClient(Client clientUser){
        int flag = 0;        
        System.out.println("****Ingresó como " + clientUser.name + "****"); 
        System.out.println("\nElija la acción que desea realizar"); 
        System.out.println("1.Ver información de su usuario en SEIRC"); 
        System.out.println("2.Ver video tutorial"); 
        System.out.println("3.Prestar canastas");
        System.out.println("4.Devolver canastas");
        System.out.println("5.Ver los préstamos y devoluciones realizados");
        System.out.println("6.Ver consolidados");
        System.out.println("7.Cerrar sesión");
        flag = Integer.parseInt(sc.nextLine()); 
        switch(flag){
            case 1: 
                System.out.println(clientUser.toString()); 
                break;
            case 2: 
                clearConsole();
                System.out.println("****Usuario " + clientUser.name + "****\n"); 
                System.out.println("-Vídeo tuturial");
                SGBD.videoTutorial1.toString(); 
                break;
            case 3:
                System.out.println("****Usuario " + clientUser.name + "****\n"); 
                System.out.println("--Préstamo de canastas--"); 
                clientUser.loanBasket();
                break; 
            case 4: 
                System.out.println("****Usuario " + clientUser.name + "****\n"); 
                System.out.println("--Devolución de canastas--"); 
                clientUser.returnBasket();
                break; 
            case 5: 
                System.out.println("****Usuario " + clientUser.name + "****\n"); 
                System.out.println("--Préstamos y devoluciones realizados--");
                for(int i = 0; i < clientUser.ordersClient.length; i++){
                    System.out.println("\nOrden "+ (i+1));
                    System.out.println("Tipo de movimiento: " + clientUser.ordersClient[i].typeMovement); 
                    System.out.println("Fecha " + clientUser.ordersClient[i].dateAndHour); 
                    System.out.println("Nombre de la canasta: " + clientUser.ordersClient[i].nameBasket); 
                    System.out.println("Cantidad de la canasta: " + clientUser.ordersClient[i].quantityBasket); 
                } 
                break; 
            case 7:
                System.out.println("****Usuario " + clientUser.name + "****\n"); 
                System.out.println("Total canastas prestadas: " + clientUser.totalLoans); 
                System.out.println("Total canastas devueltas: " + clientUser.totalReturns);
                System.out.println("Canastas que debe en estos momentos: " + clientUser.totalReturns);
                break; 
        }
    }

    public static void main(String [] args){
        login(); 
    }
}