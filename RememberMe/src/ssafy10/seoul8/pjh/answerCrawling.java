package ssafy10.seoul8.pjh;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class answerCrawling {
    public static String searchGoogle(String word) {
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
        return answer;
    }
}
