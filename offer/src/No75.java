import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author cz
 * @Description
 * @date 2022/5/6 13:18
 **/
public class No75 {

    HashMap<Character, Integer> map = new  HashMap<>();
    ArrayList<Integer> array =  new ArrayList<>();
    String caseIn= new String();
    int index=0;
    public void Insert(char ch)
    {
        caseIn = caseIn.concat(String.valueOf(ch));
        if(map.containsKey(ch)==false){
            map.put(ch, index);
            array.add(index);
            index++;
        }else{
            Integer deIndex = map.get(ch);
//             System.out.println("de:" + deIndex);
            if(deIndex!=null){
                array.removeIf(e -> e.equals(deIndex));
                array.trimToSize();
            }
            index++;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if(array.size()==0) return '#';
        else {
            return caseIn.charAt(array.get(0));
        }
    }

    @Test
    public void test(){
        No75 no75 = new No75();
        no75.Insert('g');
        System.out.println(no75.FirstAppearingOnce());
    }
}
