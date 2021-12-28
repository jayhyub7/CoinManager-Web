package com.coin.manager.parser;

import com.coin.manager.entity.ExternalContent;
import com.coin.manager.entity.ExternalContentKey;
import com.coin.manager.entity.ExternalWriter;
import com.coin.manager.repository.ExternalContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RequiredArgsConstructor
public class CoinpanContentParser extends ContentParser {

    private final ExternalContentRepository externalContentRepository;

    //닉네임으로 검색 URL
    private static final String targetUrl = "https://coinpan.com/?act=&vid=&mid=free&category=&search_target=nick_name&search_keyword=";

    @Override
    public ExternalContent getNewContent(ExternalWriter externalWriter) {

        String nickName = externalWriter.getId().getNickName();
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

                    ExternalContentKey id = new ExternalContentKey("COINPAN", nickName, contentId);
                    System.out.println("contentId : " + contentId);
                    System.out.println("contentId : " + contentId);
                    System.out.println("externalContentRepository : " + externalContentRepository);
                    System.out.println("externalContentRepository : " + externalContentRepository);
                    //중복검사
                    if (externalContentRepository.existsById(id)) {
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

                    ExternalContent newContent = new ExternalContent();
                    newContent.setId(id);
                    newContent.setTitle(title);
                    newContent.setContent(sb.toString());

                    return newContent;

                }
            }

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
