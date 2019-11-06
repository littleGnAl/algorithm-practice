package nowcoder;

import java.util.Arrays;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class BuildingAProductArray {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return A;
        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }

        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }

        return B;
    }

    public static void main(String[] args) {
        int[] result = new BuildingAProductArray().multiply(new int[] {1, 2, 3, 4});
        // 24, 12, 8, 6
        System.out.println(Arrays.toString(result));
    }
}
