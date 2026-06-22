package level2;

import java.util.HashMap;
import java.util.Map;

public class NotCompleted {

    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            Map<String, Integer> result  = new HashMap<>();
            for(String name : participant) {
                result.merge(name, 1, Integer::sum);
            }

            for(String name : completion) {
                if(result.get(name) > 0)
                    result.put(name, result.get(name)-1);
            }

            for(String key : result.keySet() ) {
                if(result.get(key).equals(1)) {
                    answer = key;
                    break;
                }
            }
            return answer;
        }
    }
}
