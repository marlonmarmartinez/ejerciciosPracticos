package ejerciciospracticas4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RectangleBuilderGreaterArea {

    public static void main(String[] args) {
        int x=5;
        int []A=new int [9];
        A[0] = 1;
        A[1] = 2;
        A[2] = 5;
        A[3] = 1;
        A[4] = 1;
        A[5] = 2;
        A[6] = 3;
        A[7] = 5;
        A[8] = 1;
        System.out.println(solution(A, x));
        
    }
    
    public static int solution(int[] A, int X) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            if (map.get(a) == null) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
            }
        }
        List<Integer> valid = map.entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        int count = 0;
        int duplicatesCount = 0;
        int result = 0;
        Collections.sort(valid);
        for (Integer number : valid) {
            int factor = (int) Math.ceil((double) X / (double) number);
            int index = Collections.binarySearch(valid, factor);
            if (index < 0) {
                index = -index - 1;
            }
            count += valid.size() - index;
            if (number >= factor) {
                if (map.get(number) >= 4) {
                    duplicatesCount++;
                }
                count--;
            }
            result = count / 2 + duplicatesCount;
            if (result > 1000000000) {
                return -1;
            }
        }
        return result;
    }

    
}
