/**
 * @author cz
 * @Description 翻转单词顺序
 * @date 2022/5/6 9:33
 **/
public class No73 {
    public String ReverseSentence(String str) {
        String[] strings = str.split(" ");
        String res = new String();
        for (int i = strings.length-1; i >= 0; i--) {
            res = res.concat(strings[i]);
            if (i!=0){
                res = res.concat(" ");
            }
        }
        return  res;
    }
}
