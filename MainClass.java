import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


public class MainClass{

  public static void main(String[] args){
    FileToList citiesObj = new FileToList("Cities.txt");
    List<String[]> citiesList = citiesObj.convertFileToList();

    FileToList countriesObj = new FileToList("Countries.txt");
    List<String[]> countriesList= countriesObj.convertFileToList();

    FileToList continentObj = new FileToList("countryContinent.txt");
    List<String[]> continentList= continentObj.convertFileToList();

/*
//print continentList
    for(String[] x:citiesList) {
      for (String y:x){
        System.out.print(y+"  ");
      }
        System.out.println();
    }
*/
    //Generating a map that contains country code as a key, and a list of its cities as a value
    MappingLists mapObj = new MappingLists();
    Map<String, List<String> > countryCityMap = mapObj.generateMap(citiesList, countriesList, 0, 1);
/*

    countryCityMap.forEach((continent, country) -> {
        System.out.println(continent + " ===> " + country);
    });
*/




    //~~~~~~~~~~~ Generating a map that contains continent name as key, and a list of its countries (3-letter code) as value ~~~~~~~~~//
    MappingLists continentCountryObj = new MappingLists();
    Map<String, List<String> > continentCountryMap = continentCountryObj.generateMap(continentList, continentList, 5, 2);

/*
    //print the continent-countries map
    continentCountryMap.forEach((continent, country) -> {
        System.out.println(continent + " => " + country);
    });
*/

    //extract all cities for each continent
    Map<String, List<String> > continentCityMap = new HashMap<String, List<String> >();
    for(String continent: continentCountryMap.keySet()){  //extract each continent from the map
      List<String> citiesInContinent = new ArrayList<String>();
      //String x = continentCountryMap.get(continent);
      //String[] countries = x.split(",");
      try{
        for(String country:continentCountryMap.get(continent)){  //for each continent, extract its countries
            //System.out.print(country + " -- ");
            //int x = countryCityMap.get(country);
            //System.out.print(countryCityMap.get(country)[0]);

            for(String city:countryCityMap.get(country)){  //extract each city for a given country, and append to a list
              citiesInContinent.add(city);
              //System.out.print(city+"***");

            }


        }
      }
      catch (Exception e){

      }
/*
      for(String x:citiesInContinent){System.out.print(x+"..");}
      System.out.println();
      System.out.println();
      System.out.println();
      */
      continentCityMap.put(continent, citiesInContinent);

    }

/*
//print continent-cities map
    System.out.println("================================");
    continentCityMap.forEach((continent, country) -> {
        System.out.println(continent + " => " + country);
    });
*/


    //Inference obj = new Inference(citiesList, countryCityMap);
    //obj.getHighestPopCityInCountry();

//~~~~~~~~ Sorting cities in each country according to population ~~~~~~~~~~~//
    SortingAllKeys sortedCitiesObj = new SortingAllKeys(citiesList, countryCityMap);
    Map<String, List<String> > countryCityMap_sorted = sortedCitiesObj.sortCitiesAllCountries();

/*
    //print sorted cities (according to population) for each country
    countryCityMap_sorted.forEach((country, city) -> {
        System.out.println(country + " => " + city);
    });
*/

//~~~~~~~~~~~ Sorting cities in each continent according to population ~~~~~~~~~~~~~//
    SortingAllKeys sortedCitiesOfContinentObj = new SortingAllKeys(citiesList, continentCityMap);
    Map<String, List<String> > continentCityMap_sorted = sortedCitiesOfContinentObj.sortCitiesAllCountries();


    //print sorted cities (according to population) for each continent
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println("AFTER SORTING");
    continentCityMap_sorted.forEach((country, city) -> {
        System.out.println(country + " => " + city);
    });





// ~~~~~~~~~~~ get highest population city in each country ~~~~~~~~~~~//
    Inference countryObj = new Inference(citiesList, countryCityMap_sorted);
    Map<String, String> highestPopulationCities_countries = countryObj.getHighestPopCityInCountries();

/*
    //print countries with their highest population countries
    for(String key:highestPopulationCities.keySet()) {
        System.out.println(key + " => " + highestPopulationCities_countries.get(key));
    }
*/


//~~~~~~~~~~~~~ get highest population city in each continent ~~~~~~~~~~~~~~~~//
    Inference obj = new Inference(citiesList, continentCityMap_sorted);
    Map<String, String> highestPopulationCities_continents = obj.getHighestPopCityInContinents();

    //print continents with their highest population cities
    for(String key:highestPopulationCities_continents.keySet()) {
        System.out.println(key + " => " + highestPopulationCities_continents.get(key));
    }
  }

}
