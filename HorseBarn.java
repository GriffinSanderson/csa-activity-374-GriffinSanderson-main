import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 *  A class to manage the location of horses in a barn.
 */
public class HorseBarn
{
  // The stalls or spaces in the barn. Each array element holds a reference to the horse
  // that is currently occupying the space.  A null value indicates an empty space.
  private ArrayList<Horse> spaces = new ArrayList<Horse>();

  /**
   * Constructor for the HorseBarn class. Loads data from the horsedata.txt file
   * and populates the ArrayList spaces. If a blank line occurs in the data file,
   * the array element is assigned a value of null to indicate the absense of a horse.
   */
  public HorseBarn()
  {
    // a try is like an if statement, "throwing" an error if the body of the try fails
    try
    {
      Scanner sc = new Scanner(new File("horsedata.txt"));
      // The Scanner method hasNextLine returns true if there is 
      // another line of input
      while (sc.hasNextLine())
      {
        // String method trim removes whitepsace from the beginning
        // and end of strings
        String temp = sc.nextLine().trim();
        if (temp.equals(""))
        {
          // no horse in this stall, add a null entry
          spaces.add(null);
        }
        else
        {  
          // String method split splits this string based on the
          // specified token and returns an array of individual substrings
          String[] tokens = temp.split(",");  
          String name = tokens[0];
          int  weight = Integer.parseInt(tokens[1]);
          
          // add the horse to the array list
          spaces.add(new Horse(name, weight));
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing horsedata.txt" + e); }
  }

  /**
   * Returns the current list of spaces in the barn. If a space does not
   * have a horse in it, the element will be null.
   * 
   * @return the ArrayList of spaces
   */
  public ArrayList<Horse> getSpaces()
  {
    return spaces;
  }

  public double averageWeight()
  {
    double total = 0;
    for(int i = 0; i < spaces.size(); i++)
    {
      Horse h = spaces.get(i);
      total += h.getWeight();
    }
    
    return total / spaces.size();
  }

  public String overWeight()
  {
    double averageWeight = averageWeight();
    String overWeight = "";
    for(int i = 0; i < spaces.size(); i++)
    {
      if(spaces.get(i) != null)
      {
      if(spaces.get(i).getWeight() > averageWeight)
      {
        overWeight += ((spaces.get(i)).getName() + " ");
      }
      }   
    }
    return ("overWeight: " + overWeight);
  }

  public String minMaxWeight()
  {
    String minMax = "";
    int min = spaces.get(0).getWeight();
    int max = spaces.get(0).getWeight();
    int minIndex = 0;
    int maxIndex = 0;
    for(int i = 1; i < spaces.size(); i++)
    {
      if (spaces.get(i).getWeight() > max)
      {
        max = spaces.get(i).getWeight();
        maxIndex = i;
      }
      if(spaces.get(i).getWeight() < min)
      {
        min = spaces.get(i).getWeight();
        maxIndex = i;
      }
    }
    minMax = ("Max: " + spaces.get(maxIndex).getName() + ", " + spaces.get(maxIndex).getWeight() + ". Min: " + spaces.get(minIndex).getName() + ", " + spaces.get(minIndex).getWeight());
    return minMax;
  }
}
