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

  public Map<String, List<String> > generateMap(List<String[]> citiesList, List<String[]> countriesList, int keyField_idx, int valueField_idx){
/*
    for(String[] x: countriesList){
      for(String y:x){
        System.out.print(y+" ");
      }
      System.out.println();
    }
*/

    Map<String, List<String> > countryCityMap = new HashMap();

    //Fill in the map
    Iterator<String[]> country_iter = countriesList.iterator();

    while (country_iter.hasNext()) {
        String[] country_info = country_iter.next();  // country_info=[SYC, Seychelles, 77000]

        //for(String x: country_info){System.out.print(x+"----");}
        //System.out.println();


        //loop to extract cities corresponding to a certain country code
        List<String> citiesOfCountry = new ArrayList<String>();
        for (String[] city: citiesList){  //city = [1, Kabul, 1780000, AFG]

          if(Arrays.asList(city).contains(country_info[keyField_idx])){  //if code of the city is the same as country
            citiesOfCountry.add(city[valueField_idx]); //append city name to list of cities
          }
          countryCityMap.put(country_info[keyField_idx], citiesOfCountry); //adds country and corresponding cities to map

        //for(String x: city){System.out.print(x+" ");}
        //System.out.println();
        }
      }
  return countryCityMap;
  }

}
