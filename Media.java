public class Media extends Library {
    // Attributes:
    private String type;

    public Media( String name, String author, int year, String type){
        super( name, author, year);
        this.type = type;
        super.id ="M"+ super.id;
    } // Paramterized constructor

    public Media(){
        super("","",0);
        this.type = "";

    } // default constructor

    public Media(Media otherMedia){
        this(otherMedia.name, otherMedia.author, otherMedia.year, otherMedia.type);

    } // Copy constructor

    //Accesor:

    public String getType(){

        return this.type;
    }

    //Mutators:

    public void setType(String newType){

        this.type = newType;
    }

    @Override

    public String toString(){

        return "Media information: "+ super.toString() +" with Type: "+this.type;
    }

    @Override 
    public boolean equals(Object otherObject){
        if(otherObject ==null)
            return false; // return fals if entered object is null
        if(this.getClass() != otherObject.getClass())
            return false; // return false if the objects of different classes

        Library otherLibrary = (Library) otherObject; // casting Library object to otherObject
        if(super.equals(otherLibrary)) // using the equals method from Library class
        { // if true( name, author and year ) are equal proceed
            Media otherMedia = (Media) otherLibrary;

            return this.type.equals(otherMedia.type); // return true or false based on wether the type is equal or not
        }    
        else 
            return false; //return false if one is not equal
    }


}
