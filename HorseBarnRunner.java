import java.util.ArrayList;

/**
 * The runner class for HorseBarn
 */
public class HorseBarnRunner 
{
  
  public static void main(String[] args) {
    
    HorseBarn barn = new HorseBarn();
    ArrayList<Horse> barnSpaces = barn.getSpaces();
    System.out.println(barn.averageWeight());
    System.out.println(barn.minMaxWeight());
    System.out.println(barn.overWeight());
    for(int i = 0; i < barnSpaces.size(); i++)
    {
      if(barnSpaces.get(i).getName().equals("Duke"))
      {
        barnSpaces.set(i, new Horse("Princess", 1445));
      }
      if(barnSpaces.get(i).getName().equals("Silver"))
      {
        barnSpaces.add(i + 1, new Horse("Chief", 1505));
      }
      if((barnSpaces.get(i).getName().equals("Buddy")))
      {
        barnSpaces.add(i + 1, new Horse("Gypsy", 1335));
        barnSpaces.add(i, new Horse("Magic", 1425));
        i++;
      }
    }
    System.out.println(barnSpaces);
    ArrayList<Horse> randomHorses = Randomize.mix(barnSpaces);
    System.out.println(randomHorses);
  
    if((randomHorses.size() % 2) != 0)
      {
        randomHorses.add(new Horse("No Parter", 0));
      }
    
    for(int i = 0; i < randomHorses.size(); i += 2)
    {
      System.out.println(randomHorses.get(i) + ", " + randomHorses.get(i+1));
    }
  
  
  }
} 
//