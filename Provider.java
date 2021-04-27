public class Provider extends User {
    public int totalLoans = 0; 
    public Order [] ordersProviders = new Order[30]; 


    public Provider(String name, String password, int phone){
        super(name, password, phone); 
    }


    public void loanBasket(){
        //public Order [] order = new Order []; 
        /**
         * totalLoans += 1; 
         */
    }


}