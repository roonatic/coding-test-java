package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionalDev {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> temp = new ArrayList<>();
        Queue<Integer> work = new LinkedList<>();

        int result = 1;
        for(int i = 0; i < progresses.length; i++) {
            int day = (int)Math.ceil((double)(100 - progresses[i]) / (double)speeds[i]);

            if(work.isEmpty())
                work.add(day);
            else if(work.peek() >= day)
                result++;
            else if(work.peek() < day) {
                work.add(day);
                temp.add(result);
                work.remove();
                result = 1;
            }
        }

        if(!work.isEmpty())
           temp.add(result);

        answer = temp.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
