package ssafy10.seoul8.function;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class randomQuiz {
    /**
     * 랜덤화 하는 것과 관련 된 클래스 - 기능 전용 패키지로 관리
     */
    // 퀴즈 목록을 랜덤하게 설정한 리스트로 리턴하는 메소드
    public static LinkedList<String> randomQuestion(Map<String, String> questionMap) { // questionMap을 파라미터로 받아
        LinkedList<String> questionList = new LinkedList<>(questionMap.keySet()); // key(문제)로 리스트를 만듬
        Collections.shuffle(questionList); // 랜덤하게 섞음
        return questionList;
    }

    // 문제를 풀 플레이어를 랜덤하게 설정한 리스트로 리턴하는 메소드
    public static LinkedList<String> randomMember(Map<String, Integer> memberMap, Map<String, String> questionMap) { // memberMap, questionMap을 파라미터로 받아
        LinkedList<String> memberList = new LinkedList<>(); // key(이름)으로 리스트를 만듬
        int cnt = questionMap.size() / memberMap.size(); // 1인당 풀어야 하는 최소 문제 수
        int cntElse = questionMap.size() % memberMap.size(); // 1인당 추가로 풀 수 있는 문제 수 - 문제 수 만큼 플레이어 리스트 사이즈를 맞추기 위함

        Iterator<String> memberKeys = memberMap.keySet().iterator(); // 반복하기 위한 객체 생성
        while (memberKeys.hasNext()) { // 남은 키가 있는 경우
            String memberkey = memberKeys.next(); // 플레이어 이름
            for (int i = 0; i < cnt; i++) { // 1인당 풀어야 하는 최소 문제 수 만큼
                memberList.add(memberkey); // 플레이어 추가
            }
        }
        for (int j = 0; j < cntElse; j++) { // 1인당 추가로 풀 수 있는 문제 수
            String[] memberArray = memberMap.keySet().toArray(new String[memberMap.size()]); // memberMap의 key를 배열화 하여
            String randomMember = memberArray[new Random().nextInt(memberArray.length)]; // 배열의 랜덤 인덱스에서 엘리멘트 추출하여 변수에 할당
            memberList.add(randomMember); // 랜덤한 플레이어가 리스트에 추가 됨
        }

        Collections.shuffle(memberList); // 리스트를 섞음
        return memberList;
    }
}
