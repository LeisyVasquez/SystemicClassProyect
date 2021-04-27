public class Client extends User {

    //Definir cuantas ordenes son 
    public Order [] order = new Order[30]; 
    public int totalLoans = 0; 
    public int totalReturns = 0; 
    public int totalDebt = 0; 
    public int index = 0; 
    

    public Client(String name, String password, int phone){
        super(name, password, phone); 
    }


    public void loanBasket(String nameBasket, int quantityBasket){

        order[index] = new Order("Préstamo",,nameBasket,quantityBasket); 
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