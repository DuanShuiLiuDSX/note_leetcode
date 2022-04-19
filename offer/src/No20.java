/**
 * @author cz
 * @Description 数值的字符串
 * @date 2022/4/17 19:13
 **/
public class No20 {
    class Solution {
        public boolean isNumber(String s) {
            if(s==null || s.length()==0) return false;
            if (s.contains(".")==true) {
                // A BC
                String[] strings = s.split(".");

                if (strings.length>2) return false;
                else if (strings.length==2){
                    if (strings[1].contains("e")^strings[1].contains("E")){
                        // B C
                        if(strings[1].contains("e")){
                            String[] bc = s.split("e");
                            if (bc.length>2) return false;
                            else return isA(strings[0]) && isB(bc[0]) && isC(bc[1]);
                        }else{
                            String[] bc = s.split("E");
                            if (bc.length>2) return false;
                            else return isA(strings[0]) && isB(bc[0]) && isC(bc[1]);
                        }

                    }else {
                        return isA(strings[0]) && isB(strings[1]);
                    }
                }
            }else {
                return isA(s);
            }
            return false;
        }
    }

    boolean isA(String s){
        return false;
    }
    boolean isB(String s){
        return false;
    }
    boolean isC(String s){
        return false;
    }
}
