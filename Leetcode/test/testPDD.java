import org.junit.Test;
import pdd.LRUCache;
import pdd.MergeKLists;
import pdd.ReverseKGroup;

public class testPDD {

    @Test
    public void testLRUCache() {

        LRUCache lruCache = new LRUCache(2);
        int i = lruCache.get(2);
        lruCache.put(1, 3);
        System.out.println(i);
    }


    @Test
    public void testReverseKGroup() {

        ReverseKGroup.ListNode node5 = new ReverseKGroup.ListNode(5);
        ReverseKGroup.ListNode node4 = new ReverseKGroup.ListNode(4, node5);
        ReverseKGroup.ListNode node3 = new ReverseKGroup.ListNode(3, node4);
        ReverseKGroup.ListNode node2 = new ReverseKGroup.ListNode(2, node3);
        ReverseKGroup.ListNode node1 = new ReverseKGroup.ListNode(1, node2);

        ReverseKGroup.ListNode res = new ReverseKGroup().reverseKGroup(node1, 2);
        System.out.println(res);
    }

    @Test
    public void testMergeKLists() {

        MergeKLists.ListNode[] lists = new MergeKLists.ListNode[1];
        MergeKLists.ListNode node1 = new MergeKLists.ListNode(5);
        MergeKLists.ListNode node2 = new MergeKLists.ListNode(10);
        MergeKLists.ListNode node3 = new MergeKLists.ListNode(2);
        node1.next = node2;
        node2.next = node3;
        lists[0] = node1;

        MergeKLists.ListNode node = new MergeKLists().mergeKLists(lists);
        while(node != null) {
            System.out.printf("%d\t", node.val);
            node = node.next;
        }
    }
}
