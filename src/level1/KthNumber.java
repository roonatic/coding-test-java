package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthNumber {
    public List<Integer>solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<Integer>();

        for(int[] command : commands) {
            List<Integer> arr = new ArrayList<Integer>();

            for(int i = command[0]; i <= command[1]; i++)
                arr.add(array[i-1]);

            Collections.sort(arr);
            answer.add(arr.get(command[2]-1));
        }
        return answer;
    }
}
