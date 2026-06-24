package level1;

import java.util.HashMap;
import java.util.Map;

// 구현은 HashMap으로 해서 풀었지만, 사실 HashSet으로 풀면 더 간단한 문제
public class Ponketmon {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> ponketmon = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if(ponketmon.get(num) == null)
                ponketmon.put(num, 1);
            else
                ponketmon.replace(num, ponketmon.get(num));
        }

        if(nums.length / 2 <= ponketmon.size())
            answer = nums.length / 2;
        else
            answer = ponketmon.size();

        return answer;
    }
}
