package level1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrivacyExpiration {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();

        Map<String, String> term = new HashMap<String, String>();
        for(String str : terms) {
            String[] list = str.split(" ");
            term.put(list[0], list[1]);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate dateToDate = LocalDate.parse(today, formatter);

        for(int i = 0; i < privacies.length; i++) {
            String str = privacies[i];
            String[] list = str.split(" ");

            LocalDate finalDate = LocalDate.parse(list[0], formatter).plusMonths(Long.parseLong(term.get(list[1])));

            if(dateToDate.isAfter(finalDate) || dateToDate.isEqual(finalDate)) {
                answer.add(i+1);
            }

        }

        return answer;
    }
}
