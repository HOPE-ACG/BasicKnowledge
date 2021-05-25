package linked;

public class DoubleNode {
    /**
     * @para next Point to the next node
     * @para pre Point to the previous node
     */
    public int num;
    public String name;
    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode(int num, String name){
        this.num = num;
        this.name = name;
    }

    public String toString(){
        return "linked.Node[num="+num+",name="+name+"],";
    }
}
