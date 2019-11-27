/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.AllWeatherDTO;
import dto.CityDTO;
import dto.WeatherDTO;
import java.util.List;
import java.util.concurrent.ExecutionException;
import threads.SingleFutureCallable;
import utils.ExternalWeatherApi;

/**
 *
 * @author Dennis
 */
public class WeatherFacade {    
    
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final ExternalWeatherApi EWA = new ExternalWeatherApi();
    private final SingleFutureCallable THREAD  = new SingleFutureCallable();
    
    
    public CityDTO getCityInfo(String cityname) throws InterruptedException, ExecutionException{
        String temp = THREAD.run(EWA.getMetaCityData() + cityname);
        
        CityDTO[] cityInfo = GSON.fromJson(temp, CityDTO[].class);
        return cityInfo[0];
    }
    
    public List<WeatherDTO> getWeatherByCity(String cityname) throws InterruptedException, ExecutionException{
        AllWeatherDTO allWeather = GSON.fromJson(THREAD.run(EWA.getMetaWeatherDataByWoeid() + getCityInfo(cityname).getWoeid()), AllWeatherDTO.class);
        
        return allWeather.getConsolidated_weather();
    }
    
    public List<WeatherDTO> getWeatherByLatLong(String longLat) throws InterruptedException, ExecutionException{
        String temp = THREAD.run(EWA.getMetaWeatherLongLat() + longLat);
        
        CityDTO[] res = GSON.fromJson(temp, CityDTO[].class);
        CityDTO cityInfo = res[0];
        return getWeatherByCity(cityInfo.getTitle());
    }

   
}
