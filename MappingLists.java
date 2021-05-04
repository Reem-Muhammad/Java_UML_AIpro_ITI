import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Map;

public class MappingLists{

/*
keyFileList: a list (converted file) that contains entries to be put as kays in the map
valueFileList: a list (converted file) that contains entries to be put as values in the map
keyField_idx: column (in keyFileList) from which the keys will be extracted
valueField_idx: column (in valueFileList) from which the values will be extracted
*/
  public Map<String, List<String> > generateMap(List<String[]> valueFileList, List<String[]> keyFileList, int keyField_idx, int valueField_idx){

    Map<String, List<String> > keyValueMap = new HashMap();

    //Fill in the map
    Iterator<String[]> keys_iter = keyFileList.iterator();

    while (keys_iter.hasNext()) {
        String[] key_info = keys_iter.next();


        //loop to extract cities corresponding to a certain country code
        List<String> valuesForKey = new ArrayList<String>();
        for (String[] value: valueFileList){

          //Some entries have less elements due to missing columns
          try{
            if(Arrays.asList(value).contains(key_info[keyField_idx])){  //if code of the city is the same as country
                valuesForKey.add(value[valueField_idx]); //append city name to list of cities
            }
              keyValueMap.put(key_info[keyField_idx], valuesForKey); //adds country and corresponding cities to map
          }
          catch (Exception e){
          }
        }
      }
  return keyValueMap;
  }

}
