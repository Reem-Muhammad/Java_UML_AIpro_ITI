import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Map;


public class Inference{
  private List<String[]> citiesList;
  private Map<String, List<String> > keyValueMap;

  public Inference(List<String[]> citiesList, Map<String, List<String> > keyValueMap){
    this.citiesList = citiesList;
    this.keyValueMap = keyValueMap;
  }


  public Map<String, String> getHighestPopCityInCountries(){
    Map<String, String> highestPopulationCities_countries = new HashMap<String, String>();
    for(String key: this.keyValueMap.keySet()){
      try{
        highestPopulationCities_countries.put(key, keyValueMap.get(key).get(0));
      }
      catch(Exception e){
        //if the key doesn't have cities in it, put empty string
       highestPopulationCities_countries.put(key, "");
      }

    }

    return highestPopulationCities_countries;
  }


  public Map<String, String> getHighestPopCityInContinents(){
    Map<String, String> highestPopulationCities_continents = new HashMap<String, String>();
    for(String key: this.keyValueMap.keySet()){
      try{
        highestPopulationCities_continents.put(key, keyValueMap.get(key).get(0));
      }
      catch(Exception e){
        //if the key doesn't have cities in it, put empty string
       highestPopulationCities_continents.put(key, "");
      }

    }

    return highestPopulationCities_continents;
  }

}
