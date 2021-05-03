import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Map;


public class Inference{
  private List<String[]> citiesList;
  private Map<String, List<String> > countryCityMap;

  public Inference(List<String[]> citiesList, Map<String, List<String> > countryCityMap){
    this.citiesList = citiesList;
    this.countryCityMap = countryCityMap;
  }


  public Map<String, String> getHighestPopCityInCountries(){
    Map<String, String> highestPopulationCities = new HashMap<String, String>();
    for(String key: this.countryCityMap.keySet()){
      try{
        highestPopulationCities.put(key, countryCityMap.get(key).get(0));
      }
      catch(Exception e){
        //if the key doesn't have cities in it, put empty string
       highestPopulationCities.put(key, "");
      }

    }

    return highestPopulationCities;
  }


}
