import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Map;


public class SortingAllKeys{
  private List<String[]> citiesFileList;  //the converted file as a list. contains the criteria for sorting
  private Map<String, List<String> > keyValueMap;  //map to extract list of cities to sort

  public SortingAllKeys(List<String[]> citiesFileList, Map<String, List<String> > keyValueMap){
    this.citiesFileList = citiesFileList;
    this.keyValueMap = keyValueMap;
  }

  public Map<String, List<String> > sortCitiesAllCountries(){

    for(String key: this.keyValueMap.keySet()){
      SortingPerKey obj = new SortingPerKey(this.citiesFileList, keyValueMap.get(key));
      List<String> sortedCities= obj.sortCities();
      keyValueMap.replace(key, sortedCities);  //update the map with the sorted cities
    }

    return keyValueMap;
  }


}
