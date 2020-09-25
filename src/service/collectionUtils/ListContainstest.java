package service.collectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ListContainstest {
    public static void main(String args[])  {
        ArrayList<String> gfg = new ArrayList<String>() {
            {
                add("Geeks");
                add("for");
                add("Geeks");
            }
        };
        String testGfg = "   Geeks  ";
        System.out.println(gfg.contains(testGfg.trim()));



    }
}
