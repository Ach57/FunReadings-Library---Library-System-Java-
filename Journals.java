public class Journals extends Library{
    //attributes:
    private int volumeNumber;


    public Journals( String name, String author, int year, int volumeNumber){

        super( name, author, year);
        super.id ="J"+ super.id;
        this.volumeNumber = volumeNumber;
    } // paramaterized constructor

    public Journals(){

        super( "", "", 0);
        this.volumeNumber = 0;

    } // default constructor



    public Journals(Journals otherJournals){
        this( otherJournals.name, otherJournals.author, otherJournals.year, otherJournals.volumeNumber);


    } // copy constructor

    //accesor

    public int getVolumeNumber(){

        return this.volumeNumber;
    }

    //Mutator

    public void setVolumeNumber(int newVolume){

        this.volumeNumber =newVolume;

    }

    @Override

    public String toString(){

        return "Journal information: "+ super.toString() +" with Volume number: "+this.volumeNumber;
    }


    @Override
    public boolean equals(Object otherObject){
        if(otherObject == null) 
            return false;
        if( this.getClass() != otherObject.getClass())
            return false;
        // casting and using the super.equal method of the Library class
        Library otheLibrary = (Library) otherObject;
        if(super.equals(otheLibrary)){ // if name, author and year are equal
            Journals otherBooks = (Journals) otheLibrary; // casting 
            
            return this.volumeNumber == otherBooks.volumeNumber; // return true if the volume number true
        }
        else
            return false; // false if name, author or year are not equal
            
    
    }
}
