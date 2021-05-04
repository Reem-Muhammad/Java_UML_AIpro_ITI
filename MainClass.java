import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


public class MainClass{

  public static void main(String[] args){
//~~~~~~~~~~~~~~~~~~~~~ Converting files to lists ~~~~~~~~~~~~~~~~~~~~~//
    FileToList citiesObj = new FileToList("Cities.txt");
    List<String[]> citiesList = citiesObj.convertFileToList();

    FileToList countriesObj = new FileToList("Countries.txt");
    List<String[]> countriesList= countriesObj.convertFileToList();

    FileToList continentObj = new FileToList("countryContinent.txt");
    List<String[]> continentList= continentObj.convertFileToList();


    FileToList capitalsObj = new FileToList("CapitalCountryContinent.txt");
    List<String[]> capitalsList= capitalsObj.convertFileToList();
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//



//~~~~~~~~~ Generating a map that contains country code as a key, and a list of its cities as a value ~~~~~~~~//
    MappingLists mapObj = new MappingLists();
    Map<String, List<String> > countryCityMap = mapObj.generateMap(citiesList, countriesList, 0, 1);

/*
    //Print the map
    System.out.println("------------------- Printing the cities of each country -----------------------\n");
    countryCityMap.forEach((country, city) -> {
        System.out.println(country + " ===> " + city);
        System.out.println();
    });
    System.out.print("-------------------------------------------------------------------\n\n\n");
*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//



//~~~~~~~~~~~ Generating a map that contains continent name as key, and a list of its countries (3-letter code) as value ~~~~~~~~~//
    MappingLists continentCountryObj = new MappingLists();
    Map<String, List<String> > continentCountryMap = continentCountryObj.generateMap(continentList, continentList, 5, 2);

/*
    //print the continent-countries map
    System.out.println("\n\n------------------- Printing the countries of each continent -----------------------\n");
    continentCountryMap.forEach((continent, country) -> {
        System.out.println(continent + " => " + country);
        System.out.println();
    });
    System.out.print("-------------------------------------------------------------------\n\n\n");
    */
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    //extract all cities for each continent
    Map<String, List<String> > continentCityMap = new HashMap<String, List<String> >();
    for(String continent: continentCountryMap.keySet()){  //extract each continent from the map
      List<String> citiesInContinent = new ArrayList<String>(); //list to store cities of each continent
      try{
        for(String country:continentCountryMap.get(continent)){  //for each continent, extract its countries one country at a time
            for(String city:countryCityMap.get(country)){  //extract each city for a given country, and append to a list
              citiesInContinent.add(city);
            }
        }
      }
      catch (Exception e){
        //do nothing if the country does not exist as a key in the country-cities map
      }

      continentCityMap.put(continent, citiesInContinent); //Add continent as a key and its cities as a value

    }

/*
//print continent-cities map
    System.out.println("\n\n------------------- Printing the cities of each continent -----------------------\n");
    continentCityMap.forEach((continent, city) -> {
        System.out.println(continent + " => " + city);
        System.out.println();
    });
    System.out.print("-------------------------------------------------------------------\n\n\n");
*/



//~~~~~~~~~~~ Generating a map that contains all capitals as a value (just to fit the functions in other classes) ~~~~~~~~~//
    Map<String, List<String> > capitalsMap = new HashMap<String, List<String> >();
    List<String> capitals = new ArrayList<String>();
    for(String[] entry:capitalsList){
      capitals.add(entry[1]); //extracts capitals
    }
    capitalsMap.put("All", capitals);


/*
//Print capitals
    System.out.println("\n\n------------------- Printing the capitals -----------------------\n");
    capitalsMap.forEach((key, cap) -> {
        System.out.println(key + " => " + cap);
    });
    System.out.print("---------------------------------------------------------------------\n\n\n");
*/
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//



//~~~~~~~~ Sorting cities in each country according to population ~~~~~~~~~~~//
    SortingAllKeys sortedCitiesObj = new SortingAllKeys(citiesList, countryCityMap);
    Map<String, List<String> > countryCityMap_sorted = sortedCitiesObj.sortCitiesAllCountries();


    //print sorted cities (according to population) for each country
    System.out.println("\n\n------------------- Printing sorted cities acc. to population, in each country -----------------------\n");
    countryCityMap_sorted.forEach((country, city) -> {
        System.out.println(country + " => " + city);
        System.out.println();
    });
    System.out.print("---------------------------------------------------------------------\n\n\n");

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//




//~~~~~~~~~~~ Sorting cities in each continent according to population ~~~~~~~~~~~~~//
    SortingAllKeys sortedCitiesOfContinentObj = new SortingAllKeys(citiesList, continentCityMap);
    Map<String, List<String> > continentCityMap_sorted = sortedCitiesOfContinentObj.sortCitiesAllCountries();


    //print sorted cities (according to population) for each continent
    System.out.println("\n\n------------------- Printing sorted cities acc. to population, in each continent -----------------------\n");
    continentCityMap_sorted.forEach((continent, city) -> {
        System.out.println(continent + " => " + city);
        System.out.println();
    });
    System.out.print("--------------------------------------------------------------------------\n\n\n");



//~~~~~~~~~~~ Sorting capitals according to population ~~~~~~~~~~~~~//
      SortingAllKeys sortedCapitalsObj = new SortingAllKeys(citiesList, capitalsMap);
      Map<String, List<String> > capitalsMap_sorted = sortedCapitalsObj.sortCitiesAllCountries();


      //Print sorted capitals
      System.out.println("\n\n------------------- Printing sorted capitals acc. to population -----------------------\n");
      capitalsMap_sorted.forEach((key, cap) -> {
          System.out.println(key + " => " + cap);
      });
      System.out.print("--------------------------------------------------------------------------\n\n\n");





// ~~~~~~~~~~~~~~~~~~~ get highest population city in each country ~~~~~~~~~~~~~~~~~//
    HighestValues country = new HighestValues(countryCityMap_sorted);
    Map<String, String> highestPopulationCities_countries = country.getHighestPopCityInCountries();


    //print countries with their highest population countries
    System.out.println("\n\n------------------- Printing highest population city in each country -----------------------\n");
    for(String key:highestPopulationCities_countries.keySet()) {
        System.out.println(key + " => " + highestPopulationCities_countries.get(key));
    }
    System.out.print("--------------------------------------------------------------------------\n\n\n");
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//





//~~~~~~~~~~~~~ get highest population city in each continent ~~~~~~~~~~~~~~~~//
    HighestValues continent = new HighestValues(continentCityMap_sorted);
    Map<String, String> highestPopulationCities_continents = continent.getHighestPopCityInContinents();

    //print continents with their highest population cities
    System.out.println("\n\n------------------- Printing highest population city in each continent -----------------------\n");
    for(String key:highestPopulationCities_continents.keySet()) {
        System.out.println(key + " => " + highestPopulationCities_continents.get(key));
    }
    System.out.print("--------------------------------------------------------------------------\n\n\n");
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//





//~~~~~~~~~~~~~~~ get highest population capital in all countries ~~~~~~~~~~~~~~~~~~~//
    HighestValues capital = new HighestValues(capitalsMap_sorted);
    Map<String, String> highestPopulationCapital_all = capital.getHighestPopCityInContinents();

    //print continents with their highest population cities
    System.out.println("\n\n------------------- Printing highest population capital -----------------------\n");
    for(String key:highestPopulationCapital_all.keySet()) {
        System.out.println(key + " => " + highestPopulationCapital_all.get(key));
      }
      System.out.print("--------------------------------------------------------------------------\n\n\n");
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

  }

}
