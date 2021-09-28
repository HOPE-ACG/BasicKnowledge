package pdd;

public class MergeKLists {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val) { this.val = val; }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) {
            return null;
        }
        return divideAndConquer(0, lists.length - 1, lists);
    }

    public ListNode divideAndConquer(int left, int right, ListNode[] lists) {

        if(left == right) {
            return lists[left];
        }
        int m = (left + right) / 2;
        ListNode nodel = divideAndConquer(left, m, lists);
        ListNode noder = divideAndConquer(m + 1, right, lists);
        if(nodel == null) {
            return noder;
        }
        if(noder == null) {
            return nodel;
        }
        ListNode node;
        if(nodel.val < noder.val) {
            node = nodel;
            nodel = nodel.next;
        }else {
            node = noder;
            noder = noder.next;
        }
        ListNode tmp = node;
        while(nodel != null && noder!= null) {
            if(nodel.val < noder.val) {
                tmp.next = nodel;
                nodel = nodel.next;
            }else {
                tmp.next = noder;
                noder = noder.next;
            }
            tmp = tmp.next;
        }
        if(nodel != null) {
            tmp.next = nodel;
        }
        if(noder != null) {
            tmp.next = noder;
        }
        return node;
    }
}
