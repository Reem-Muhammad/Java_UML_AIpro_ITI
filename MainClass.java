import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MainClass{

  public static void main(String[] args){
    FileToList citiesObj = new FileToList("Cities.txt");
    List<String[]> citiesList = citiesObj.convertFileToList();

    FileToList countriesObj = new FileToList("Countries.txt");
    List<String[]> countriesList= countriesObj.convertFileToList();

    MappingLists mapObj = new MappingLists();
    Map<String, List<String> > countryCityMap = mapObj.generateMap(citiesList, countriesList);


    //Inference obj = new Inference(citiesList, countryCityMap);
    //obj.getHighestPopCityInCountry();

    SortingAllCountries sortedCitiesObj = new SortingAllCountries(citiesList, countryCityMap);
    Map<String, List<String> > countryCityMap_sorted = sortedCitiesObj.sortCitiesAllCountries();

    //print sorted cities (according to population) for each country
    countryCityMap_sorted.forEach((country, city) -> {
        System.out.println(country + " => " + city);
    });
*/

    Inference obj = new Inference(citiesList, countryCityMap_sorted);
    Map<String, String> highestPopulationCities = obj.getHighestPopCityInCountries();

    //print countries with their highest population countries
    for(String key:highestPopulationCities.keySet()) {
        System.out.println(key + " => " + highestPopulationCities.get(key));
    }

  }

}
