import java.util.HashMap;
public class Operation
{
    public static void main(String args[])
    {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("Sarmila",50);
        hm.put("Sushila",30);
        hm.put("Siya",40);
        hm.put("Siya",100);
        hm.put("bokalokesh",300);
        System.out.println(hm);
        // get function give null value if key does't exist;
        System.out.println(hm.get("Sarmila"));
        // System.out.println(hm.remove("Siya"));
        System.out.println(hm.containsKey("Siya"));
        // check is empty
        System.out.println(hm.get("bokalokesh"));
        hm.clear();
        System.out.println(hm.isEmpty());
      
    }

}