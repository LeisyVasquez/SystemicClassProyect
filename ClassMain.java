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
        String flagOne = ""; //Iniciar sesión
        int flagTwo = 0;  //Tipo de usuario
        String nameUser = ""; 
        String passwordUser = ""; 
        clearConsole();
        System.out.println("-----Bienvenido a SEIRC-----"); 
        System.out.print("¿Desea iniciar sesión? (S/N): "); 
        flagOne = sc.nextLine(); 
        if(flagOne.equalsIgnoreCase("S")){
            System.out.println("Elija con que tipo de usuario desea iniciar sesión");
            System.out.println("1. Cliente");
            System.out.println("2. Proveedor");
            System.out.println("3. Sistema Gestor de base de datos");
            System.out.println("4. Cancelar");
            flagTwo = Integer.parseInt(sc.nextLine());
            if(flagTwo != 4){
                System.out.print("\nNombre del usuario: ");
                nameUser = sc.nextLine(); 
                System.out.print("Contraseña: "); 
                passwordUser = sc.nextLine(); 
            }
            
            switch(flagTwo){
                case 1:
                    if(SGBD != null){
                        for(int i = 0; (SGBD.clients.length); i++){
                            if((SGBD.clients[i].name).equals(nameUser)){
                                if((SGBD.clients[i].password).equals(passwordUser)){
                                    loginClient(SGBD.clients[i]); 
                                }
                            }

                        }
                    } else 
                        System.out.println("Todavía no pueden iniciar sesión los clientes"); 

                    
                    break; 
                case 2: 
                    System.out.println("Inicio sesión con el proveedor");
                    break; 

                case 3: 
                    if((nameUser.equals("SEIRC")) && (passwordUser.equals("1"))){
                        clearConsole();
                        loginSGBD();
                    } else 
                        System.err.println("Credenciales incorrectas, revise de nuevo sus datos"); 
                    break; 
                case 4: 
                    System.out.println("Regrese pronto, SEIRC te espera :)\n");
                    break; 
            }
        } else 
            System.out.println("Regrese pronto, SEIRC te espera :)\n");
    }

    //Acciones del SGBD
    static void loginSGBD(){
        int flagOne = 0;        
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
                System.out.println("Regrese pronto, SEIRC te espera :)");
                login();
                break;
        }
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
        System.out.println("6.Cerrar sesión");
        flag = Integer.parseInt(sc.nextLine()); 
        switch(flag){
            case 1: 
                System.out.println(clientUser.toString()); 
                break;
            case 2: 
                System.out.println("Ver video tutorial"); 
                break;
            case 3:
                String nameBasket = ""; 
                int quantityBasket = 0; 
                System.out.println("****Usuario " + clientUser.name + "****"); 
                System.out.println("\n--Préstamo de canastas--"); 
                System.out.println("Nombre de la canasta a prestar: "); 
                nameBasket = sc.nextLine(); 
                System.out.println("Cantidad a prestar: "); 
                quantityBasket = Integer.parseInt(sc.nextLine()); 
                clientUser.loanBasket(nameBasket, quantityBasket);
                System.out.println("Transacción terminada"); 
                break; 
            case 4: 
                break; 
            case 5: 
                break; 
            case 6: 
                break; 
        }
    }

    public static void main(String [] args){
        login(); 
    }
}