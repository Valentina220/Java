package ru.Makval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите запрос: ");
        String user_request = scanner.nextLine();
        String query = "https://ru.wikipedia.org/wiki/" + user_request;
        System.out.println(query);

        //____Запрос выполняется. В консоли отображается html_________

        HttpURLConnection connection = null;

        try{
            connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);

            connection.connect();

            StringBuilder sb = new StringBuilder();

            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));  //"cp1251"

                String line;
                while ((line = in.readLine()) != null){
                    sb.append(line);
                    sb.append("\n");
                }

                System.out.println(sb.toString());
            } else {
                System.out.println("fail: " + connection.getResponseCode() + ", " + connection.getResponseMessage());
            }
        } catch (Throwable cause){
            cause.printStackTrace();
        } finally {
            if(connection != null){
                connection.disconnect();
            }
        }

        List<Site> articleList = new ArrayList<>();

        Document doc = Jsoup.connect("https://javarush.ru/").get();

        //_______Парсинг Wiki_______
//        Elements spanElements = doc.getElementsByAttributeValue("class", "info-card__content");
//
//        //String title = spanElements.text();
//
//        spanElements.forEach(spanElement -> {
//
//            String title = spanElement.text();
//            Elements pElement = spanElement.nextElementSiblings();
//            String content = pElement.text();
//
//            articleList.add(new Wiki(title, content));
//        });


        //______________Парсинг JavaRush______________
        Elements divElements = doc.getElementsByAttributeValue("class", "info-card__content");

        divElements.forEach(divElement -> {

            Element h2Element = divElement.child(0);
            Element pElement = divElement.child(1);
            String title = h2Element.text();
            String content = pElement.text();

            articleList.add(new Site(title, content));
        });

        articleList.forEach(System.out::println);
    }


    public static class Site{
        private String title;
        private String text;

        public Site(String title, String text){
            this.title = title;
            this.text = text;
        }

        public String getTitle(){
            return title;
        }
        public void setTitle(String title){
            this.title = title;
        }

        public String getText(){
            return text;
        }
        public void setText(String text){
            this.text = text;
        }

        @Override
        public String toString(){
            return "Title: " + title + "\n" + "text: " + text;
        }
    }
}
