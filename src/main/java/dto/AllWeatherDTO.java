/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dennis
 */
public class AllWeatherDTO {
    
    private List<WeatherDTO> allWeather = new ArrayList();

    public List<WeatherDTO> getAllWeather() {
        return allWeather;
    }
    
    public AllWeatherDTO(){
        
    }
}
