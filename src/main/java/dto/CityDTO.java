
package dto;

public class CityDTO {
    
    private String title;
    private String location_type;
    private int woeid;
    private String latt_long;
    private String distance;
    
    public CityDTO(String title, String location_type, int woeid, String latt_long){
        this.title = title;
        this.location_type = location_type;
        this.woeid = woeid;
        this.latt_long = latt_long;
    }

    public CityDTO() {
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
    
    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public int getWoeid() {
        return woeid;
    }

    public void setWoeid(int woeid) {
        this.woeid = woeid;
    }

    public String getLatt_long() {
        return latt_long;
    }

    public void setLatt_long(String latt_long) {
        this.latt_long = latt_long;
    }
    
    
}
