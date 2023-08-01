package ssafy10.seoul8.pjh;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class answerCrawling {
    public static String searchGoogle(String word) {
        // 중앙정보처리학원 웹페이지의 공지사항 제목만 크롤링해서 파일에 저장하기
        String answer = null;
        try {
            String URL = "https://www.google.com/search?q=" + word;
            Document doc = Jsoup.connect(URL).get();
            Elements elements = doc.select("#kp-wp-tab-overview > div.TzHB6b.cLjAic.LMRCfc > div > div > div > div > div > div > div:nth-child(1) > div > div > div > span:nth-child(2)");
            if (elements.text().equals("")) {
                answer = "검색 결과가 없습니다";
            } else {
                answer = elements.text();
            }
        } catch (Exception e) {
            System.out.println("크롤링 실패 : " + e);
            e.printStackTrace();
        }
        System.out.println(answer);
        return answer;
    }
}
