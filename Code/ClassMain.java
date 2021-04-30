import java.util.Scanner;

public class ClassMain {
    static Scanner sc = new Scanner(System.in);
    static SGBD SGBD = new SGBD(); 

    //Método para limpiar la consola
    static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //Método para salir de la aplicación o regresar al menú
    static boolean exitApplicationOrReturnMenu(){
        System.out.print("Regresar al menú (S/N): ");
        if(sc.nextLine().equalsIgnoreCase("S")) return false;
        else return true;
    }

    //Método para iniciar sesión
    static void login(){
        int flagTwo = 0;  //Tipo de usuario
        String nameUser = ""; 
        String passwordUser = ""; 
        clearConsole();
        System.out.println("****Bienvenido a SEIRC****\n"); 
        System.out.println("\nElija con que tipo de usuario desea iniciar sesión");
        System.out.println("1.Cliente");
        System.out.println("2.Proveedor");
        System.out.println("3.Sistema Gestor de base de datos");
        System.out.println("4.Salir");
        flagTwo = Integer.parseInt(sc.nextLine()); 
        if(flagTwo != 4){
            clearConsole();    
            System.out.println("****Bienvenido a SEIRC****");
            System.out.println("---Iniciar sesión---");       
            System.out.print("\n\nNombre del usuario: ");
            nameUser = sc.nextLine(); 
            System.out.print("Contraseña: "); 
            passwordUser = sc.nextLine(); 
        } 
            
        switch(flagTwo){
            //Iniciar sesión como cliente
            case 1:
                //Valida si los clientes ya están creados
                if(SGBD.clients != null){
                    boolean flagOne = false; //Valida si existe el cliente que desea iniciar sesión
                    //Si hay clientes registrados se recorren con el for
                    for(int i = 0; i < SGBD.clients.length; i++){
                        //Si el nombre de usuario es igual al que está registrado
                        if((SGBD.clients[i] != null) && ((SGBD.clients[i].name).equals(nameUser))){
                            //Se dice que el cliente que va a iniciar seción si existe
                            flagOne = true;
                            //Se verifica que el la contraseña se sea correcta
                            if((SGBD.clients[i].password).equals(passwordUser)){
                                boolean res = loginClient(SGBD.clients[i]);
                                while(!res) res = loginClient(SGBD.clients[i]);
                                System.out.println("\nRegrese pronto, SEIRC te espera :)");
                                login();        
                            } else {
                                System.err.println("\n\n¡Error: credenciales incorrectas, revise de nuevo sus datos!");
                                boolean res = exitApplicationOrReturnMenu();
                                if(!res) login(); 
                                else System.out.println("\nRegrese pronto, SEIRC te espera :)\n");
                            } 
                            //Se frena el caso porque ya se realizo las verificaciones necesarias 
                            break; 
                        }
                    }
                    //Si el usuario no existe porque el flagOne no ha cambiado su valor
                    if(!flagOne) System.out.println("\n\n¡Error: el usuario no existe, por lo tanto no puede iniciar sesión!");
                    boolean res = exitApplicationOrReturnMenu();
                    //Volver al login
                    if(!res) login(); 
                    //Salir de la aplicación
                    else System.out.println("\nRegrese pronto, SEIRC te espera :)\n");
                } else {
                    //Entra acá si los clientes aún no están registrados
                    System.out.println("\n\n¡Error: todavía no pueden iniciar sesión los clientes!"); 
                    boolean res = exitApplicationOrReturnMenu();
                        if(!res) login(); 
                        else System.out.println("Regrese pronto, SEIRC te espera :)\n");
                }
                break; 

            //Iniciar sesión como proveedor
            case 2:
                if(SGBD.providers != null){
                    boolean flagOne = false; //Valida si existe el proveedor que desea iniciar sesión
                    for(int i = 0; i < SGBD.providers.length; i++){
                        if((SGBD.providers[i] != null) && (SGBD.providers[i].name).equals(nameUser)){
                            flagOne = true;
                            if((SGBD.providers[i].password).equals(passwordUser)){
                                boolean res = loginProvider(SGBD.providers[i]);
                                while(!res) res = loginProvider(SGBD.providers[i]);
                                System.out.println("\nRegrese pronto, SEIRC te espera :)");
                                login();        
                            } else {
                                System.err.println("\n\n¡Error: credenciales incorrectas, revise de nuevo sus datos!");
                                boolean res = exitApplicationOrReturnMenu();
                                if(!res) login(); 
                                else System.out.println("\nRegrese pronto, SEIRC te espera :)\n");
                            } 
                            break; 
                        }
                    }
                    if(!flagOne) System.out.println("\n\n¡Error: el usuario no existe, por lo tanto no puede iniciar sesión!");
                    boolean res = exitApplicationOrReturnMenu();
                    if(!res) login(); 
                    else System.out.println("\nRegrese pronto, SEIRC te espera :)\n");
                } else {
                    System.out.println("\n\n¡Error: todavía no pueden iniciar sesión los proveedores!"); 
                    boolean res = exitApplicationOrReturnMenu();
                        if(!res) login(); 
                        else System.out.println("Regrese pronto, SEIRC te espera :)\n");
                }
                break; 

            //Iniciar sesión como Gestor de base de datos.
            case 3: 
                if((nameUser.equals("SEIRC")) && (passwordUser.equals("123456789"))){
                    clearConsole();
                    boolean res = loginSGBD();
                    while(!res) res = loginSGBD();
                    System.out.println("\nRegrese pronto, SEIRC te espera :)\n");
                    login();
                } else {
                    System.err.println("\n\n¡Error: credenciales incorrectas, revise de nuevo sus datos!");
                    boolean res = exitApplicationOrReturnMenu();
                    if(!res) login(); 
                    else System.out.println("\nRegrese pronto, SEIRC te espera :)\n");
                }
                break; 
            //Salir de la aplicación
            case 4: 
                clearConsole();
                System.out.println("\nRegrese pronto, SEIRC te espera :)\n");
                return; 
        }
    }

    //Acciones del SGBD
    static boolean loginSGBD(){
        int flagOne = 0;   
        clearConsole();
        System.out.println("****Usuario SEIRC****"); 
        System.out.println("---Menú de opciones---");    
        System.out.println("\n\nElija la acción que desea realizar"); 
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
                return exitApplicationOrReturnMenu(); 
            case 2: 
                SGBD.createProvider(); 
                return exitApplicationOrReturnMenu();
            case 3: 
                SGBD.createVideoTutorial();
                return exitApplicationOrReturnMenu();
            case 4: 
                SGBD.deleteClient(); 
                return exitApplicationOrReturnMenu(); 
            case 5: 
                SGBD.deleteProvider(); 
                return exitApplicationOrReturnMenu(); 
            case 6: 
                SGBD.deleteVideoTutorial();
                return exitApplicationOrReturnMenu();
            case 7: 
                return true;
        }
        return false;
    }

    //Acciones del cliente
    static boolean loginClient(Client clientUser){
        int flag = 0; //Se utiliza para el switch       
        clearConsole();
        System.out.println("****Usuario " + clientUser.name + "****"); 
        System.out.println("---Menú de opciones---\n\n");    
        System.out.println("Elija la acción que desea realizar"); 
        System.out.println("1.Ver información de su usuario en SEIRC"); 
        System.out.println("2.Ver video tutorial"); 
        System.out.println("3.Prestar canastas");
        System.out.println("4.Devolver canastas");
        System.out.println("5.Ver los préstamos y las devoluciones realizados");
        System.out.println("6.Ver consolidados");
        System.out.println("7.Cerrar sesión");
        flag = Integer.parseInt(sc.nextLine()); 
        clearConsole();
        System.out.println("****Usuario " + clientUser.name + "****"); 
        switch(flag){
            case 1: 
                System.out.println("---Ver información de usuario---\n\n");   
                System.out.println(clientUser.toString()); 
                System.out.println("Tipo de usuario: Cliente \n");
                return exitApplicationOrReturnMenu(); 
            case 2: 
                System.out.println("---Ver vídeo tutorial---\n\n");
                System.out.println(SGBD.videoTutorial1.toString()+"\n"); 
                return exitApplicationOrReturnMenu(); 
            case 3:
                System.out.println("---Préstamo de canastas---\n"); 
                clientUser.loanBasket();
                return exitApplicationOrReturnMenu(); 
            case 4: 
                System.out.println("---Devolución de canastas---\n"); 
                clientUser.returnBasket();
                return exitApplicationOrReturnMenu(); 
            case 5: 
                System.out.println("---Préstamos y devoluciones realizados---\n\n");
                clientUser.seeMovements(); 
                return exitApplicationOrReturnMenu(); 
            case 6:
                System.out.println("---Consolidado---\n\n"); 
                clientUser.seeConsolidates();
                return exitApplicationOrReturnMenu(); 
            case 7:
                return true; 
        }
        return false; 
    }

    //Acciones del proveedor
    static boolean loginProvider(Provider providerUser){
        int flag = 0;        
        clearConsole();
        System.out.println("****Usuario " + providerUser.name + "****"); 
        System.out.println("---Menú de opciones---\n\n");    
        System.out.println("Elija la acción que desea realizar"); 
        System.out.println("1.Ver información de su usuario en SEIRC"); 
        System.out.println("2.Ver vídeo tutorial"); 
        System.out.println("3.Prestar canastas");
        System.out.println("4.Ver los préstamos realizados");
        System.out.println("5.Ver consolidados");
        System.out.println("6.Cerrar sesión");
        flag = Integer.parseInt(sc.nextLine()); 
        clearConsole();
        System.out.println("****Usuario " + providerUser.name + "****"); 
        switch(flag){
            case 1: 
                System.out.println("---Ver información de usuario---\n\n");   
                System.out.println(providerUser.toString()); 
                System.out.println("Tipo de usuario: Proveedor \n");
                return exitApplicationOrReturnMenu(); 
            case 2:
                System.out.println("---Ver vídeo tutorial---\n\n");
                System.out.println(SGBD.videoTutorial2.toString()+"\n"); 
                return exitApplicationOrReturnMenu(); 
            case 3:
                System.out.println("---Préstamo de canastas---\n"); 
                providerUser.loanBasket();
                return exitApplicationOrReturnMenu(); 
            case 4: 
                System.out.println("---Préstamos realizados a la empresa---\n\n");
                providerUser.seeMovements(); 
                return exitApplicationOrReturnMenu(); 
            case 5:
                System.out.println("---Consolidado---\n\n"); 
                providerUser.seeConsolidates();
                return exitApplicationOrReturnMenu(); 
            case 6:
                return true; 
        }
        return false; 
    }

    //Método principal del proyecto 
    public static void main(String [] args){
        login(); 
    }
}