package ds.project1.tylere;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program takes LooneyTunes Characters and other info and adds removes and finds 
 * the object in the linked list
 * info
 *
 * @author Tyler Elvis
 */
public class DSProject1TylerE
{

    /**
     * 
     * @param args 
     */
    public static void main(String[] args)
    {

        Scanner keyboard = new Scanner(System.in);
        String input;
        int year = 0;
        int apper = 0;
        String character = "";

        // need to add when you add somthing to check whats greater 
        System.out.println("\nMenu:\n");
        System.out.println("A - add a character to the bag");
        System.out.println("R - Remove a character from the bad");
        System.out.println("F - Find a character in the bag");
        System.out.println("D - Display contents of the bag");
        System.out.println("X - exit");
        System.out.print("Enter Selection: ");
        input = keyboard.nextLine();

        SinglyLinkedList<LooneyTunesCharacters> charBag
                = new SinglyLinkedList<LooneyTunesCharacters>();

        while (!input.equalsIgnoreCase("X")) 
        {

            if (input.equalsIgnoreCase("a")) 
            {
                try
                {
                    System.out.print(" Enter Name of the character You want to be added");
                    character = keyboard.nextLine();
                    System.out.print(" Enter The amount of appearances");
                    apper = keyboard.nextInt();
                    System.out.print(" Enter The year the character was first seen");
                    year = keyboard.nextInt();
                    keyboard.nextLine();
                } 
                catch (InputMismatchException e) 
                {
                    System.out.println("\nInvalid, Input, Try again!\n");
                }

                addToBag(charBag, new FirstEpisodeYear(character, apper, year));

            } 
            else if (input.equalsIgnoreCase("r")) 
            {
                try 
                {
                    System.out.print(" Enter Name of the character You want removed");
                    character = keyboard.nextLine();
                    System.out.print(" Enter The amount of appearances");
                    apper = keyboard.nextInt();
                    System.out.print(" Enter The year the character was first seen");
                    year = keyboard.nextInt();
                    keyboard.nextLine();
                } 
                catch (InputMismatchException e) 
                {
                    System.out.println("\nInvalid, Input, Try again!\n");
                }
                LooneyTunesCharacters charTest = new FirstEpisodeYear(character,
                        apper, year);

                if (charBag.remove(charTest))
                {
                    System.out.println("\n Yes, " + character + " with " + apper
                            + " apperences and was first seen in " + year
                            + " was removed!");
                } 
                else 
                {
                    System.out.println("\n No, " + character + " with " + apper
                            + " apperences and was first seen in " + year
                            + " was not removed");
                }

            } 
            else if (input.equalsIgnoreCase("f")) 
            {
                try 
                {
                    System.out.print(" Enter Name of the character You want to be found");
                    character = keyboard.nextLine();
                    System.out.print(" Enter The amount of appearances");
                    apper = keyboard.nextInt();
                    System.out.print(" Enter The year the character was first seen");
                    year = keyboard.nextInt();
                    keyboard.nextLine();
                } 
                catch (InputMismatchException e) 
                {
                    System.out.println("\nInvalid, Input, Try again!\n");
                }

                LooneyTunesCharacters charTest = new FirstEpisodeYear(character,
                        apper, year);

                if (charBag.exists(charTest)) 
                {
                    System.out.println("\n Yes, " + character + " with " + apper
                            + " apperences and was first seen in " + year + " was found");
                } 
                else 
                {
                    System.out.println("\n No, " + character + " with " + apper
                            + " apperences and was first seen in " + year
                            + " was Not found!");
                }

            } 
            else if (input.equalsIgnoreCase("d"))
            {
                displayLinkedBagAndSize(charBag, "Character Bag");

            } 
            else
            {
                System.out.println("\nInvalid Input\n");
            }

            System.out.println("\nMenu:\n");
            System.out.println("A - add a character to the bag");
            System.out.println("R - Remove a character from the bad");
            System.out.println("F - Find a character in the bag");
            System.out.println("D - Display contents of the bag");
            System.out.println("X - exit");
            System.out.print("Enter Selection: ");
            input = keyboard.nextLine();

        }

    }

    /** 
     * Adds obj to the bad or linked list 
     * 
     * @param bagToAddTo where to add to
     * @param LooneyTunesCharactersToAdd whats are is the data being added 
     */
    public static void addToBag(SinglyLinkedList<LooneyTunesCharacters> bagToAddTo,
            LooneyTunesCharacters LooneyTunesCharactersToAdd) 
    {
        bagToAddTo.appendList(LooneyTunesCharactersToAdd);

    }

    /**
     * Displays the insides of the bag 
     * 
     * @param bagToDisplay what bag we are looking in 
     * @param label the label on what is being looked at 
     */
    public static void displayLinkedBagAndSize(SinglyLinkedList<LooneyTunesCharacters> bagToDisplay, String label) 
    {
        System.out.print(label + ": [");

        if (bagToDisplay.getSize() == 0) 
        {
            System.out.print("--Empty--");
        }
        Lister<LooneyTunesCharacters> charList = bagToDisplay.iterator();
        while (charList.hasNext()) 
        {
            FirstEpisodeYear displayChar = (FirstEpisodeYear) charList.next();
            System.out.print("{" + displayChar.getName() + " " + displayChar.getAmountAppearance() + " " + displayChar.getYear() + "}");
            if (charList.hasNext())
            {
                System.out.print(", ");
            }
        }

        System.out.println("]\tSize: " + bagToDisplay.getSize() + "\n");
    }
}
