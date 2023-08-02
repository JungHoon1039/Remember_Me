package ssafy10.seoul8.function;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class scoreBoard {
    // 최종 결과를 점수판 형식으로 리턴하는 메소드
    public static String result(Map<String, Integer> memberMap) { // memberMap을 파라미터로 받아
        List<String> memberList = new ArrayList<>(memberMap.keySet()); // memberMap의 key(플레이어 이름)을 리스트로 만듬
        memberList.sort((o1, o2) -> memberMap.get(o2).compareTo(memberMap.get(o1))); // 해당 리스트를 value(점수) 내림차순 정렬
        Iterator<String> memberKey = memberList.iterator(); // 반복하기 위한 객체 생성
        String scoreBoard = "<html> 최종 점수 <br>";
        while (memberKey.hasNext()) { // 남은 키가 있는 경우
            String key = memberKey.next(); // 플레이어 이름
            String score = String.valueOf(memberMap.get(key)); // 플레이어 점수
            scoreBoard = scoreBoard + key + "님 점수 : " + score + "<br/>"; // 점수판에 표시
        }
        scoreBoard += "</html>";
        return scoreBoard;
    }
}
