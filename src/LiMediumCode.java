import com.sun.xml.internal.ws.util.StringUtils;
import domain.ListNode;

import java.util.*;
import java.util.stream.IntStream;

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

    int left = 0;
    int right =height.length-1;

    while (left<right){
      max = Math.max(max,Math.min(height[left],height[right]) * (right-left));
      if (height[left] >height[right]){
        right--;
      }else {
        left++;
      }

    }
    return max;

  }


  /**
   * 整数反转
   *
   * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
   *
   * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
   *
   * 假设环境不允许存储 64 位整数（有符号或无符号）。
   *
   *
   * 示例 1：
   *
   * 输入：x = 123
   * 输出：321
   * 示例 2：
   *
   * 输入：x = -123
   * 输出：-321
   * 示例 3：
   *
   * 输入：x = 120
   * 输出：21
   * 示例 4：
   *
   * 输入：x = 0
   * 输出：0
   * @param x
   * @return
   */
  public static int reverse(int x) {

    try {
      String a1 = "" ;
      boolean b = false;
      if (x<0){
        String a = String.valueOf(x);
        a1 = a.substring(1,a.length());
        b = true;
      }else {
        a1 = String.valueOf(x);
      }
      StringBuilder sb = new StringBuilder(a1);
      String reversedStr = sb.reverse().toString();
      if (b){
        int c = Integer.parseInt(reversedStr);
        return c- 2*c;
      }
      return Integer.parseInt(reversedStr.trim());

    }catch (Exception e){
      return 0;
    }


  }


  /**
   * 最长回文子串
   * 给你一个字符串 s，找到 s 中最长的回文子串。
   *
   * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
   *
   *
   *
   * 示例 1：
   *
   * 输入：s = "babad"
   * 输出："bab"
   * 解释："aba" 同样是符合题意的答案。
   * 示例 2：
   *
   * 输入：s = "cbbd"
   * 输出："bb"
   *
   *
   * 提示：
   *
   * 1 <= s.length <= 1000
   * s 仅由数字和英文字母组成
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
return null;
  }

  /**
   * 下一个排列   说人话：找找下一个比自己大的
   *
   * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
   *
   * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
   * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
   *
   * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
   * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
   * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
   * 给你一个整数数组 nums ，找出 nums 的下一个排列。
   *
   * 必须 原地 修改，只允许使用额外常数空间。
   *
   *
   *
   * 示例 1：
   *
   * 输入：nums = [1,2,3]
   * 输出：[1,3,2]
   * 示例 2：
   *
   * 输入：nums = [3,2,1]
   * 输出：[1,2,3]
   * 示例 3：
   *
   * 输入：nums = [1,1,5]
   * 输出：[1,5,1]
   *
   * @param nums
   */
  public static void nextPermutation(int[] nums) {

    int index = nums.length-1;

    if (index == 0) return;

    if (index == 1  ){
      if (nums[index] - nums[index - 1] > 0){
        int num = nums[index];

        nums[index] = nums[index - 1];

        nums[index - 1] = num;

        return;
      }else {
        return;
      }

    }


    // TODO: 2024/1/12
    //  思路：，
    //        在数组中，找到最大的数字的下标 index，前面都不动，后面跟着找出index+1下标的数据其次大，剩下的排列成最小就行   、
    //        比如263541数据，首先找出最大数字‘6’，其下标是1，下一个数字放3541中比3大一个级别的数字‘4’，剩下的就是351排列最小数及135，
    //        答案就是  26  4  135


    int max = Arrays.stream(nums).max().getAsInt();

    //最大数字的下标
    int maxIndex = Arrays.binarySearch(nums, max);

    int[] ints1 = Arrays.stream(nums, maxIndex + 1, nums.length - 1).toArray();

    //最大数后一个数
    int i1 = ints1[0];

    int[] ints2 = Arrays.stream(ints1).sorted().toArray();

    int next = 0;

    for (int i = 0; i < ints2.length; i++) {
      if (ints2[i] == i1){
        next=ints2[i+1] ;
        break;
      }
    }



    // maxIndex + 1




    while (true){





      if (index == 0 && nums.length != 2){
        int[] ints = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < ints.length; i++) {
          nums[i] = ints[i];
        }
        return;
      }

      if (nums[index] - nums[index - 1] > 0 ){

        int num = nums[index];

        nums[index] = nums[index - 1];

        nums[index - 1] = num;

        return;

      }else {

        int num = nums[index];

        nums[index] = nums[index - 1];

        nums[index - 1] = num;

        index --;
      }

    }
  }


  /**
   * 电话号码的字母组合
   *
   * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
   *
   * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
   *
   *
   *
   *
   *
   * 示例 1：
   *
   * 输入：digits = "23"
   * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
   * 示例 2：
   *
   * 输入：digits = ""
   * 输出：[]
   * 示例 3：
   *
   * 输入：digits = "2"
   * 输出：["a","b","c"]
   *
   *
   * 提示：
   *
   * 0 <= digits.length <= 4
   * digits[i] 是范围 ['2', '9'] 的一个数字。
   * @param digits
   * @return
   */
  public static List<String> letterCombinations1(String digits) {

    if (digits == null || digits.equals("")){
      return new ArrayList<>();
    }



    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");

    if (digits.length() ==1){
      String[] chars = map.get(digits.charAt(0)).split("");
      return Arrays.asList(chars);
    }

    char[] chars = digits.toCharArray();

    //已知最大长度为4
    String a = null;
    String b = null;
    String c = null;
    String d = null;

    for (int i = 0; i < chars.length; i++) {
      switch (i){
        case 0:
          a = map.get(chars[i]);
          break;
        case 1:
          b = map.get(chars[i]);
          break;
        case 2:
          c = map.get(chars[i]);
          break;
        case 3:
          d = map.get(chars[i]);
          break;


      }
    }

    char[] chars1 = a.toCharArray();

    char[] chars2 = b.toCharArray();

    char[] chars3 = c == null ? null : c.toCharArray();

    char[] chars4 = d == null ? null : d.toCharArray();

    StringBuilder stringBuilder = new StringBuilder();

    List<String> list =new ArrayList<>();

    for (char c1 : chars1) {

      for (char c2 : chars2) {

        if (c != null){

          for (char c3 : chars3) {

            if (d != null){

              for (char c4 : chars4) {
                String s = stringBuilder.append(c1).append(c2).append(c3).append(c4).toString();
                list.add(s);
                stringBuilder.delete(0,4);
              }

            }else {
              String s = stringBuilder.append(c1).append(c2).append(c3).toString();
              list.add(s);
              stringBuilder.delete(0,3);
            }

          }

        }else {
          String s = stringBuilder.append(c1).append(c2).toString();
          list.add(s);

          stringBuilder.delete(0,2);
        }

      }

    }



    return list;

  }

  public static List<String> letterCombinations(String digits) {
    if (digits == null || digits.equals("")){
      return new ArrayList<>();
    }



    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");

    if (digits.length() ==1){
      String[] chars = map.get(digits.charAt(0)).split("");
      return Arrays.asList(chars);
    }

    ArrayList<String> combinations = new ArrayList<>();
    backtrack(combinations, map, digits, 0, new StringBuffer());
    return combinations;
  }

  public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {


    if (index == digits.length()){
      combinations.add(combination.toString());
      index = index-1;
      return;
    }


    char c = digits.charAt(index);
    String s = phoneMap.get(c);
    char[] chars = s.toCharArray();

    for (char aChar : chars) {

      combination.append(aChar);
      backtrack(combinations,phoneMap,digits,index+1,combination);

      combination.deleteCharAt(index);

    }

  }


  /**
   * 删除链表的倒数第 N 个结点
   *
   * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
   *
   *
   *
   * 示例 1：
   *
   *
   * 输入：head = [1,2,3,4,5], n = 2
   * 输出：[1,2,3,5]
   * 示例 2：
   *
   * 输入：head = [1], n = 1
   * 输出：[]
   * 示例 3：
   *
   * 输入：head = [1,2], n = 1
   * 输出：[1]
   *
   *
   * 提示：
   *
   * 链表中结点的数目为 sz
   * 1 <= sz <= 30
   * 0 <= Node.val <= 100
   * 1 <= n <= sz
   * @param head
   * @param n
   * @return
   */
  public static ListNode removeNthFromEnd(ListNode head, int n) {

    boolean f = false;
    int length =0;

    LinkedList<ListNode> list = new LinkedList<>();

    while (head.next != null){

      list.add(length,head);
      length++;
      head = head.next;

    }


    boolean b = n >= 2;

    int i = (list.size() - 1) - (n-2) ;


    ListNode listNode = list.get(i);

    ListNode listNode1 = list.get(0);

    for (int j = 0; j < (list.size() - n); j++) {
      // list.get(j).next;
    }


    return null;

  }

  public static ListNode removeNthFromEnd1(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    int length = getLength(head);
    ListNode cur = dummy;
    for (int i = 1; i < length - n + 1; ++i) {
      cur = cur.next;
    }
    cur.next = cur.next.next;
    ListNode ans = dummy.next;
    return ans;
  }

  public static int getLength(ListNode head) {
    int length = 0;
    while (head != null) {
      ++length;
      head = head.next;
    }
    return length;
  }


  public static void main(String[] args) {

    // [5,6,4]
    ListNode listNode2 = new ListNode();
    listNode2.val = 1;
    listNode2.next = new ListNode(3);
    listNode2.next.next =  new ListNode(4);
    listNode2.next.next.next =  new ListNode(8);
    listNode2.next.next.next.next =  new ListNode(9);
    listNode2.next.next.next.next.next =  new ListNode(6);

    ListNode listNode1 = removeNthFromEnd1(listNode2,3);


    // List<String> list = letterCombinations("259");
    // System.out.println(list);

    // nextPermutation(new int[]{2,3,1});


    // reverse(1534236469);


    // String s = intToRoman(10);
    // System.out.println(s);

    // int[]a = new int[]{12, 11,45};
    // maxArea(a);

  }
}
