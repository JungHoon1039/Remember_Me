package ssafy10.seoul8.function;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class randomQuiz {
    public static LinkedList<String> randomMember(Map<String, Integer> memberMap, Map<String, String> questionMap) {
        LinkedList<String> memberList = new LinkedList<>();
        int cnt = questionMap.size() / memberMap.size();
        int cntElse = questionMap.size() % memberMap.size();

        Iterator<String> memberKeys = memberMap.keySet().iterator();
        while (memberKeys.hasNext()) {
            String memberkey = memberKeys.next();
            for (int i = 0; i < cnt; i++) {
                memberList.add(memberkey);
            }
        }
        for (int j = 0; j < cntElse; j++) {
            String[] memberArray = memberMap.keySet().toArray(new String[memberMap.size()]);
            String randomMember = memberArray[new Random().nextInt(memberArray.length)];
            memberList.add(randomMember);
        }

        Collections.shuffle(memberList);
        return memberList;
    }

    public static LinkedList<String> randomQuestion(Map<String, String> questionMap) {
        LinkedList<String> questionList = new LinkedList<>(questionMap.keySet());
        Collections.shuffle(questionList);
        return questionList;
    }

}
