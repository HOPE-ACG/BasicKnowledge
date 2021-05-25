package linked;

public class Node {
    /**
     * @para next Point to the next node
     */
    public int num;
    public String name;
    public Node next;

    public Node(int num, String name){
        this.num = num;
        this.name = name;
    }

    public String toString(){
        return "linked.Node[num="+num+",name="+name+"],";
    }
}

