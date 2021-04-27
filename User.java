public class User {
    public String name; 
    public String password; 
    public int phone; 

    public User(String name, String password, int phone){
        this.name = name; 
        this.password = password;
        this.phone = phone; 
    }

    public String toString(){
        return "Nombre de usuario: " + name + "\nContraseña: *****\nTeléfono: " + phone;
    }
}