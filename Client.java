public class Client extends User {

    //Definir cuantas ordenes son 
    public Order [] order = null; 
    public int totalLoans = 0; 
    public int totalReturns = 0; 
    public int totalDebt = 0; 
    public static final int NUMBER_ALLOWED_ORDERS = 30; 

    public Client(String name, String password, int phone){
        super(name, password, phone); 
        order = new Order[NUMBER_ALLOWED_ORDERS]; 
    }

    public void loanBasket(){
        
        /**
         * totalLoans += 1; 
           totalDebt += ; 
         */
        
    }

    public void returnBasket(){
        /**
         *   totalReturns += quantityBasket; 
             totalDebt -= quantityBasket;
         */
       
    
    }
    
}