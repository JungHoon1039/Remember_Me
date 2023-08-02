package ssafy10.seoul8.pjh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class scoreBoard {
    public static String result(Map<String, Integer> memberMap) {
        List<String> memberList = new ArrayList<>(memberMap.keySet());
        memberList.sort((o1, o2) -> memberMap.get(o2).compareTo(memberMap.get(o1)));
        Iterator<String> memberKey = memberList.iterator();
        String scoreBoard = "<html> 최종 점수 <br>";
        while (memberKey.hasNext()) {
            String key = memberKey.next();
            String score = String.valueOf(memberMap.get(key));
            scoreBoard = scoreBoard + key + "님 점수 : " + score + "<br/>";
        }
        scoreBoard += "</html>";
        return scoreBoard;
    }
}
