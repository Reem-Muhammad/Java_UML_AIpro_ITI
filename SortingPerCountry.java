import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class SortingPerCountry{

  private List<String[]> citiesList;
  private List<String> cities;

  public SortingPerCountry(List<String[]> citiesList, List<String> cities){
    this.cities = cities;
    this.citiesList = citiesList;
  }

  public List<Integer> getPopulations(){
    List<Integer> citiesPopulation = new ArrayList<Integer>();
    //~~~~ Extract populations for  given cities ~~~~//
    //loop through the cities in that specific country
    for(String city:cities){
      //loop through all the list containing all cities with their info
      for(String[] city_info: citiesList){
          if(Arrays.asList(city_info).contains(city)){ //if a row in the full list contains the city name
            citiesPopulation.add(Integer.parseInt(city_info[2]));  //append population of that city (index 2 in the file) to a list
            break;
          }
      }
    }
    return citiesPopulation;

/*
//Print populations for cities in a  country
    for(String c:citiesPopulation){
      System.out.println(c);
    }
    */
  }

  public List<String> sortCities(){
    List<String> cities_sorted = new ArrayList<String>();
    List<Integer> citiesPopulation_original = getPopulations();
    List<Integer> citiesPopulation_sorted = new ArrayList<>(citiesPopulation_original); //copy the original list

    Collections.sort(citiesPopulation_sorted, Collections.reverseOrder()); //sort the copy of the population list

    //search where each sorted population was in the original unsorted list (get the original index)
    for(int population_sorted:citiesPopulation_sorted){
      int pos = citiesPopulation_original.indexOf(population_sorted);

      //append corresponding cities so that they are put sorted
      cities_sorted.add(cities.get(pos));

    }

    return cities_sorted;
  }


}
