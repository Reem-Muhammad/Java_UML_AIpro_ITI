import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class SortingPerKey{

  private List<String[]> citiesFileList; //used to find criteria for sorting the cities
  private List<String> citiesToSort;

  //citiesFileList: the converted file
  //cities: llist of cities to sort
  public SortingPerKey(List<String[]> citiesFileList, List<String> citiesToSort){
    this.citiesToSort = citiesToSort;
    this.citiesFileList = citiesFileList;
  }

  public List<Integer> getPopulations(){
    List<Integer> citiesPopulation = new ArrayList<Integer>();
    //~~~~ Extract populations for  given cities ~~~~//
    for(String city:citiesToSort){   //loop through the cities in that specific country
      //loop through all the list containing all cities with their info
      for(String[] city_info: citiesFileList){
          if(Arrays.asList(city_info).contains(city)){ //if a row in the full list contains the city name
            citiesPopulation.add(Integer.parseInt(city_info[2]));  //append population of that city (index 2 in the file) to a list
            break;
          }
      }
    }
    return citiesPopulation;
  }

/*
sorts a list of cities passed in the constructor
*/
  public List<String> sortCities(){
    List<String> cities_sorted = new ArrayList<String>();
    List<Integer> citiesPopulation_original = getPopulations();
    List<Integer> citiesPopulation_sorted = new ArrayList<>(citiesPopulation_original); //copy the original list

    Collections.sort(citiesPopulation_sorted, Collections.reverseOrder()); //sort the copy of the population list

    //search where each sorted population was in the original unsorted list (get the original index)
    for(int population_sorted:citiesPopulation_sorted){
      int pos = citiesPopulation_original.indexOf(population_sorted);

      //append corresponding cities so that they are put sorted
      cities_sorted.add(citiesToSort.get(pos));

    }

    return cities_sorted;
  }


}
