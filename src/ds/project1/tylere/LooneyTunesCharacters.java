package ds.project1.tylere;

/**This program takes LooneyTunes Characters and other info and prints out 
 * the info
 *
 * @author Tyler Elvis 
 */
public class LooneyTunesCharacters implements Comparable<LooneyTunesCharacters>
{

    private String character;
    private int numOfAppearance;

    /**Constructor for LooneyTunesCharacters Super class 
     * 
     * @param initialcharacter input for the string character 
     * @param initialNumOfApperance input for the int number of appearances 
     */
    public LooneyTunesCharacters(String initialcharacter, int initialNumOfApperance) 
    {
        character = initialcharacter;
        numOfAppearance = initialNumOfApperance;
    }

    /**
     * The getName() method gets the name of the character 
     * 
     * @return the name 
     */
    public String getName() 
    {
        return character;
    }

    /**
     * The getAmountAppearance() method gets the number of appearances of the 
     * character
     * 
     * @return the number of Appearances
     */
    public int getAmountAppearance() 
    {
        return numOfAppearance;
    }

    /**
     * the SetName() method sets the name of the character to the private 
     * attribute
     * 
     * @param initialcharacter String name of character
     */
    public void setName(String initialcharacter) 
    {
        character = initialcharacter;

    }

    /**
     * The setAmountAppearance() method sets the number of Appearances of the 
     * character to an private attribute
     *
     * @param initialNumOfApperance int of the number of Appearances
     */
    public void setAmountAppearance(int initialNumOfApperance)
    {
        numOfAppearance = initialNumOfApperance;

    }

    
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof LooneyTunesCharacters))
        {
            throw new ClassCastException("A LooneyTunesCharacters object expected.");
        }
        LooneyTunesCharacters otherChar = (LooneyTunesCharacters) obj;
        
        if (character.equalsIgnoreCase(otherChar.getName())
            && numOfAppearance == otherChar.getAmountAppearance())
        {
            return true;
        }
        else return false;   
    }
    
    
    
    @Override
    public int compareTo(LooneyTunesCharacters anotherCharacter)
    {
        if (!(anotherCharacter instanceof LooneyTunesCharacters))
        {
            throw new ClassCastException("a LooneyTunesCharacters object expected.");
        }
        
        if (getAmountAppearance() < anotherCharacter.getAmountAppearance())
        {
            return -1;
        }
        else if (getAmountAppearance() > anotherCharacter.getAmountAppearance())
        {
            return 1;
        }
        else
        {
          return character.compareToIgnoreCase(anotherCharacter.getName());
        }
    }
    
    
}
