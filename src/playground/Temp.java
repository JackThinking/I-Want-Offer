package playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Citrix on 2019-02-20.
 */
public class Temp {
    public static void main(String[] args) {
        Integer[] array = {12, 3, 4, 3, 5, 23};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> lists = Arrays.asList(array);
        Integer[] changedChar = (Integer[]) lists.toArray();
        System.out.println(lists);
        Arrays.sort(array);
        System.out.println(Arrays.toString(changedChar));
    }
}
