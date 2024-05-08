public class Library {
    // Data Attributes:
    protected int  year;
    protected String name, author, id;
    

    public Library(String name, String author, int year){
        this.id = "#"+ year+"@"+author.charAt(0)+name.charAt(0);
        this.name = name;
        this.author = author;
        this.year = year;

    } // paramterized constructor
    public Library(){
        this("","", 0);

    } // default constructor

    /**
     * 
     * @param otherLibrary  Object which will a copy of be created
     * @param newID  New id that the user must enter
     */
    public Library(Library otherLibrary){
        this(otherLibrary.name, otherLibrary.author, otherLibrary.year);

    } // copy constructor 

    //Accessors :

    public String getID(){

        return this.id;
    }

    public int getYear(){

        return this.year;
    }

    public String getName(){

        return this.name;
    }

    public String getAuthor(){

        return this.author;
    }

    //Mutators:

    public void setID(String newID){
        this.id = newID;

    }
    public void setYear(int newYear){

        this.year = newYear;
    }
    public void setName(String newName){
        this.name = newName;

    }

    public void setAuthor(String newAuthor){
        this.author = newAuthor;

    }


    @Override 
    public String toString(){

        return "ID: "+ this.id+ ", Name: "+this.name+ ", Author: "+ this.author+ " and Year: "+this.year;

    } // overide toString method from class object


    @Override

    public boolean equals(Object otherObject){
        if(otherObject == null)
            return false;
        if( this.getClass() != otherObject.getClass())
            return false;
        
        //Casting:
        Library otherLibrary = (Library) otherObject;

        return this.year == otherLibrary.year && 
        this.author.equals(otherLibrary.author)&& this.name.equals(otherLibrary.name);
    }
}



/* IMPORTANT NOTES:
 *  you must have at least three constructors
 * a default constructor, a parameterized constructor and a copy constructor.
 * the ID is set automatically for paramaterized constructor
 * 
 * 
 */