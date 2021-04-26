import java.util.Scanner;

public class ClassMain{
    static Scanner sc = new Scanner(System.in);

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

        System.out.println("-----Bienvenido a SEIRC-----"); 
        System.out.print("¿Desea iniciar sesión? (S/N): "); 
        flagOne = sc.nextLine(); 
        if(flagOne.equalsIgnoreCase("S")){
            System.out.println("Elija con que tipo de usuario desea iniciar sesión");
            System.out.println("1. Cliente");
            System.out.println("2. Proveedor");
            System.out.println("3. Sistema Gestor de base de datos");
            System.out.println("4. Salir");
            flagTwo = Integer.parseInt(sc.nextLine());
            System.out.print("Nombre del usuario: ");
            nameUser = sc.nextLine(); 
            System.out.print("Contraseña: "); 
            passwordUser = sc.nextLine(); 

            switch(flagTwo){
                case 1: 
                    System.out.println("Inicio sesión con el cliente"); 
                    break; 
                case 2: 
                    System.out.println("Inicio sesión con el proveedor");
                    break; 

                case 3: 
                    if((nameUser.equals("SEIRC")) && (passwordUser.equals("123456789"))){
                        clearConsole();
                        loginSGBD();
                    } else 
                        System.err.println("Credenciales incorrectas, revise de nuevo sus datos"); 
                    break; 
                case 4: 
                    System.out.println("Regrese pronto, SEIRC te espera :)");
                    break; 
            }
        } else 
            System.out.println("Regrese pronto, SEIRC te espera :)");
    }

    //Acciones del SGBD
    static void loginSGBD(){
        SGBD SGBD = new SGBD(); 
        int flagOne = 0;        
        System.out.println("****Ingresó como SEIRC****"); 
        System.out.println("\nElija la acción que desea realiza"); 
        System.out.println("1.Crear cliente"); 
        System.out.println("2.Crear proveedor"); 
        System.out.println("3.Crear video tutorial");
        System.out.println("4.Eliminar cliente");
        System.out.println("5.Eliminar proveedor");
        System.out.println("6.Eliminar video tutorial"); 
        System.out.println("7.Cerra sesión");
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


    public static void main(String [] args){
        login(); 
    }
}