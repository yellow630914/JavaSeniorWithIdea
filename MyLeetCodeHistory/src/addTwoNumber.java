

public class addTwoNumber {
    //抄來的,超出能力範圍
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //先將要傳回的head標記
        ListNode head = new ListNode(0);
        //並將現在位置指向head
        ListNode cur = head;
        //carry是進位值
        int carry = 0;
        //當l1與l2不是null時代表還有值未錄入
        while(l1 != null || l2 != null) {
            //當l1,l2非null時取得val,否則反回0
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            //將l1,l2的值相加,再加上carry,前一位的進位值
            int sum = x + y + carry;

            //當sum大於等於10時取得進位值
            carry = sum / 10;
            //這是實際錄入的值
            sum = sum % 10;
            //將取得的值,製造現在指針的下一位
            cur.next = new ListNode(sum);

            //將指針指向下一個
            cur = cur.next;
            //如果l1,l2不是null也指向下一個
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        //當到最後一個時,有進位值,則多製造一個Node
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        //返回head標記的下一位
        return head.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }