package service.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongParseTest {
    public static void main(String args[]) {
        List<String> enttypeStringIds = new ArrayList<>(Arrays.asList("1","2","3","4","10","8"));
        enttypeStringIds.remove("97");
        System.out.println(enttypeStringIds);
        List<Long> entLongList = getLongList(enttypeStringIds);
        System.out.println(entLongList);

        String dounle = "250.2358348";
        Double doubleAc = Double.parseDouble(dounle);
        System.out.println(doubleAc);
    }

    private static List<Long> getLongList(List<String> enttypeStringIds) {
        List<Long> entLongs = null;
        if(null != enttypeStringIds){
            entLongs = new ArrayList<>();
            for(String entId : enttypeStringIds){
                if(null != entId){
                    entLongs.add(Long.parseLong(entId));
                }
            }
        }
        return entLongs;
    }
}
