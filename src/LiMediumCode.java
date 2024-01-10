import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: qjTang
 * @Description:
 * @Date: Created in 17:39 2024/1/10
 */
public class LiMediumCode {


  /**
   * 整数转罗马数字
   * <p>
   * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
   * <p>
   * 字符          数值
   * I             1
   * V             5
   * X             10
   * L             50
   * C             100
   * D             500
   * M             1000
   * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
   * <p>
   * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
   * <p>
   * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
   * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
   * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
   * 给你一个整数，将其转为罗马数字。
   * <p>
   * <p>
   * <p>
   * 示例 1:
   * <p>
   * 输入: num = 3
   * 输出: "III"
   * 示例 2:
   * <p>
   * 输入: num = 4
   * 输出: "IV"
   * 示例 3:
   * <p>
   * 输入: num = 9
   * 输出: "IX"
   * 示例 4:
   * <p>
   * 输入: num = 58
   * 输出: "LVIII"
   * 解释: L = 50, V = 5, III = 3.
   * 示例 5:
   * <p>
   * 输入: num = 1994
   * 输出: "MCMXCIV"
   * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
   *
   * @param num
   * @return
   */
  public static String intToRoman(int num) {
    StringBuffer s = new StringBuffer();
    return aa(s, num);


  }

  private static String aa(StringBuffer s, int num) {
    if (num == 0) return s.toString();
    if (num / 1000 >= 1) {
      //一千
      int cont = num / 1000;
      for (int i = 0; i < cont; i++) {
        s.append("M");
      }
      num = num - cont * 1000;
    } else if (num / 500 >= 1) {
      //5百以上
      //判断是否是400或者九百
      if (String.valueOf(num).indexOf("9") == 0) {
        s.append("CM");
        num = num - 900;
      } else {
        num = num - 500;
        s.append("D");
      }

    } else if (num / 100 >= 1) {
      //一百以上
      //判断是否是400或者九百
      if (String.valueOf(num).indexOf("4") == 0) {
        s.append("CD");
        num = num - 400;
      } else {
        int cont = num / 100;
        for (int i = 0; i < cont; i++) {
          s.append("C");
        }
        num = num - cont * 100;
      }

    } else if (num / 50 >= 1) {
      //5十以上
      if (String.valueOf(num).indexOf("9") == 0) {
        s.append("XC");
        num = num - 90;
      } else {
        num = num - 50;
        s.append("L");
      }

    } else if (num / 10 >= 1) {
      //十以上
      //判断是否是400或者九百
      if (String.valueOf(num).indexOf("4") == 0) {
        s.append("XL");
        num = num - 40;
      } else {
        int cont = num / 10;
        for (int i = 0; i < cont; i++) {
          s.append("X");
        }
        num = num - cont * 10;
      }

    } else if (num / 5 >= 1) {
      //5以上
      if (String.valueOf(num).indexOf("9") == 0) {
        s.append("IX");
        num = num - 9;
      } else {
        num = num - 5;
        s.append("V");
      }

    } else {
      //个位数
      if (String.valueOf(num).indexOf("4") == 0) {
        s.append("IV");
        num = num - 4;
      } else {
        for (int i = 0; i < num; i++) {
          s.append("I");
          num--;
        }
      }
    }
    return aa(s, num);
  }


  /**
   * 盛最多水的容器
   * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
   * <p>
   * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
   * <p>
   * 返回容器可以储存的最大水量。
   * <p>
   * 说明：你不能倾斜容器。
   *
   * @param height
   * @return
   */
  public static int maxArea(int[] height) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < height.length; i++) {

      for (int i1 = height.length-1; i1 >=  0; i1--) {
        if (i1 - i <= 0) break;

        max = Math.max(max, (i - i1) * Math.min(height[i], height[i1]));
      }

    }
    return max;

  }


  public static void main(String[] args) {
    // String s = intToRoman(10);
    // System.out.println(s);

    int[]a = new int[]{12, 11,45};
    maxArea(a);

  }
}
