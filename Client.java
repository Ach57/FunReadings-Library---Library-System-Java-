public class Client extends Library {
    // Attributes:
    private String email;
    private long phoneNumber;


    public Client(String id, String name, long phoneNumber, String email){
        super.id = id;
        super.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;

    } // paramaterized constructor


    public Client(){
        
        super.id = "";
        super.name = "";
        this.phoneNumber =0l;

    }// default constructor


    public Client( Client otherClient){

        this(otherClient.id, otherClient.name, otherClient.phoneNumber, otherClient.email);

    }// copy constructor



    @Override
    public String toString(){

        return "Client information: ID:"+this.id + ", Name: "+this.name+ ", Phone number:" + this.phoneNumber +
        " And E-mail: "+ this.email ;
    }

    @Override 
    public boolean equals(Object otherObject){
        if (otherObject == null) 
            return false;
        if(this.getClass() != otherObject.getClass())   
            return false;

        Client otherClient = (Client) otherObject;

        return this.name.equals(otherClient.name) && this.phoneNumber == otherClient.phoneNumber;
        
    }

}
