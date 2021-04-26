public class User {
    public String name; 
    public String password; 
    public int phone; 

    public User(String name, String password, int phone){
        this.name = name; 
        this.password = password;
        this.phone = phone; 
    }

    public void toString(){
        System.out.println("Nombre de usuario: " + name);
        System.out.println("Contraseña: *****"); 
        System.out.println("Teléfono: " + phone);
    }
}