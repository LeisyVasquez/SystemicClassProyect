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
        System.out.println("****Crear clientes****");    
        System.out.println("\n¿Cuántos clientes desea registrar?"); 
        clients = new Client[Integer.parseInt(sc.nextLine())]; 
        for(int i = 0; i < clients.length; i++){
            System.out.println("--Registro de información del cliente " + (i+1) + "--"); 
            System.out.print("Nombre: ");
            name = sc.nextLine(); 
            System.out.print("Contraseña: "); 
            password = sc.nextLine(); 
            System.out.print("Teléfono: "); 
            phone = Integer.parseInt(sc.nextLine());
            clients[i] = new Client(name, password, phone); 
        }  
    }

    //Método para crear proveedores
    public void createProvider(){
        String name = ""; 
        String password = ""; 
        int phone = 0; 
        clearConsole();
        System.out.println("****Crear proveedores****");    
        System.out.println("\n¿Cuántos proveedores desea registrar? "); 
        providers = new Provider[Integer.parseInt(sc.nextLine())]; 
               for(int i = 0; i < providers.length; i++){   
            System.out.println("--Registro de información del proveedor " + (i+1) + "--"); 
            System.out.print("Nombre: ");
            name = sc.nextLine(); 
            System.out.print("Contraseña: "); 
            password = sc.nextLine(); 
            System.out.print("Teléfono: "); 
            phone = Integer.parseInt(sc.nextLine());
            providers[i] = new Provider(name, password, phone); 
        }  
    }

    //Método para crear el video tutorial
    public void createVideoTutorial(){
        int flag; 
        String title; 
        String description;
        String duration; 
        String quality;
        clearConsole();
        System.out.println("---Elija la opción que desea realizar---"); 
        System.out.println("\n1.Crear vídeo tutorial para el cliente");
        System.out.println("2.Crear vídeo tutorial para el proveedor");
        System.out.println("3.Cancelar acción");
        flag = Integer.parseInt(sc.nextLine()); 

        switch (flag){
            case 1: 
                if(videoTutorial1 == null){
                    System.out.println("\nIngrese toda la información necesaria"); 
                    System.out.print("Título del vídeo: "); 
                    title = sc.nextLine(); 
                    System.out.print("Descripción del vídeo: "); 
                    description = sc.nextLine();
                    System.out.print("Duración del vídeo: "); 
                    duration = sc.nextLine(); 
                    System.out.print("Calidad del vídeo: "); 
                    quality = sc.nextLine(); 
                    videoTutorial1 = new VideoTutorial(title,duration,description,quality);
                    System.out.print("\nVídeo registrado correctamente"); 
                } else
                    System.out.print("El vídeo tutorial ya está creado, no puede volver a crearlo"); 
                break;
            case 2:  
                if(videoTutorial2 == null){
                    System.out.println("Ingrese toda la información necesaria"); 
                    System.out.print("Título del vídeo: "); 
                    title = sc.nextLine(); 
                    System.out.print("Descripción del vídeo: "); 
                    description = sc.nextLine();
                    System.out.print("Duración del vídeo: "); 
                    duration = sc.nextLine(); 
                    System.out.print("Calidad del vídeo: "); 
                    quality = sc.nextLine(); 
                    videoTutorial2 = new VideoTutorial(title,duration,description,quality);
                } else
                    System.out.print("El vídeo tutorial ya está creado, no puede volver a crearlo"); 
                break;
            case 3: 
                System.out.println("Salida exitosa, todo ok"); 
                break;
        }
    }

    //Método para eliminar clientes
    public void deleteClient(){
        String nameClientDelete; 
        if(clients != null){
            clearConsole();
            System.out.println("****Eliminar clientes****");   
            System.out.print("Nombre del cliente que desea eliminar: "); 
            nameClientDelete = sc.nextLine(); 
            for(int i = 0; i < clients.length; i++){
                String flag = "";
                if(clients[i].name == nameClientDelete){
                    System.out.println("\n-Información del cliente a eliminar-"); 
                    System.out.println("Nombre: " + clients[i].name); 
                    System.out.println("Contraseña: " + clients[i].password); 
                    System.out.println("Teléfono: " + clients[i].phone); 
                    System.out.println("\n¿Seguro que desea eliminar el cliente? (S/N)"); 
                    flag = sc.nextLine();
                    if(flag.equalsIgnoreCase("S")){
                        clients[i] = null; 
                        System.out.println("Cliente eliminado con éxito");
                    }
                    break;
                }
                
            }
        } else 
            System.err.println("No puede realizar está acción, no hay clientes registrados.");
    }

    //Método para eliminar proveedores
    public void deleteProvider(){
        String nameProviderDelete; 
        if(providers != null){
            clearConsole();
            System.out.println("****Eliminar proveedor****");   
            System.out.print("Nombre del proveedor que desea eliminar: "); 
            nameProviderDelete = sc.nextLine(); 
            for(int i = 0; i < providers.length; i++){
                if(providers[i].name == nameProviderDelete){
                    String flag = "";
                    System.out.println("\n-Información del proveedor a eliminar-"); 
                    System.out.println("Nombre: " + providers[i].name); 
                    System.out.println("Contraseña: " + providers[i].password); 
                    System.out.println("Teléfono: " + providers[i].phone); 
                    System.out.println("\n¿Seguro que desea eliminar el proveedor? (S/N)"); 
                    flag = sc.nextLine();
                    if(flag.equalsIgnoreCase("S")){
                        providers[i] = null; 
                        System.out.println("Proveedor eliminado con éxito");
                    }
                    break;
                }
            }
        } else 
            System.err.println("\nNo puede realizar está acción, no hay proveedores registrados.\n");
    }

    //Método para eliminar video tutorial
    public void deleteVideoTutorial(){
        int flag; 
        clearConsole();
        System.out.println("---Elija la opción que desea realizar---"); 
        System.out.println("\n1.Eliminar vídeo tutorial del cliente");
        System.out.println("2.Eliminar vídeo tutorial del proveedor");
        System.out.println("3.Cancelar acción");
        flag = Integer.parseInt(sc.nextLine());

        switch (flag){
            case 1: 
                if(videoTutorial1 != null){
                    videoTutorial1 = null; 
                    System.out.println("Vídeo eliminado con éxito"); 
                } else
                    System.out.print("El vídeo tutorial no existe, entonces no puede ser eliminado"); 
                break;
            case 2:  
            if(videoTutorial2 != null){
                videoTutorial2 = null; 
                System.out.println("Vídeo eliminado con éxito"); 
            } else
                System.out.print("El vídeo tutorial no existe, entonces no puede ser eliminado"); 
            break;
            case 3: 
                System.out.println("Salida exitosa, todo ok"); 
                break;
        }
    }

}