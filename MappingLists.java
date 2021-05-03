import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Map;

public class MappingLists{
  private String citiesFilePath;
  private String countriesFilePath;

  public Map<String, List<String> > generateMap(List<String[]> citiesList, List<String[]> countriesList){
    Map<String, List<String> > countryCityMap = new HashMap();

    //Fill in the map
    Iterator<String[]> country_iter = countriesList.iterator();

    while (country_iter.hasNext()) {
        String[] country_info = country_iter.next();  // country_info=[SYC, Seychelles, 77000]

        //loop to extract cities corresponding to a certain country code
        List<String> citiesOfCountry = new ArrayList<String>();
        for (String[] city: citiesList){  //city = [1, Kabul, 1780000, AFG]

          if(Arrays.asList(city).contains(country_info[0])){  //if code of the city is the same as country
            citiesOfCountry.add(city[1]); //append city name to list of cities
          }
          countryCityMap.put(country_info[0], citiesOfCountry); //adds country and corresponding cities to map

        }
      }
  return countryCityMap;
  }

}
