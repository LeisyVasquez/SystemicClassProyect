import java.util.Scanner;

public class SGBD {
    Scanner sc = new Scanner(System.in);
    public Client clients [] = null; 
    public Provider providers [] = null; 
    public VideoTutorial videoTutorial1 = null; 
    public VideoTutorial videoTutorial2 = null; 

    //Método para limpiar consola
    static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //Método para crear cliente
    public void createClient(){
        String name = ""; 
        String password = ""; 
        int phone = 0; 
        clearConsole();
        System.out.println("****Usuario SEIRC****"); 
        System.out.println("---Crear clientes---");    
        System.out.println("\n\n¿Cuántos clientes desea registrar?"); 
        clients = new Client[Integer.parseInt(sc.nextLine())]; 
        for(int i = 0; i < clients.length; i++){
            System.out.println("\n~~Registro de información del cliente " + (i+1) + "~~"); 
            System.out.print("Nombre: ");
            name = sc.nextLine(); 
            System.out.print("Contraseña: "); 
            password = sc.nextLine(); 
            System.out.print("Teléfono: "); 
            phone = Integer.parseInt(sc.nextLine());
            clients[i] = new Client(name, password, phone); 
        }  
        System.out.println("\n\n«Se crearon los clientes con éxito»");
    }

    //Método para crear proveedores
    public void createProvider(){
        String name = ""; 
        String password = ""; 
        int phone = 0; 
        clearConsole();
        System.out.println("****Usuario SEIRC****"); 
        System.out.println("---Crear proveedores---");    
        System.out.println("\n\n¿Cuántos proveedores desea registrar? "); 
        providers = new Provider[Integer.parseInt(sc.nextLine())]; 
        for(int i = 0; i < providers.length; i++){   
            System.out.println("\n~~Registro de información del proveedor " + (i+1) + "~~"); 
            System.out.print("Nombre: ");
            name = sc.nextLine(); 
            System.out.print("Contraseña: "); 
            password = sc.nextLine(); 
            System.out.print("Teléfono: "); 
            phone = Integer.parseInt(sc.nextLine());
            providers[i] = new Provider(name, password, phone); 
        }
        System.out.println("\n\n«Se crearon los proveedores con éxito»");  
    }

    //Método para crear el video tutorial
    public void createVideoTutorial(){
        int flag; 
        String title; 
        String description;
        String duration; 
        String quality;
        clearConsole();
        System.out.println("****Usuario SEIRC****"); 
        System.out.println("---Crear vídeo tutoriales---");    
        System.out.println("\n\nElija la opción que desea realizar"); 
        System.out.println("1.Crear vídeo tutorial para el cliente");
        System.out.println("2.Crear vídeo tutorial para el proveedor");
        System.out.println("3.Cancelar acción");
        flag = Integer.parseInt(sc.nextLine()); 

        switch (flag){
            case 1: 
                if(videoTutorial1 == null){
                    System.out.println("\n~~Ingrese toda la información necesaria~~"); 
                    System.out.print("Título del vídeo: "); 
                    title = sc.nextLine(); 
                    System.out.print("Descripción del vídeo: "); 
                    description = sc.nextLine();
                    System.out.print("Duración del vídeo: "); 
                    duration = sc.nextLine(); 
                    System.out.print("Calidad del vídeo: "); 
                    quality = sc.nextLine(); 
                    videoTutorial1 = new VideoTutorial(title,duration,description,quality);
                    System.out.println("\n\n«Vídeo tutorial para clientes creado correctamente»"); 
                } else
                    System.out.println("\n\n¡Error: el vídeo tutorial ya está creado, no puede volver a crearlo!"); 
                break;
            case 2:  
                if(videoTutorial2 == null){
                    System.out.println("\n~~Ingrese toda la información necesaria~~"); 
                    System.out.print("Título del vídeo: "); 
                    title = sc.nextLine(); 
                    System.out.print("Descripción del vídeo: "); 
                    description = sc.nextLine();
                    System.out.print("Duración del vídeo: "); 
                    duration = sc.nextLine(); 
                    System.out.print("Calidad del vídeo: "); 
                    quality = sc.nextLine(); 
                    videoTutorial2 = new VideoTutorial(title,duration,description,quality);
                    System.out.println("\n\n«Vídeo tutorial para proveedores creado correctamente»"); 
                } else
                    System.out.println("\n\n¡Error: el vídeo tutorial ya está creado, no puede volver a crearlo!"); 
                break;
            case 3: 
                break;
        }
    }

    //Método para eliminar clientes
    public void deleteClient(){
        String nameClientDelete; 
        clearConsole();
        if(clients != null){
            boolean flagOne = false; //Validar si existe el usuario que desea eliminar
            System.out.println("****Usuario SEIRC****"); 
            System.out.println("---Eliminar clientes---");        
            System.out.print("\n\nNombre del cliente que desea eliminar: "); 
            nameClientDelete = sc.nextLine(); 
            for(int i = 0; i < clients.length; i++){    
                String flagTwo = ""; //Confirmación para eliminar el cliente
                if ((clients[i] != null) && (clients[i].name).equals(nameClientDelete)){
                    flagOne = true;
                    System.out.println("\n~~Información del cliente a eliminar~~"); 
                    System.out.println("Nombre: " + clients[i].name); 
                    System.out.println("Contraseña: " + clients[i].password); 
                    System.out.println("Teléfono: " + clients[i].phone); 
                    System.out.println("\n¿Seguro que desea eliminar el cliente? (S/N)"); 
                    flagTwo = sc.nextLine();
                    if(flagTwo.equalsIgnoreCase("S")){
                        clients[i] = null; 
                        System.out.println("\n\n«Cliente eliminado con éxito»");
                        return;
                    }
                }
            }
            if(!flagOne) System.out.println("\n\n¡Error: El cliente no está registrado, revise de nuevo sus datos!");
        } else {
            System.out.println("\n\n¡Error: no puede realizar está acción, no hay clientes registrados!");
        }
    }

    //Método para eliminar proveedores
    public void deleteProvider(){
        String nameProviderDelete; 
        clearConsole();
        if(providers != null){
            boolean flagOne = false; //Validar si existe el usuario que desea eliminar
            System.out.println("****Usuario SEIRC****"); 
            System.out.println("---Eliminar proveedores---");        
            System.out.print("\n\nNombre del proveedor que desea eliminar: "); 
            nameProviderDelete = sc.nextLine(); 
            for(int i = 0; i < providers.length; i++){    
                String flagTwo = ""; //Confirmación para eliminar el proveedor
                if ((providers[i] != null) && (providers[i].name).equals(nameProviderDelete)){
                    flagOne = true;
                    System.out.println("\n~~Información del proveedor a eliminar~~"); 
                    System.out.println("Nombre: " + providers[i].name); 
                    System.out.println("Contraseña: " + providers[i].password); 
                    System.out.println("Teléfono: " + providers[i].phone); 
                    System.out.println("\n¿Seguro que desea eliminar el proveedor? (S/N)"); 
                    flagTwo = sc.nextLine();
                    if(flagTwo.equalsIgnoreCase("S")){
                        providers[i] = null; 
                        System.out.println("\n\n«Proveedor eliminado con éxito»");
                        return;
                    }
                }
            }
            if(!flagOne) System.out.println("\n\n¡Error: el proveedor no está registrado, revise de nuevo sus datos!");
        } else {
            System.out.println("\n\n¡Error: no puede realizar está acción, no hay proveedores registrados!");
        }
    }

    //Método para eliminar video tutorial
    public void deleteVideoTutorial(){
        int flag; 
        clearConsole();
        System.out.println("****Usuario SEIRC****"); 
        System.out.println("---Eliminar Video tutoriales---");        
        System.out.println("\n\n~~Elija la opción que desea realizar~~"); 
        System.out.println("1.Eliminar vídeo tutorial del cliente");
        System.out.println("2.Eliminar vídeo tutorial del proveedor");
        System.out.println("3.Cancelar acción");
        flag = Integer.parseInt(sc.nextLine());

        switch (flag){
            case 1: 
                if(videoTutorial1 != null){
                    videoTutorial1 = null; 
                    System.out.println("\n\n«Vídeo tutorial eliminado con éxito»"); 
                    return;
                } else
                    System.out.println("\n\n¡Error: el vídeo tutorial no existe, entonces no puede ser eliminado!"); 
                break;
            case 2:  
            if(videoTutorial2 != null){
                videoTutorial2 = null; 
                System.out.println("\n\n«Vídeo tutorial eliminado con éxito»"); 
                return;
            } else
                System.out.println("\n\n¡Error: el vídeo tutorial no existe, entonces no puede ser eliminado!"); 
            break;
            case 3: 
                break;
        }
    }
    
}