package com.company.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);
        int len = nums.length;
        for (int i =0; i < len - 3; i ++) {
            if (i > 0 && nums [i] == nums [i-1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j ++) {
                if (j > i + 1 && nums [j] == nums [j-1]) {
                    continue;
                }
                int curr1 = nums [i], curr2 = nums [j];
                int left = j + 1, right = len - 1;
                while (left <right) {
                    int tmp = curr1 + curr2 + nums [left] + nums [right];
                    if (tmp == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(curr1);
                        list.add(curr2);
                        list.add(nums [left]);
                        list.add(nums [right]);
                        lists.add(list);
                        while (left < right && nums [left + 1] == nums [left]) left ++;
                        while (left < right && nums [right - 1] == nums [right]) right --;

                        left ++;
                        right --;

                    }else if (tmp <target) {
                        left ++;
                    }else {
                        right --;
                    }

                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        No18 no18 = new No18();
        System.out.println(no18.fourSum(new int[]{2,2,2,2,2}, 8));
    }
}
