package org.example.arxiv;


import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ArxivParserService {
    private static final String ARXIV_BASE_URL = "https://arxiv.org";
    public static void main(String[] args)  {
        String correctUrl = "https://arxiv.org/abs/2412.03631";
        String UrlWithWrongTopic = "https://arxiv.org/abs/2411.12101";
        try {
            parsePage(correctUrl);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void parsePage(String arxivUrl) throws IOException {
        Document doc = Jsoup.connect(arxivUrl).get();
        Article article = parseData(doc);
        System.out.println(article);
    }

    private static Article parseData(Document doc) {
        String url = doc.baseUri();
        String title = doc.select(".title").textNodes().get(0).text();
        String pdfUrl = ARXIV_BASE_URL + doc.select(".download-pdf").attr("href");
        String description = doc.select("blockquote.abstract").textNodes().get(1).text();
        List<String> authors = doc.select(".authors").tagName("a").stream().map(Element::text).toList();
        String[] header = doc.select(".subheader").get(0).text().split(">");
        String category = header[0];
        String subcategory = header.length > 1 ? header[1].trim() : null;
        String rawDate = doc.select(".submission-history").text().trim();
        String dateTime = getDateTime(rawDate);
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("d MMM yyyy HH:mm:ss")
                .withLocale(Locale.ENGLISH));

        logData(url, authors, title, pdfUrl, description, category, subcategory, dateTime, localDateTime);

        return Article.builder()
                .url(url)
                .pdfUrl(pdfUrl)
                .authors(authors)
                .title(title)
                .description(description)
                .category(category)
                .subcategory(subcategory)
                .sourceName("Arxiv")
                .date(localDateTime)
                .build();
    }

    private static void logData(String url, List<String> authors, String title, String pdfUrl, String description, String category, String subcategory, String dateTime, LocalDateTime dateTime1) {
        log.info("URL: {}", url);
        log.info("Pdf_url: {}", pdfUrl);
        log.info("Authors: {}", authors);
        log.info("Title: {}", title);
        log.info("Description: {}", description);
        log.info("Category: {}", category);
        log.info("Subcategory: {}", subcategory);
        log.info("LocalDateTime: {}", dateTime1);
    }

    private static String getDateTime(String datetime) {
        Pattern pattern = Pattern.compile("\\d{1,2}\\s\\w{3}\\s\\d{4}\\s\\d{2}:\\d{2}:\\d{2}");
        Matcher matcher = pattern.matcher(datetime);
        String result = null;
        while (matcher.find()) {
            result = matcher.group();
        }
        return result;
    }
}
