package com.coin.manager.parser;

import com.coin.manager.entity.ExternalContent;
import com.coin.manager.entity.ExternalContentKey;
import com.coin.manager.parser.ExternalContentParser;
import com.coin.manager.repository.ExternalContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class CoinpanContentParser implements ExternalContentParser {

    ExternalContentRepository externalContentRepository;

    //닉네임으로 검색 URL
    private static final String targetUrl = "https://coinpan.com/?act=&vid=&mid=free&category=&search_target=nick_name&search_keyword=";
    @Override
    public String getExternalId(String nickName) {

        String url = targetUrl + nickName;
        try {
            Document doc = Jsoup.connect(url).get();
            Elements boardList = doc.select("#board_list");
            Elements rows = doc.select("tr");

            boolean isComplete = false;
            for (Element row : rows) {
                if (isComplete) {
                    break;
                }
                Elements cols = row.select("td");
                for (Element col : cols) {
                    //작성자 확인
                    if (!col.classNames().contains("author")) continue;
                    //닉네임 확인
                    if (!nickName.equals(col.select("a").text())) continue;

                    String contentUrl = cols.select("td.title").first().child(0).attr("href");
                    String contentId = contentUrl.substring(contentUrl.lastIndexOf("=") + 1, contentUrl.length());

                    //중복검사
                    if (externalContentRepository.existsById(new ExternalContentKey("COINPAN", contentId))) {
                        isComplete = true;
                        break;
                    }

                    Document contentDoc = Jsoup.connect("https://coinpan.com" + contentUrl).get();

                    String title = contentDoc.select(".board_read").select("h1").text();


                    String content = contentDoc.select(".board_read").select(".read_body").select("div.xe_content").html();
                    Pattern p = Pattern.compile("[<p>](.*?)[</p>]");
                    Matcher m = p.matcher(content);
                    String str = null;
                    StringBuffer sb = new StringBuffer();
                    while(m.find()) {
                        str = m.group(1);
                        str = str.replaceAll("&gt", ">");
                        str = str.replaceAll("&lt", "<");
                        if (!str.equals("")) {
                            if (str.contains("&nbs")) {
                                str = "\n";
                            } else {
                                str = str + "\n";
                            }
                            sb.append(str);
                        }
                    }
                }
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
