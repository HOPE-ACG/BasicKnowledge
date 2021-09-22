package pdd;

public class ReverseKGroup {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        int count = 0;
        ListNode result = head;
        ListNode tmp = head;
        ListNode[] tmpArr = new ListNode[k];
        ListNode connection = null;
        while(tmp != null) {
            if(count < k) tmpArr[count++] = tmp;
            if(count == k) {
                if (result == head) result = tmpArr[k - 1];
                ListNode next = tmpArr[k - 1].next;
                for (int i = k - 1; i > 0; i--) {
                    tmpArr[i].next = tmpArr[i - 1];
                }
                if (connection != null) {
                    connection.next = tmpArr[k - 1];
                }
                connection = tmpArr[0];
                tmpArr[0].next = next;
                count = 0;
                tmp = tmpArr[0];
            }
            tmp = tmp.next;
        }
        return result;
    }
}
