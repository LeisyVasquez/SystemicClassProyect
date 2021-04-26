import java.util.Scanner;

public class SGBD {
    Scanner sc = new Scanner(System.in);
    public Client clients [] = null;  
    public Provider providers [] = null; 
    public VideoTutorial videoTutorial1 = null; 
    public VideoTutorial videoTutorial2 = null; 

    public void createClient(){
        System.out.println("¿Cuántos clientes desea registrar? "); 
        clients = new Client[Integer.parseInt(sc.nextLine())]; 
        for(int i = 0; i < clients.length; i++){
            System.out.println("Registro de informaciónCliente " + (i+1)); 
            //clients[i] = 
        }
    }

    public void createProvider(){
        System.out.println("¿Cuántos proveedores desea registrar? "); 
        providers = new Provider[Integer.parseInt(sc.nextLine())]; 
    }

    public void createVideoTutorial(){
        int flag; 
        String title; 
        String description;
        String duration; 
        String quality;
        System.out.println("---Elija la opción que desea realizar---"); 
        System.out.println("1.Crear vídeo tutorial para el cliente");
        System.out.println("2.Crear vídeo tutorial para el proveedor");
        System.out.println("3.Cancelar acción");
        flag = Integer.parseInt(sc.nextLine()); 

        switch (flag){
            case 1: 
                if(videoTutorial1 == null){
                    System.out.println("Ingrese toda la información necesaria"); 
                    System.out.print("Título del vídeo: "); 
                    title = sc.nextLine(); 
                    System.out.print("Descripción del vídeo: "); 
                    description = sc.nextLine();
                    System.out.print("Duración del vídeo: "); 
                    duration = sc.nextLine(); 
                    System.out.print("Calidad del vídeo: "); 
                    quality = sc.nextLine(); 
                    videoTutorial1 = new VideoTutorial(title,duration,description,quality);
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

    public void deleteClient(){

    }

    public void deleteProvider(){

    }

    public void deleteVideoTutorial(){
        int flag; 
        System.out.println("---Elija la opción que desea realizar---"); 
        System.out.println("1.Eliminar vídeo tutorial del cliente");
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