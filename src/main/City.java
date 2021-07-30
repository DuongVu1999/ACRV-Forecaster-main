package main;

/*
 * Data class City
 */
public class City {

    // Declare all the variables
    private String cityName;
    // Name of a city
    private Boolean favoriteCityFlag;
    // Flag indicating whether a city is a favorite city of a user
    private Boolean forecastFlag;
    // Flag indicating whether a user has requested today's forecast for a city
    private String cityFilepath;
    // File path to corresponding station file in HPD Network for a city
    private String cityURL;
    // URL of a city's location in Google Maps

    // Creating a public function to initialize the class
    public City(String newCityName, Boolean newFavoriteCityFlag, Boolean newForecastFlag, String newCityFilepath, String newCityURL) {
        cityName = newCityName;
        cityFilepath = newCityFilepath;
        favoriteCityFlag = newFavoriteCityFlag;
        forecastFlag = newForecastFlag;
        cityURL = newCityURL;
    }

    // Get and Set functions to access the attributes of the class
    public String getCityName() {
        return cityName;
    }
    
    public String getCityFilepath() {
        return cityFilepath;
    }

    public Boolean getFavoriteCityFlag() {
        return favoriteCityFlag;
    }

    public void setFavoriteCityFlag(Boolean favoriteCityFlag) {
        this.favoriteCityFlag = favoriteCityFlag;
    }
    
    public Boolean getForecastFlag() {
        return forecastFlag;
    }

    public void setForecastFlag(Boolean forecastFlag) {
        this.forecastFlag = forecastFlag;
    }
    
    public String getURL() {
        return cityURL;
    }
}