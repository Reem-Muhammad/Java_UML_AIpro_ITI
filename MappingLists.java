import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.Map;

public class MappingLists{


  public Map<String, List<String> > generateMap(List<String[]> valueFileList, List<String[]> keyFileList, int keyField_idx, int valueField_idx){
/*
    for(String[] x: keyFileList){
      for(String y:x){
        System.out.print(y+" ");
      }
      System.out.println();
    }
*/

    Map<String, List<String> > keyValueMap = new HashMap();

    //Fill in the map
    Iterator<String[]> keys_iter = keyFileList.iterator();

    while (keys_iter.hasNext()) {
        String[] key_info = keys_iter.next();  // key_info=[SYC, Seychelles, 77000]

        //for(String x: key_info){System.out.print(x+"----");}
        //System.out.println();


        //loop to extract cities corresponding to a certain country code
        List<String> valuesForKey = new ArrayList<String>();
        for (String[] value: valueFileList){  //value = [1, Kabul, 1780000, AFG]

          if(Arrays.asList(value).contains(key_info[keyField_idx])){  //if code of the city is the same as country
              valuesForKey.add(value[valueField_idx]); //append city name to list of cities
          }
            keyValueMap.put(key_info[keyField_idx], valuesForKey); //adds country and corresponding cities to map

        //for(String x: value){System.out.print(x+" ");}
        //System.out.println();
        }
      }
  return keyValueMap;
  }

}
