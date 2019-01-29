package ejerciciospracticas4;

import java.util.Arrays;

public class ArrayInversionCount {

    public static void main(String[] args) {

        int A[] = new int[6];
        A[0] = -1;
        A[1] = 6;
        A[2] = 3;
        A[3] = 4;
        A[4] = 7;
        A[5] = 4;
        System.out.println(solution(A));
        System.out.println(inversionCount(A));
    }

    public static int solution(int[] A) {
        
        int cont = 0;

        for (int i = 0; i < A.length-1; i++) {
            for (int j = i+1; j < A.length; j++) {
                
            
            if (A[i] > A[j]) {
                cont++;
            } 
            }
        }
        if(cont > 1000000000) return -1;
        return cont;
    }

    static int inversionCount(int[] a) {
        if (a.length <= 1) {
            return 0;
        }

        int index = a.length / 2;

        int[] leftArray = Arrays.copyOfRange(a, 0, index);
        int[] rightArray = Arrays.copyOfRange(a, index, a.length);

        return inversionCount(leftArray) + inversionCount(rightArray) + merge(a, leftArray, rightArray);
    }

    static int merge(int arr[], int[] left, int[] right) {
        int l = 0, r = 0, inv = 0;
        while (l < left.length || r < right.length) {
            if (l == left.length) {
                arr[l + r] = right[r];
                r++;
            } else if (r == right.length) {
                arr[l + r] = left[l];
                l++;
            } else if (left[l] > right[r]) {
                arr[l + r] = right[r];
                inv += (left.length - l);
                r++;
            } else if (left[l] <= right[r]) {
                arr[l + r] = left[l];
                l++;
            }
        }
        return inv;
    }
    
    static final int LIMIT = 1000000000;

	public int solution1(int[] A) {
		long inversionNum = countInversion(A, 0, A.length - 1);
		return inversionNum > LIMIT ? -1 : (int) inversionNum;
	}

	long countInversion(int[] A, int begin, int end) {
		if (begin >= end) {
			return 0;
		}

		int middle = (begin + end) / 2;
		long inversionNum = countInversion(A, begin, middle)
				+ countInversion(A, middle + 1, end);
		int[] merged = new int[end - begin + 1];
		int index1 = begin;
		int index2 = middle + 1;
		for (int i = 0; i < merged.length; i++) {
			if (index2 == end + 1
					|| (index1 != middle + 1 && A[index1] <= A[index2])) {
				merged[i] = A[index1];
				index1++;
			} else {
				merged[i] = A[index2];
				index2++;
				inversionNum += middle + 1 - index1;
			}
		}
		for (int i = begin; i <= end; i++) {
			A[i] = merged[i - begin];
		}
		return inversionNum;
	}
}
