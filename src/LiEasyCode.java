import com.sun.prism.impl.BufferUtil;
import com.sun.xml.internal.ws.util.StringUtils;
import domain.ListNode;
import sun.plugin.javascript.navig.Link;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: qjTang
 * @Description:
 * @Date: Created in 15:26 2024/1/9
 */
public class LiEasyCode {

  /**
   * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
   *
   * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
   *
   * 你可以按任意顺序返回答案。
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum(int[] nums, int target) {
    int [] a = new int[0];
    List<Integer> integerList = IntStream.of(nums).boxed().collect(Collectors.toList());
    for (int i = 0; i < nums.length; i++) {
      int i2 = target - nums[i];
      int i1 = integerList.indexOf(i2);
      if (integerList.contains(i2) && (i1 != i)){
        a = new int[]{i, i1};
      }
    }
    return a;

  }


  /**
   * 两数相加
   *
   * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
   *
   * 请你将两个数相加，并以相同形式返回一个表示和的链表。
   *
   * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
   *
   * @param l1
   * @param l2
   * @return
   */
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null && l2 ==null) return null;

    if (l1 == null) l1 = new ListNode(0);

    if (l2 == null) l2 = new ListNode(0);


    int i = l1.val + l2.val;

    if (i>=10){

      if (l1.next != null){
        l1.next.val ++;
      }else {
        l1.next = new ListNode(1);
      }



      return new ListNode(i-10,addTwoNumbers(l1.next,l2.next));

    }


    return new ListNode(i,addTwoNumbers(l1.next,l2.next));

  }


  /**
   * 无重复字符的最长子串
   *
   * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
   *
   *
   *
   * 示例 1:
   *
   * 输入: s = "abcabcbb"
   * 输出: 3
   * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
   * 示例 2:
   *
   * 输入: s = "bbbbb"
   * 输出: 1
   * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
   * 示例 3:
   *
   * 输入: s = "pwwkew"
   * 输出: 3
   * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
   *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
   * @param s
   * @return
   */
  public static int lengthOfLongestSubstring(String s) {


    List<String> list =new ArrayList<>();


    List<Integer> list1 =new ArrayList<>();
    List<Integer> list2 =new ArrayList<>();

    for (String s1 : list) {

      int i = s.indexOf(s1);



      int i2 = s.lastIndexOf(s1);

      String substring = s.substring(i, i2);

      Set<String> strings =new HashSet<>();
      for (int ii = 0; i < substring.length(); i++) {
        char c = substring.charAt(ii);
        strings.add(String.valueOf(c));
      }

      if (strings.size() == substring.length()){
        list2.add(substring.length());
      }


      System.out.println(s1+"开始"+i+"----->结束"+i2+"----->中间"+substring);



      list1.add(i2-i);

    }

    String s2 = "";

    // while ()

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      list.add(String.valueOf(c));
    }

    List<Integer> collect = list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    List<Integer> collect1 = list2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    System.out.println(collect1.get(0));

    return collect.get(0);

  }

  /**
   * 回文数
   * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
   *
   * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
   *
   * 例如，121 是回文，而 123 不是。
   *
   *
   * 示例 1：
   *
   * 输入：x = 121
   * 输出：true
   * 示例 2：
   *
   * 输入：x = -121
   * 输出：false
   * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
   * 示例 3：
   *
   * 输入：x = 10
   * 输出：false
   * 解释：从右向左读, 为 01 。因此它不是一个回文数。
   * @param x
   * @return
   */
  public static boolean isPalindrome(int x) {

    String s = String.valueOf(x);
    int length = s.length();
    String substring = "";
    if (length % 2 !=0){
      substring = s.substring((length / 2) + 1, length);

    }else {
      substring = s.substring((length / 2) ,length);
    }
    StringBuilder sb = new StringBuilder(substring);
    String reversedStr = sb.reverse().toString();

    if (s.substring(0,length / 2).equals(reversedStr)){
      return true;
    }
    return false;

  }


  /**
   * 罗马数字转整数
   * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
   *
   * 字符          数值
   * I             1
   * V             5
   * X             10
   * L             50
   * C             100
   * D             500
   * M             1000
   * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
   *
   * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
   *
   * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
   * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
   * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
   * 给定一个罗马数字，将其转换成整数。
   * @param s
   * @return
   */
  public static int romanToInt(String s) {

    Map<String,Integer> map = new HashMap<>();
    map.put("I",1);
    map.put("V",5);
    map.put("X",10);
    map.put("L",50);
    map.put("C",100);
    map.put("D",500);
    map.put("M",1000);

    Map<String,Integer> map1 = new HashMap<>();
    map1.put("IV",4);
    map1.put("IX",9);
    map1.put("XL",40);
    map1.put("XC",90);
    map1.put("CD",400);
    map1.put("CM",900);



    List list = Arrays.asList("I","V","X","L","C","D","M");

    List list1 = Arrays.asList("IV","IX","XL","XC","CD","CM");

    return aa(map, map1, list, list1, s, 0);

  }

  private static int aa(Map<String,Integer> map,Map<String,Integer> map1,List list,List list1,String s,int sum){
    while (!"".equals(s)){
      String substring = "";
      if (s.length()>=2){
        substring = s.substring(0, 2);
      }
      String substring1 = "";
      if (s.length() >=1){
        substring1 = s.substring(0, 1);
      }
      if (list1.contains(substring)){
        sum += map1.get(substring);
        s = s.substring(2, s.length());
      }else {
        sum += map.get(substring1);
        s = s.substring(1, s.length());
      }
    }

    return sum;

  }


  /**
   * 最长公共前缀
   *
   * 编写一个函数来查找字符串数组中的最长公共前缀。
   *
   * 如果不存在公共前缀，返回空字符串 ""。
   *
   *
   *
   * 示例 1：
   *
   * 输入：strs = ["flower","flow","flight"]
   * 输出："fl"
   * 示例 2：
   *
   * 输入：strs = ["dog","racecar","car"]
   * 输出：""
   * 解释：输入不存在公共前缀。
   *
   * @param strs
   * @return
   */
  public static String longestCommonPrefix(String[] strs) {

    List<Integer> integers = new ArrayList<>();
    for (String str : strs) {
      integers.add(str.length());
    }
    Integer integer = integers.stream().sorted().collect(Collectors.toList()).get(0);

    for (int i = integer; i > 0; i--) {
      String check = strs[0].substring(0, i);
      Boolean f = true;
      for (String str : strs) {
        String substring = str.substring(0, i);
        if (!substring.equals(check)){
          f = false;
        }
      }
      if (f){
        return check;
      }
    }
    return "";
  }


  /**
   * 有效的括号
   *
   * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
   *
   * 有效字符串需满足：
   *
   * 左括号必须用相同类型的右括号闭合。
   * 左括号必须以正确的顺序闭合。
   * 每个右括号都有一个对应的相同类型的左括号。
   *
   *
   * 示例 1：
   *
   * 输入：s = "()"
   * 输出：true
   * 示例 2：
   *
   * 输入：s = "()[]{}"
   * 输出：true
   * 示例 3：
   *
   * 输入：s = "(]"
   * 输出：false
   * @param s
   * @return
   */
  public static boolean isValid(String s) {

    while (!"".equals(s)){
      int l = s.length();
      s = s.replace("()", "").replace("[]", "").replace("{}", "");
      if (s.length() == l) return "".equals(s);
    }
    return false;
  }

  public static boolean isValid1(String s) {
    Stack<Character> stack = new Stack<>();
    for(int i=0;i<s.length();i++){
      char c=s.charAt(i);
      if(c=='('||c=='['||c=='{'){stack.push(c);}
      else if(stack.isEmpty() || c==')' && stack.pop()!='(' || c==']' && stack.pop()!='['||c=='}'&& stack.pop()!='{'){return false;}
    }
    System.out.println(stack);
    return stack.isEmpty();
  }


  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    if (list1 == null && list2 == null) return null;

    int val = list1 == null ? Integer.MAX_VALUE : list1.val;
    int val1 = list2 == null ? Integer.MAX_VALUE :  list2.val;
    if (val>val1){
      list2 = list2.next;
    }else {
      list1 = list1.next;
    }

    return new ListNode(Math.min(val,val1) ,mergeTwoLists(list1,list2)) ;

  }


  public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
    // List<ListNode>list=new ArrayList<ListNode>();
    ListNode newlist=new ListNode(-1);
    ListNode temp=newlist;
    if(list1==null)
      return list2;
    if(list2==null)
      return list1;
    while(list1!=null&&list2!=null){
      if(list1.val<list2.val){
        temp.next=list1;
        list1=list1.next;
      }
      else{
        temp.next=list2;
        list2=list2.next;
      }
      temp=temp.next;
    }
    temp.next=list1==null?list2:list1;
    return newlist.next;

  }


  /**
   * 删除有序数组中的重复项
   *
   * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
   *
   * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
   *
   * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
   * 返回 k 。
   * 判题标准:
   *
   * 系统会用下面的代码来测试你的题解:
   *
   * int[] nums = [...]; // 输入数组
   * int[] expectedNums = [...]; // 长度正确的期望答案
   *
   * int k = removeDuplicates(nums); // 调用
   *
   * assert k == expectedNums.length;
   * for (int i = 0; i < k; i++) {
   *     assert nums[i] == expectedNums[i];
   * }
   * 如果所有断言都通过，那么您的题解将被 通过。
   * @param nums
   * @return
   */
  public static int removeDuplicates(int[] nums) {

    int leftIndex = -1;
    int rightIndex = 0;

    int length = 0;


    while (rightIndex < nums.length){

      if (leftIndex >= 0){
        if (nums[leftIndex] != nums[rightIndex]){
          nums[length] = nums[rightIndex];
          length ++;
        }
      }else {
        length ++;
      }

      leftIndex++;
      rightIndex++;

    }

    for (int num : nums) {
      System.out.println(num);
    }

    System.out.println("========================");


    return length;

  }

  /**
   * 移除元素
   *
   *
   * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
   *
   * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
   *
   * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
   *
   *
   *
   * 说明:
   *
   * 为什么返回数值是整数，但输出的答案是数组呢?
   *
   * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
   *
   * 你可以想象内部操作如下:
   *
   * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
   * int len = removeElement(nums, val);
   *
   * // 在函数里修改输入数组对于调用者是可见的。
   * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
   * for (int i = 0; i < len; i++) {
   *     print(nums[i]);
   * }
   *
   *
   * 示例 1：
   *
   * 输入：nums = [3,2,2,3], val = 3
   * 输出：2, nums = [2,2]
   * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
   * 示例 2：
   *
   * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
   * 输出：5, nums = [0,1,3,0,4]
   * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
   *
   * @param nums
   * @param val
   * @return
   */
  public int removeElement(int[] nums, int val) {

    int leftIndex = 0;

    int length = 0;

    while (leftIndex <nums.length){

      if (val == nums[leftIndex]){
        //如果相等，需要将指针往下移
        leftIndex++;
      }else {
        nums[length] = nums[leftIndex];

        leftIndex++;
        length++;
      }

    }

    return length;


  }


  /**
   * 找出字符串中第一个匹配项的下标
   *
   * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
   *
   *
   *
   * 示例 1：
   *
   * 输入：haystack = "sadbutsad", needle = "sad"
   * 输出：0
   * 解释："sad" 在下标 0 和 6 处匹配。
   * 第一个匹配项的下标是 0 ，所以返回 0 。
   * 示例 2：
   *
   * 输入：haystack = "leetcode", needle = "leeto"
   * 输出：-1
   * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
   *
   *
   * 提示：
   *
   * 1 <= haystack.length, needle.length <= 104
   * haystack 和 needle 仅由小写英文字符组成
   * @param haystack
   * @param needle
   * @return
   */
  public static int strStr(String haystack, String needle) {

    // haystack.indexOf(needle);

    //左指针
    int index =0;
    //右指针
    int index1 =0;

    char[] chars = haystack.toCharArray();

    char[] chars1 = needle.toCharArray();

    if (haystack.equals(needle)) return 0;

    boolean a = true;

    while (a){

      if (index >= chars.length)  return -1;



      if (chars[index1 + index] == chars1[index1]){

        index1++;



        if ( index1 == chars1.length){
          return index;
        }

        if (index > chars.length - chars1.length) {
          return -1;
        }

      }else {
        index++;
        index1 =0;
      }

    }


    return index;

  }

  /**
   * 合并两个有序数组
   *
   * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
   *
   * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
   *
   * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
   *
   *
   *
   * 示例 1：
   *
   * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
   * 输出：[1,2,2,3,5,6]
   * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
   * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
   * 示例 2：
   *
   * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
   * 输出：[1]
   * 解释：需要合并 [1] 和 [] 。
   * 合并结果是 [1] 。
   * 示例 3：
   *
   * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
   * 输出：[1]
   * 解释：需要合并的数组是 [] 和 [1] 。
   * 合并结果是 [1] 。
   * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
   *
   * 提示：
   *
   * nums1.length == m + n
   * nums2.length == n
   * 0 <= m, n <= 200
   * 1 <= m + n <= 200
   * -109 <= nums1[i], nums2[j] <= 109
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public static void merge(int[] nums1, int m, int[] nums2, int n) {

    if (m==0 && n == 0){
      nums1 = new int[0];
    }else if (m==0){
      for (int i = 0; i < n; i++) {
        nums1[i] = nums2[i];
      }
    }else if (n == 0){
      int[] a = new int[m];
      for (int i = 0; i < m; i++) {
        a[i] = nums1[i];
      }
      nums1 = a;
    }else {

      int index1 = 0;
      int index2 = 0;
      int index3 = 0;

      int[] a = new int[m+n];

      while (index3 < m+n){

        int i1 = index1 >= m ? Integer.MAX_VALUE : nums1[index1];
        int i2 = index2 >= n ? Integer.MAX_VALUE : nums2[index2];
        if (i1>i2){
          a[index3] = i2;
          if (index2<n){
            index2++;
          }else {
            index1++;
          }

        }else {
          a[index3] = i1;
          if (index1<m){
            index1++;
          }else {
            index2++;
          }

        }
        index3++;

      }

      for (int i = 0; i < a.length; i++) {
        nums1[i] = a[i];
      }

    }

  }


  /**
   * 爬楼梯
   *
   * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
   *
   * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
   *
   *
   *
   * 示例 1：
   *
   * 输入：n = 2
   * 输出：2
   * 解释：有两种方法可以爬到楼顶。
   * 1. 1 阶 + 1 阶
   * 2. 2 阶
   * 示例 2：
   *
   * 输入：n = 3
   * 输出：3
   * 解释：有三种方法可以爬到楼顶。
   * 1. 1 阶 + 1 阶 + 1 阶
   * 2. 1 阶 + 2 阶
   * 3. 2 阶 + 1 阶
   *
   *
   * 提示：
   *
   * 1 <= n <= 45
   *
   * @param n
   * @return
   */
  public int climbStairs(int n) {




    return 2;

  }

  /**
   * 斐波那契数
   *
   * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
   *
   * F(0) = 0，F(1) = 1
   * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
   * 给定 n ，请计算 F(n) 。
   *
   * 答案需要取模 1e9+7(1000000007) ，如计算初始结果为：1000000008，请返回 1。
   *
   *
   *
   * 示例 1：
   *
   * 输入：n = 2
   * 输出：1
   * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
   * 示例 2：
   *
   * 输入：n = 3
   * 输出：2
   * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
   * 示例 3：
   *
   * 输入：n = 4
   * 输出：3
   * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
   *
   *
   * 提示：
   *
   * 0 <= n <= 100
   *
   * @param n
   * @return
   */
  public static int fib(int n) {


    List<Integer> integers = new ArrayList<>();

    integers.add(1);
    integers.add(1);

    if (n==0){
      return 0;
    }

    if (n==1){
      return 1;
    }


    int i = 2;

    int a =0;
    int b =0;

    while (i <= n){
      a = integers.get(i - 1);
      b = integers.get(i - 2);
      int i1 = a + b;
      i1 %= 1000000007;
      integers.add(i1);
      i++;

    }


    return integers.get(n - 1);

  }


  /**
   * 杨辉三角
   *
   * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
   *
   * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
   *
   *
   *
   *
   *
   * 示例 1:
   *
   * 输入: numRows = 5
   * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
   * 示例 2:
   *
   * 输入: numRows = 1
   * 输出: [[1]]
   *
   *
   * 提示:
   *
   * 1 <= numRows <= 30
   *
   * @param numRows
   * @return
   */

  public static List<List<Integer>> generate(int numRows) {

    List<List<Integer>> lists = new ArrayList<>();


    List<Integer> list = new ArrayList<>();
    list.add(1);

    List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(1);

    lists.add(list);

    if(numRows == 1) return lists;

    lists.add(list1);

    if (numRows == 2)  return lists;




    int i = 3;
    while (i <= numRows){
      List<Integer> list3 = new ArrayList<>();
      List<Integer> list2 = lists.get(i - 2);
      list3.add(list2.get(0));

      for (int i1 = 0; i1 < list2.size()-1; i1++) {
        list3.add(list2.get(i1)+list2.get(i1+1));
      }

      list3.add(list2.get(list2.size()-1));



      lists.add(list3);

      i++;

    }


    System.out.println(lists);

    return lists;

  }


  /**
   * 杨辉三角 II
   *
   *
   * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
   *
   * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
   *
   *
   *
   *
   *
   * 示例 1:
   *
   * 输入: rowIndex = 3
   * 输出: [1,3,3,1]
   * 示例 2:
   *
   * 输入: rowIndex = 0
   * 输出: [1]
   * 示例 3:
   *
   * 输入: rowIndex = 1
   * 输出: [1,1]
   *
   *
   * 提示:
   *
   * 0 <= rowIndex <= 33
   *
   * @param rowIndex
   * @return
   */
  public static List<Integer> getRow(int rowIndex) {


    List<Integer> list = new ArrayList<>();
    list.add(1);

    if(rowIndex == 0) return list;

    List<Integer> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(1);

    if(rowIndex == 1) return list2;



    int i = 3;
    while (i <= rowIndex+1){
      List<Integer> list3 = new ArrayList<>();
      list3.add(list2.get(0));

      for (int i1 = 0; i1 < list2.size()-1; i1++) {
        list3.add(list2.get(i1)+list2.get(i1+1));
      }

      list3.add(list2.get(list2.size()-1));

      list2 = list3;

      if (i ==rowIndex+1) {

        return list3;
      }

      i++;

    }


    return list2;

  }


  /**
   * 买卖股票的最佳时机
   *
   *
   * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
   *
   * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
   *
   * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
   *
   *
   *
   * 示例 1：
   *
   * 输入：[7,1,5,3,6,4]
   * 输出：5
   * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
   *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
   * 示例 2：
   *
   * 输入：prices = [7,6,4,3,1]
   * 输出：0
   * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
   *
   *
   * 提示：
   *
   * 1 <= prices.length <= 10^5
   * 0 <= prices[i] <= 10^4
   *
   * @param prices
   * @return
   */
  public static int maxProfit(int[] prices) {

    //最大收益
    int max = 0;

    int max1 = Arrays.stream(prices).max().getAsInt();

    int min = Arrays.stream(prices).min().getAsInt();

    List<Integer> collect = Arrays.stream(prices).boxed().collect(Collectors.toList());



    while (collect.size()!= 0){

      int i = collect.indexOf(max1);

      if (i==0){
        collect.subList(0, 1).clear();
      }else if (i==-1){
        if (max<0) return 0;
        return max;
      }else {
        List<Integer> list = collect.subList(0, i);

        List<Integer> collect1 = list.stream().sorted().collect(Collectors.toList());

        max = Math.max(max1-collect1.get(0),max);

        collect.subList(0, i+1).clear();

      }

    }

    if (max<0) return 0;
    return max;

  }

  /**
   * 字符串中的第一个唯一字符
   *
   * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
   *
   *
   *
   * 示例 1：
   *
   * 输入: s = "leetcode"
   * 输出: 0
   * 示例 2:
   *
   * 输入: s = "loveleetcode"
   * 输出: 2
   * 示例 3:
   *
   * 输入: s = "aabb"
   * 输出: -1
   *
   *
   * 提示:
   *
   * 1 <= s.length <= 105
   * s 只包含小写字母
   * @param s
   * @return
   */
  public static int firstUniqChar(String s) {
    char[] chars = s.toCharArray();

    Queue<Character> linkedList = new LinkedList();
    Queue<Character> linkedList1 = new LinkedList();
    List<Character> list = new ArrayList<>();

    for (char aChar : chars) {
      linkedList.add(aChar);
      list.add(aChar);
    }

    int index = 0;


    boolean contains = false;

    while (linkedList.size() != 0){
      Character poll = linkedList.poll();

      contains = linkedList.contains(poll);

      if (!contains){

        return list.indexOf(poll);
      }

      int size = linkedList.size();

      for (int i = 0; i < size; i++) {
        Character poll1 = linkedList.poll();
        if (!poll.equals(poll1)){
          linkedList1.add(poll1);
        }


      }

      linkedList = linkedList1;

      linkedList1 = new LinkedList();


    }

    if (linkedList.size() == 0) return -1;

    return index;

  }


  public static int countStudents(int[] students, int[] sandwiches) {

    // students  队列
    // sandwiches  栈
    List<Integer> collect = Arrays.stream(students).boxed().collect(Collectors.toList());
    Queue<Integer> queue =new LinkedList(collect);

    Stack<Integer> stack = new Stack<>();


    for (int i =  sandwiches.length -1; i >=0; i--) {
      stack.push(sandwiches[i]);
    }

    while (queue.size() >0 && (queue.contains(stack.peek()))){

      if (queue.peek().equals(stack.peek())){
        queue.poll();
        stack.pop();
      }else {
        Integer poll = queue.poll();
        queue.add(poll);
      }

    }

    return queue.size();

  }

  /**
   * 买票需要的时间
   *
   * 有 n 个人前来排队买票，其中第 0 人站在队伍 最前方 ，第 (n - 1) 人站在队伍 最后方 。
   *
   * 给你一个下标从 0 开始的整数数组 tickets ，数组长度为 n ，其中第 i 人想要购买的票数为 tickets[i] 。
   *
   * 每个人买票都需要用掉 恰好 1 秒 。一个人 一次只能买一张票 ，如果需要购买更多票，他必须走到  队尾 重新排队（瞬间 发生，不计时间）。如果一个人没有剩下需要买的票，那他将会 离开 队伍。
   *
   * 返回位于位置 k（下标从 0 开始）的人完成买票需要的时间（以秒为单位）。
   *
   *
   *
   * 示例 1：
   *
   * 输入：tickets = [2,3,2], k = 2
   * 输出：6
   * 解释：
   * - 第一轮，队伍中的每个人都买到一张票，队伍变为 [1, 2, 1] 。
   * - 第二轮，队伍中的每个都又都买到一张票，队伍变为 [0, 1, 0] 。
   * 位置 2 的人成功买到 2 张票，用掉 3 + 3 = 6 秒。
   * 示例 2：
   *
   * 输入：tickets = [5,1,1,1], k = 0
   * 输出：8
   * 解释：
   * - 第一轮，队伍中的每个人都买到一张票，队伍变为 [4, 0, 0, 0] 。
   * - 接下来的 4 轮，只有位置 0 的人在买票。
   * 位置 0 的人成功买到 5 张票，用掉 4 + 1 + 1 + 1 + 1 = 8 秒
   * @param tickets
   * @param k
   * @return
   */
  public int timeRequiredToBuy(int[] tickets, int k) {
    return 1;

  }





  public  static void main(String[] args) {

    int[] student = new int[]{1,1,0,0};
    int[] sandwiches = new int[]{0,1,0,1};

    int i = countStudents(student,sandwiches);
    System.out.println(i);


    // int aabb = firstUniqChar("loveleetcode");
    // System.out.println(aabb);
    //
    // System.out.println(maxProfit(new int[]{6,7,1,5,3,6,4}));


    // System.out.println(getRow(3));
     // generate(45);


    // fib(45);


    // merge(new int[]{1,2,3,0,0,0},
    //   3,
    //   new int[]{2,5,6},
    //   3);

    // int i = strStr("mississippi", "pi");
    // System.out.println(i);

    // int[] a = new int[]{0,0,1,1,1,2,2,3,3,4};
    //
    //
    // System.out.println(removeDuplicates(a));
    //
    // System.out.println("========================");
    // for (int num : a) {
    //   System.out.println(num);
    // }


    // [2,4,3]
    // ListNode listNode = new ListNode();
    // listNode.val = 1;
    // listNode.next = new ListNode(2);
    // listNode.next.next =  new ListNode(4);
    //
    // // [5,6,4]
    // ListNode listNode2 = new ListNode();
    // listNode2.val = 1;
    // listNode2.next = new ListNode(3);
    // listNode2.next.next =  new ListNode(4);
    //
    // ListNode listNode1 = mergeTwoLists1(listNode, listNode2);
    // System.out.println(listNode1);



    // Stack<Integer> stack = new Stack<>();
    // stack.push(1);
    // stack.push(2);
    // stack.push(5);
    // stack.push(7);
    // for (Integer integer : stack) {
    //   System.out.println(integer);
    // }
    // Integer pop = stack.pop();
    //
    // System.out.println(stack);




    // boolean valid = isValid1("([])");
    // System.out.println(valid);

    // String[] strs =  new String[]{"flower","flow","flight"};
    // String s = longestCommonPrefix(strs);
    // System.out.println(s);


    // int[] ints = twoSum(new int[]{3, 3}, 6);
    // for (int anInt : ints) {
    //   System.out.println(anInt);
    // }

    // [2,4,3]
    // ListNode listNode = new ListNode();
    // listNode.val = 2;
    // listNode.next = new ListNode(4);
    // listNode.next.next =  new ListNode(3);
    //
    // // [5,6,4]
    // ListNode listNode2 = new ListNode();
    // listNode2.val = 5;
    // listNode2.next = new ListNode(6);
    // listNode2.next.next =  new ListNode(4);
    //
    // ListNode listNode1 = addTwoNumbers(listNode, listNode2);
    // System.out.println(listNode1);


    // int abcabcd = lengthOfLongestSubstring("abacabacd");
    // System.out.println(abcabcd);

    // boolean palindrome = isPalindrome(11);
    // System.out.println(palindrome);

    // int mcmxciv = romanToInt("LVIII");
    // System.out.println(mcmxciv);

  }
}
