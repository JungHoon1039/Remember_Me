package ssafy10.seoul8.function;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class answerCrawling {
    /**
     * 크롤링과 관련된 클래스 - 기능 전용 패키지로 관리
     */
    // 입력 된 값의 설명을 검색하여 문자열로 리턴하는 메소드
    public static String searchGoogle(String word) {
        String answer = null; // 리턴값 초기화
        try {
            String URL = "https://www.google.com/search?q=" + word; // 구글에서 입력갑을 검색한 URL 설정
            Document doc = Jsoup.connect(URL).get(); // URL document를 가져와서
            // css 선택자로 검색 결과를 찾음
            Elements elements = doc.select("#kp-wp-tab-overview > div.TzHB6b.cLjAic.LMRCfc > div > div > div > div > div > div > div:nth-child(1) > div > div > div > span:nth-child(2)");
            if (elements.text().equals("")) { // 선택자가 없는 경우
                answer = "검색 결과가 없습니다"; // 검색 결과 없음
            } else { // 선택자가 있는 경우
                answer = elements.text(); // 검색 결과를 문자열로 저장
            }
        } catch (Exception e) {
            System.out.println("크롤링 실패 : " + e);
            e.printStackTrace();
        }
        return answer;
    }
}
