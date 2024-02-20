import java.util.ArrayList;

public class Randomize
{
    
    public static ArrayList<Horse> mix(ArrayList<Horse> og)
    {
        ArrayList<Horse> r = new ArrayList<Horse>();
        ArrayList<Horse> h = new ArrayList<Horse>();
        for(Horse a: og )
        {
            h.add(a);
        }
        int length = h.size();
        for(int i = 0; i < length; i++)
        {
            int ranNum = (int) (Math.random() * (length - i));
            r.add(h.remove(ranNum));
        }
        
        return r;
    }




}
