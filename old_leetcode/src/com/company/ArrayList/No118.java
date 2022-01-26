package com.company.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class No118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<List<Integer>>();
        for(int i=0; i< numRows; i++){
            List<Integer> no = new ArrayList<Integer>();
            for(int j=0; j<=i; j++ ){
                if(j==0 || j==i){
                    no.add(1);
                }else{
                    no.add(tri.get(i-1).get(j-1)+tri.get(i-1).get(j));
                }
            }
            tri.add(no);
        }
        return tri;
    }

    public static void main(String[] args) {
        List<List<Integer>> tri = new ArrayList<List<Integer>>();
        tri = generate(5);
    }
}
