package service.collectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ListUpdateMethodTest {
    public static void main(String args[]) throws Exception {
        List<String> gotList = getList();
        List<String> updatedv1List= updateList1(gotList);
        List<String> updatedv2List= updateList2(updatedv1List);
        System.out.println(updatedv1List);

    }

    private static List<String> updateList2(List<String> updatedv1List) {
        updatedv1List.add("C");
        return updatedv1List;
    }

    private static List<String> updateList1(List<String> gotList) {
        gotList.add("B");
        return gotList;
    }

    private static List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("A");
        return list;
    }

}
