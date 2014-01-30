/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WebScraperForLinks;

import java.util.ArrayList;

/*
 * @author danielwatson
 */
public class AllEvents {
    
    private ArrayList<String> resultList;
    private ArrayList<String> temp;
    private ArrayList<String> test;
    
    public AllEvents() {
        resultList = new ArrayList<String>();
        temp = new ArrayList<String>();
        test = new ArrayList<String>();
        
    }
    
//    public void addLinkToDetails(int index, String url) {
//        detailPageList.add(index, url);
//    }
    
    public void getResultPageList() {
        ResultPageLinks RPL = new ResultPageLinks();
        resultList = RPL.getUrls("http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=");
    }
    
    //        public ArrayList processAllEventLinks(){
    //        ResultPageLinks RPL = new ResultPageLinks();
    //        resultList = RPL.getUrls("http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=");
    //        DetailPageLinks DPL = new DetailPageLinks();
    //        detailPageList = DPL.getUrls("http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=");
    //        int i = 0;
    //        for(String resultLink : resultList) {
    //            System.out.println("\n" + i++ +" : "+ resultLink);
    //            test = DPL.getUrls(resultLink);
    //
    //            for(String details : test){
    //               System.out.println(details);
    //            }
    //           //detailPageList.addAll(DPL.getUrls(resultLink));
    //        }
    //        return detailPageList;
    //    }
    

    public ArrayList processAllEventLinks(){
        getResultPageList();
        DetailPageLinks DPL = new DetailPageLinks();
        for(String resultLink : resultList){
            temp = DPL.getUrls(resultLink);
            
//            for(String detailLink : temp){
//                if(detailLink.equals("")){
//                } else {
//                    test = DPL.getUrls(detailLink);
//                }
//            }   
        }
        return temp;
    }
    
    public void detailURLs(){
        for (String link : temp) {
            System.out.println(link);
        }
    }  
    public void resultPageURLs() {
        for (String link : resultList) {
            System.out.println(link);
        }
    }
    public void getTest() {
        for (String link : test) {
            System.out.println(link);
        }
    }
}
//DetailPageLinks DPL = new DetailPageLinks("http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=");
//  resultList = RPL.getUrls("http://www.runnersworld.co.uk/events/foundevents.asp?v=2&evntTitle=&evntDate=a%3afut&distance=&county=&area=&distanceFromHome=&evntSurface=&evntGround=&evntWheelChairAccessible=");
//detailPageList = DPL.getUrls();