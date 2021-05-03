import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Map;


public class SortingAllCountries{
  private List<String[]> citiesList;
  private Map<String, List<String> > countryCityMap;

  public SortingAllCountries(List<String[]> citiesList, Map<String, List<String> > countryCityMap){
    this.citiesList = citiesList;
    this.countryCityMap = countryCityMap;
  }

  public Map<String, List<String> > sortCitiesAllCountries(){

    for(String key: this.countryCityMap.keySet()){
      SortingPerCountry obj = new SortingPerCountry(this.citiesList, countryCityMap.get(key));
      List<String> sortedCities= obj.sortCities();
      countryCityMap.replace(key, sortedCities);  //update the map with the sorted cities
    }

    return countryCityMap;
  }


}
