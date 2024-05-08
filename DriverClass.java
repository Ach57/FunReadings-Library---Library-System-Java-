
import java.util.Scanner;


public class DriverClass {
    
    /*
     * Method: display Menu
     * Functionality: display a menu 
     */
    public static void displayMenu(){
        System.out.println(" ------------------------------------------------- ");
        System.out.println("|           What would you like to do ?           |");
        System.out.println("| 1. Add, delete or adjust an item ->             |"); // Combined Add, delete and change information in one section
        System.out.println("| 2. List all items in a specific catagory ->     |");
        System.out.println("| 3. Adjust the data of a client ->               |"); //(Add,edit, delete)
        System.out.println("| 4. Lease and return ->                          |"); //item to a client and return an item from a client. 
        System.out.println("| 5. Display all items leased by a client ->      |");
        System.out.println("| 6. Display all leased items ->                  |"); // by all clients
        System.out.println("| 7. Display the biggest book ->                  |");
        System.out.println("| 8. Make a copy of the books array ->            |");
        System.out.println("| 9. Quit operation ->                            |");
        System.out.println(" ------------------------------------------------- ");

    }

    /*Method name:displayAddDeleteAdjustLibraryMenu
     * Functionality: Displays add, delete or change information of an item
     */
    public static void displayAddDeleteAdjustLibraryMenu(){
        System.out.println(" ---------------------------------------- ");
        System.out.println("| Select one of the options below:       |");
        System.out.println("| 1. Add an item -->                     |");
        System.out.println("| 2. Delete an item -->                  |");
        System.out.println("| 3. Change information of an item -->   |");
        System.out.println("| 4. Quit -->                            |");
        System.out.println(" ---------------------------------------- ");
    }   
    
    /**
     * 
     * @param option this paramater will take either 1, 2 or 3 
     *  1: Books
     *  2: Journals
     *  3: Media
     */
    public static void displayInformationChangeMenu(int option){
        System.out.println(" ------------------------------------ ");
        System.out.println("| Which item do you want to change:  |");
        System.out.println("| 1. Name                            |");
        System.out.println("| 2. Author                          |");
        System.out.println("| 3. Year                            |");
        if( option ==1)
            System.out.println("| 4. Number of pages                 |");
        else if(option ==2)
            System.out.println("| 4. Volume Number                   |");
        else
            System.out.println("| 4. Media                           |");
        
        System.out.println("| 5. Quit                            |");
        System.out.println(" ------------------------------------ ");

        
    }

    /**
     * 
     * @param array of refernece Library
     * @return true or false value
     * if there is a spot in the array, the method returns true
     * if there is no spot in the array, the method returns false
     * if the array length = 0, the method returns false
     */
    public static boolean veirfyWantedItemtoAdd(Library[] array){
        
        if( array.length ==0)
            return false; // array is empty and can't add items to it

        int i = 0;

        while( i< array.length && array[i]!=null)
        {
            i++;
        }
        if( i == array.length )
            return false; // there is no space to add
        else 
         return true; // there is space
         // {book1, book2, book3, null, null, null}
        

    }

    /**
     * 
     * @param scanner 
     * @return integer that is postive 
     */
    public static int validateOption(Scanner scanner){
        int option;
        do{

            option =scanner.nextInt(); // Accept the max max number of books
            if( option<0){
                System.out.println("Incorrect value. Must be postive");
                System.out.print("Try again:");

            }
                

        }while(option <0);

        return option;
    }

    /**
     * 
     * @param scanner 
     * @param maxValue
     * @return an integer within the range of (1, maxValue)
     */
    public static int validateOptionWithinRange(Scanner scanner, int maxValue, int startingIndex){
        int option;

        do{

            option = scanner.nextInt();
            if( option<1 || option>maxValue){
                System.out.println("Incorrect input!");
                System.out.print("Number has to be (1-"+(maxValue-startingIndex)+"): ");
            }
                
            
        }while( option<1 || option>maxValue);

        return option;
    }

    public static int validateOptionWithinRange(Scanner scanner, int maxValue){
        int option;
        do{

            option = scanner.nextInt();
            if( option<0 || option>maxValue){
                System.out.println("Incorrect input!");
                System.out.print("Number has to be (0-"+maxValue+"): ");
            }
                
            
        }while( option<0 || option>maxValue);

        return option;

        
    }

    /**
     * 
     * @param scanner
     * @param startingIndex
     * @param option
     * @param givenArray
     * @param joker
     * @return
     */

    public static Library[] createLibrary(Scanner scanner, int startingIndex, int option, Library [] givenArray, int joker){
        
        for( int i =startingIndex; i<option + startingIndex; i++){
            scanner.nextLine();

            System.out.print("Book name: ");
            String name = scanner.nextLine();
            System.out.print("Book Author: ");
            String author = scanner.nextLine();
            System.out.print("Year of publication: ");
            int year = scanner.nextInt();


            if(joker ==1){
                System.out.print("Number of pages: ");
                int numOfPages = scanner.nextInt();

                givenArray[i] = new Books(name, author, year, numOfPages); // Creating book object
                System.out.println("Book added!");
            } else if(joker ==2){
                System.out.print("Volume number: ");
                int numOfPages = scanner.nextInt();

                givenArray[i] = new Journals(name, author, year, numOfPages); // Creating Journals object
                System.out.println("Journal added!");
            }
            else{
                System.out.print("type of Media: ");
                scanner.nextLine();
                String type = scanner.nextLine();
                givenArray[i] = new Media(name, author, year, type); // Creating Media object
                System.out.println("Media added!");

            }
            

        }


        return givenArray;
    }

    /**
     * 
     * @param givenArray
     * @return startingIndex
     * This method checks the given array of type Library and returns the index in which the next object is null 
     * in the array
     * 
     */
    public  static int getStartingIndex(Library[] givenArray){
        int startingIndex =0;

        while(startingIndex< givenArray.length && givenArray[startingIndex] !=null){
            startingIndex++;
        } // Example {book1, book2, book3, book4, null, null, null, null }
        // startingIndex =4

        return startingIndex;
    }


    /**
     * 
     * @param givenArraLibrary
     * @return true or false
     * This method verifies if the array is completely empty and returns false meaning you can't proceed
     * Checks if all objects are null and returns false
     * if these criteria are not alerted, it returns true to proceed
     */
    public static boolean checkArray(Library[] givenArraLibrary){
        if(givenArraLibrary.length ==0)
            return false; // The array is empty

        int i = 0;

        while(i < givenArraLibrary.length && givenArraLibrary[i]==null){
            i++;
        }
        if(i == givenArraLibrary.length)
            return false; // All the array has null entries

        return true;
    }


    /**
     * 
     * @param givenArray
     */
    public static void listAllItems(Library[] givenArray){
        for (Library library : givenArray) {
            System.out.println(library);
        }

        
    }
    public static Library[] deleteElementArray(Library[] givenArray, int option){
        // books = {book1, book2, book3 , book4, null, null}
        //option =1 => book2 deleted
        givenArray[option] = null;
        int i = option+1;
        while( i < givenArray.length && givenArray[i]!=null ){
            givenArray[i-1] = givenArray[i];
            i++;

        }
        givenArray[i-1] =null;


        return givenArray;
    }

    /**
     * 
     * @param scanner 
     * @return number that is either 1,2 or 3
     */
    public static int bookJournalMediaOption(Scanner scanner){
        int option;
        do{
            option=scanner.nextInt();
            if(option !=1 && option !=2 && option !=3) 
                System.out.println("Incorrect choice");

        } while( option !=1 && option !=2 && option !=3);
        return option;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Intializing the scanner
        int option; // servces as option selector variable
        int joker; // information holder which will be used to store an information that is used

        // We'll use these three arrays to store, edit or delete information 
        Books[] bookInventory; // Book inventory array
        Journals[] journalsInventory; // journals inventory array
        Media[] mediaInventory; // Media inventory array

        
        System.out.println(" ----------- WELCOME TO THE BOOK STORE ---------- ");  


        System.out.print("Please enter the max number of Books your inventory can hold: ");
        option = validateOption(scanner); // calling method to validate 
        bookInventory = new Books[option]; // intializing the max number of places in the books inventory array 
        

        System.out.print("Please enter the max number of Journals your inventory can hold: ");
        option = validateOption(scanner); //Calling method to validate the option
        journalsInventory = new Journals[option]; // Intializing the max number of places in the Journals inventory array

        System.out.print("Please enter the max number of Media your inventory can hold: ");
        option = validateOption(scanner); // Calling the methode to validate the option
        mediaInventory= new Media[option]; // Intializing the max number of places in the Media array
        

        

        do{
            
            displayMenu();
            System.out.print("Enter: ");
            option =scanner.nextInt();

            //if(option<1 || option>9)
            //    System.out.println("Incorrect option!");
            
                switch ( option ){

                    case 1: 
                        /* Case 1: Add, delete or change an item: 
                        *  The item can be a Book, Journal or Media.
                        * We'll display another menu for which the user can chose to select either of these choices mentioned
                        * Lastly store them in their inventory array.
                        */
                        displayAddDeleteAdjustLibraryMenu(); // Calling method to display menu
                        do{
                            
                            System.out.print("Enter: ");
                            option = scanner.nextInt();
                            
                            switch(option){
                                case 1:
                                    /* Option 1: Add an item 
                                    * Item: { book, journals, Media }
                                    * We'll verify the length of each books, journals and media array, as well as check the available spots
                                    * prompt the user first which type of item he wants to add
                                    * then call a method that verifies
                                    * We're going to use the same variable option to do all the operation
                                    */
                                    System.out.print("Please enter 1 for Book, 2 for Journal and 3 for Media: ");
                                    do{
                                        option = scanner.nextInt();
                                        
                                        switch(option){
                                            case 1: // Case of Book
                                                if(!veirfyWantedItemtoAdd(bookInventory))
                                                    System.out.println("There is no space to add");
                                                else{

                                                    System.out.print("Please input the number of books: ");
                                                    // Finding the index of the array that has null value

                                                    int startingIndex=getStartingIndex(bookInventory); // Calling method to get the starting index
                                                    
                                                    joker = option;
                                                    option = validateOptionWithinRange(scanner, bookInventory.length, startingIndex);
                                                    Library[] tempArray = createLibrary(scanner, startingIndex, option, bookInventory, joker);
                                                    bookInventory = (Books[]) tempArray; // Casting the returned array of reference Library to Books class

                                                }  
                                            break;

                                            case 2: // Case of Journal
                                            if(!veirfyWantedItemtoAdd(journalsInventory))
                                                    System.out.println("There is no space to add");
                                                else{

                                                    System.out.print("Please input the number of Journals: ");
                                                    // Finding the index of the array that has null value 
                                                    int startingIndex=getStartingIndex(journalsInventory);
                                                
                                                    joker = option;
                                                    
                                                    option = validateOptionWithinRange(scanner, journalsInventory.length, startingIndex);
                                                    Library[] tempArray = createLibrary(scanner, startingIndex, option, journalsInventory, joker);
                                                    journalsInventory = (Journals[]) tempArray; // Casting the returned array of reference Library to Journals class

                                                }  
                                            break;

                                            case 3: // Case of Media
                                            if(!veirfyWantedItemtoAdd(mediaInventory))
                                                System.out.println("There is no space to add");
                                            else{

                                                System.out.print("Please input the number of Media: ");
                                                // Finding the index of the array that has null value 
                                                int startingIndex=getStartingIndex(mediaInventory);
                                                
                                                joker = option;
                                                
                                                option = validateOptionWithinRange(scanner, journalsInventory.length, startingIndex);

                                                Library[] tempArray = createLibrary(scanner, startingIndex, option, mediaInventory, joker);
                                                mediaInventory = (Media[]) tempArray; // Casting the returned array of reference Library to Journals class

                                            }
                                            break;

                                            default: // In case the option is incorrect
                                                System.out.println("Your option is incorrect");
                                                System.out.print("Attempt again: ");
                                        }
                                        
                                    } while(option !=1 && option !=2 && option !=3);
                                    


                                break;

                                case 2:
                                    // Delete an item
                                    //Implementation of deleting an item is as following
                                    //{book1, book2, book3, null, null}
                                    // delete book2
                                    // { book1, book3, null null null}
                                    System.out.print("Please enter 1 for Book, 2 for Journal and 3 for Media: ");
                                    do{

                                        option = scanner.nextInt();

                                        switch (option){
                                            // Case 1 to delete a book 
                                            // need to fix the issue with the numbers
                                            case 1:
                                                if(!checkArray(bookInventory)) // Calling the method to check the array
                                                    System.out.println("The inventory is either empty or there isn't any item to delete");
                                                else{

                                                    int startingIndex = getStartingIndex(bookInventory);

                                                    System.out.println("You can only select a number within this range to delete");
                                                    System.out.print("Enter (0-"+(startingIndex-1)+"): ");
                                                    joker = option;
                                                    option = validateOptionWithinRange(scanner, (startingIndex-1));
                                                    // books = {book1, book2, book3, null, null};
                                                    Library[] temp = deleteElementArray(bookInventory, option);
                                                    bookInventory = (Books[]) temp;                                                    
                                                }
                                            break;

                                            // Case 2 to delete a journal
                                            case 2:
                                            if(!checkArray(journalsInventory)) // Calling the method to check the array
                                                    System.out.println("The inventory is either empty or there isn't any item to delete");
                                                else{

                                                    int startingIndex = getStartingIndex(journalsInventory);

                                                    System.out.println("You can only select a number within this range to delete");
                                                    System.out.print("Enter (0-"+(startingIndex-1)+"): ");
                                                    joker = option;
                                                    option = validateOptionWithinRange(scanner, (startingIndex-1));
                                                    // books = {book1, book2, book3, null, null};
                                                    Library[] temp = deleteElementArray(journalsInventory, option);
                                                    journalsInventory = (Journals[]) temp;                                                    
                                                }
                                            break;
                                                
                                            // case 3 to delete a media
                                            case 3: 
                                            if(!checkArray(mediaInventory)) // Calling the method to check the array
                                                System.out.println("The inventory is either empty or there isn't any item to delete");
                                            else{

                                                int startingIndex = getStartingIndex(mediaInventory);

                                                System.out.println("You can only select a number within this range to delete");
                                                System.out.print("Enter (0-"+(startingIndex-1)+"): ");
                                                joker = option;
                                                option = validateOptionWithinRange(scanner, (startingIndex-1));
                                                // books = {book1, book2, book3, null, null};
                                                Library[] temp = deleteElementArray(mediaInventory, option);
                                                mediaInventory = (Media[]) temp;                                                    
                                            }
                                            break;

                                            case 4:
                                                
                                            default:   
                                                // In case the option is incorrect
                                                System.out.println("Your option is incorrect");
                                                System.out.print("Attempt again: ");


                                        }
                                        

                                    }while( option!= 1 && option!=2 && option !=3);
                                    

                                break;


                                case 3:
                                // change information of an item
                                    System.out.print("Please enter 1 for Book, 2 for Journal and 3 for Media: ");
                                    option =bookJournalMediaOption(scanner); // calling method to verify the number
                                    displayInformationChangeMenu(option);

                                    //Need to implement an if statement

                                break;


                                case 4:
                                    //*Return back to main menu when user quits the operation 
                                    System.out.println("--> Back to Main menu");
                                break;

                                default:
                                    System.out.println("Incorrect option selected. Please try again (1-4)");

                            }


                        }while(option <1 ||option>4);


                    break;


                    case 2:

                    /*List all items in a specfic catagory
                                 * 
                                 */

                        System.out.println("Please enter 1 for Book, 2 for Journal and 3 for Media: ");
                        option = bookJournalMediaOption(scanner);

                        switch(option){

                            case 1: // case of book:
                                if(!checkArray(bookInventory))
                                    System.out.println("The inventory is either empty or it has not books in it yet!");
                                else
                                    listAllItems(bookInventory);

                                
                            break;

                            case 2:
                                if(!checkArray(journalsInventory))
                                    System.out.println("The inventory is either empty or it has not books in it yet!");
                                else
                                    listAllItems(journalsInventory);
                                
                            break;

                            case 3:
                                if(!checkArray(mediaInventory))
                                    System.out.println("The inventory is either empty or it has not books in it yet!");
                                else   
                                    listAllItems(mediaInventory);
                            break;
                        }

                    break;

                    case 3:
                    break;

                    case 4:
                    break;
                    

                    case 7:
                        
                    
                    break;
                    case 9:
                        System.out.println("Thank you for using FunReadings services!");
                        System.exit(0);
                    break;
                    
                    default:
                        System.out.println("Incorrect option!");

                }

            

          option =-1;  

        }while(option<1 || option>9);

        
        

        scanner.close();
    }
}
