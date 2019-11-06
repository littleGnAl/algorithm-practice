package nowcoder;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {
    public int rectCover(int target) {
        if (target <= 0) return 0;
        if (target == 1 || target == 2) return target;

        return rectCover(target - 1) + rectCover(target - 2);
    }

    public static void main(String[] args) {
        // 0
        System.out.println(new RectCover().rectCover(0));
        // 1
        System.out.println(new RectCover().rectCover(1));
        // 2
        System.out.println(new RectCover().rectCover(2));
        // 3
        System.out.println(new RectCover().rectCover(3));
        // 5
        System.out.println(new RectCover().rectCover(4));
    }
}
