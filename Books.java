public class Books extends Library{
    
    // attributes
    private int numOfPages;

    public Books(){
        super( "", "", 0);
        this.numOfPages=0;
        super.id ="B"+ super.id;


    } // default constructor


    public Books( String name, String author, int year, int numOfPages){
        super( name, author, year);
        this.numOfPages = numOfPages;
        super.id ="B"+ super.id;
    }// Paramterized constructor


    /**
     * @param newID 
     * @param otherBooks
     */
    public Books(Books otherBooks){
        
        this(otherBooks.name, otherBooks.author, otherBooks.year, otherBooks.numOfPages);

    }// copy constructor


    // Accesors:

    public int getNumOfPages(){

        return this.numOfPages;
    }

    //Mutators:

    public void setNumofPages(int newNumber){
        this.numOfPages = newNumber;
        
    }


    @Override

    public String toString(){

        return "Book information: "+ super.toString() +" with Number of pages: "+this.numOfPages;
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
            Books otherBooks = (Books) otheLibrary; // casting 
            
            return this.numOfPages == otherBooks.numOfPages; // return true if the number of books true
        }
        else
            return false; // false if name, author or year are not equal
            


    }

    /**
     * 
     * @param bookArray 
     * @return boook with the highest number of pages
     */
    public Books getBiggestBook(Books[] bookArray){

        int highestNumber = bookArray[0].numOfPages, index=0;
        
        for( int i = 1; i< bookArray.length; i++){
            if( highestNumber< bookArray[i].numOfPages){
                highestNumber =bookArray[i].numOfPages;
                index = i;
            }

        }
        return bookArray[index];
    }



}
