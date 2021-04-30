public class User {
    public Order [] ordersUser = new Order[30]; //Define cuantas ordenes son permitidas.
    public String name; 
    public String password; 
    public int phone; 

    //Crear usuario
    public User(String name, String password, int phone){
        this.name = name; 
        this.password = password;
        this.phone = phone; 
    }

    //Mostrar los valores de los atributos del usuario
    public String toString(){
        return "Nombre de usuario: " + name + "\nContraseña: *****\nTeléfono: " + phone;
    }

    //Ver todas las ordenes que a realizado el cliente o el proveedor
    public void seeMovements(){
        boolean flag = false; //Validar si existen oredenes
        for(int i = 0; i < ordersUser.length; i++){
            if(ordersUser[i] != null){
                flag = true;
                System.out.println("Orden "+ (i+1));
                System.out.println(ordersUser[i].toString() + "\n");     

            }
        }
        if(!flag) System.out.println("No hay nada registrado hasta el momento."); 
    }
}