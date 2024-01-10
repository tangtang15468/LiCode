import com.sun.prism.impl.BufferUtil;
import com.sun.xml.internal.ws.util.StringUtils;
import domain.ListNode;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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





  public  static void main(String[] args) {


    // [2,4,3]
    ListNode listNode = new ListNode();
    listNode.val = 1;
    listNode.next = new ListNode(2);
    listNode.next.next =  new ListNode(4);

    // [5,6,4]
    ListNode listNode2 = new ListNode();
    listNode2.val = 1;
    listNode2.next = new ListNode(3);
    listNode2.next.next =  new ListNode(4);

    ListNode listNode1 = mergeTwoLists1(listNode, listNode2);
    System.out.println(listNode1);



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
