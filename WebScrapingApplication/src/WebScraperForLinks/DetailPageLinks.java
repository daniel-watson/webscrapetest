/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WebScraperForLinks;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author danielwatson
 */
public class DetailPageLinks{
    private String url;
    private Document doc;
    private ArrayList<String> detailResultList;
    private ArrayList<String> resultList;
    
    
    public DetailPageLinks() {
        detailResultList = new ArrayList<String>();
        //resultList = new ArrayList<String>();
    }
    public Document connectToLink(String url){
        try{
            //use Jsoup connect to point it to the correct page
            //use .get or the get HTTP protocol toreturn the web page.
            doc = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .timeout(30000)
                    .get();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
        
    }
    
    
    public ArrayList getUrls(String url) {
        //ResultPageLinks RPL = new ResultPageLinks();
        //resultList = RPL.getUrls(url);
        String s ="";
        //for(String resultLink : resultList) {
        Document doc = connectToLink(url);
        //Finds matching elements. it will look in for a class named evntTitle.
        //It will then save any <ahref> links to the list links
        Elements links = doc.select(".evntTitle > a[href]");
        
        int i = 0;
        for (Element link : links){
            if( link.attr("href").contains("viewevent") ){
                s = "http://www.runnersworld.co.uk" + link.attr("href");
                detailResultList.add(i,s);
                i++;
            }
            
        }
        //}
        return detailResultList;
    }
    
    public void displayDetailURLs(){
        for (String link : detailResultList)
        {
            System.out.println(link);
        }
    }
    
    
    //    public String getDetailURL() {
    //        String s ="";
    //        Elements links = getDetailPageURLs();
    //        for (Element link : links) {
    //            if( link.attr("href").contains("viewevent") ){
    //                s = s + "\nLink : " + "http://www.runnersworld.co.uk" + link.attr("href");
    //                //System.out.println("Race Title : " + link.text());
    //                //System.out.println(i++);
    //            }
    //        }
    //        return s;
    //    }
}