/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EventProcessor;

/**
 *
 * @author danielwatson
 */
public class EventLocation {
    private String address;
    public EventLocation(String addres)
    {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

//    public void setAddress(String address) {
//        this.address = address;
//    }
  
    public String toString() {
        return "Location{" + "address=" + address + '}';
    }
    
    public void geocode(String address){
        //use geocoder etc
    }
    
   
}
