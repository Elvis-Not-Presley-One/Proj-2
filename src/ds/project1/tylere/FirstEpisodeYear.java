package ds.project1.tylere;

/**This program takes LooneyTunes Characters and other info and prints out 
 * the info
 *
 * @author Tyler Elvis 
 */
public class FirstEpisodeYear extends LooneyTunesCharacters 
{

    private int year;

    /**  
     * FirstEpisodeYear constructor for the FirstEpisodeYear subclass
     * 
     * @param initialcharacter input for the string character 
     * @param initialNumOfApperance input for the int number of appearances 
     * @param initialYear input for the int number of year 
     */
    public FirstEpisodeYear(String initialcharacter, int initialNumOfApperance,
            int initialYear) 
    {
        super(initialcharacter, initialNumOfApperance);
        year = initialYear;
    }

    /** 
     * the getYear() method gets the year the character was made
     * 
     * @return the year
     */
    public int getYear() 
    {
        return year;
    }

    /**
     * the setYear() method sets the year to a private attribute 
     * 
     * @param initialYear input for the int number of year  
     */
    public void setYear(int initialYear) 
    {
        year = initialYear;

    }
}
