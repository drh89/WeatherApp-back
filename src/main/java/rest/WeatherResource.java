package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CityDTO;
import dto.WeatherDTO;
import utils.EMF_Creator;
import facades.WeatherFacade;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Todo Remove or change relevant parts before ACTUAL use
@Path("weather")
public class WeatherResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/WeatherApp",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
//    private static final FacadeExample FACADE =  FacadeExample.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final WeatherFacade FACADE = new WeatherFacade();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @GET
    @Path("/city/{city}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCityInfo(@PathParam("city") String city) throws InterruptedException, ExecutionException {

        CityDTO cityInfo = FACADE.getCityInfo(city);
        return Response.ok().entity(GSON.toJson(cityInfo)).build();

    }

    @GET
    @Path("/fivedays/{city}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getFiveDaysWeather(@PathParam("city") String city) throws InterruptedException, ExecutionException {
        List<WeatherDTO> allWeather = FACADE.getWeatherByCity(city);

        return Response.ok().entity(GSON.toJson(allWeather)).build();

    }

    @GET
    @Path("/latlong/{latLong}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getWeatherByLatLong(@PathParam("latLong") String latLong) throws InterruptedException, ExecutionException{
        List<WeatherDTO> allWeather = FACADE.getWeatherByLatLong(latLong);
        return Response.ok().entity(GSON.toJson(allWeather)).build();
        
    }
    



}
