package domain;

/**
 * @author: qjTang
 * @Description:
 * @Date: Created in 15:47 2024/1/9
 */
public class ListNode {

  public int val;

  public  ListNode next;

  public ListNode() {}

  public  ListNode(int val) { this.val = val; }

  public  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
