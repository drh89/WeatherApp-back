
package utils;


public class ExternalWeatherApi {
    
    //Query parameter: String. Will return cityinfo about the searched city. (Used to get woeid)
    private final String metaCityData = "https://www.metaweather.com/api/location/search/?query=";
    
    //Path parameter: int (woeid from above). Will return weatherinfo for next five days. 
    private final String metaWeatherDataByWoeid = "https://www.metaweather.com/api/location/";

    public String getMetaCityData() {
        return metaCityData;
    }

    public String getMetaWeatherDataByWoeid() {
        return metaWeatherDataByWoeid;
    }
    
    
    
    
    
    
    
}
