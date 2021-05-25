package recursion;
/*
* Old but classical algorithm
* @para position Store queen's position in one-dimension array
* */
public class EightQueen {

    private final int[] position = new int[8];
    private int count = 0;

    public EightQueen() {}

    public void gameStart(){
        strategy(0);
        System.out.printf("SUM UP:%d", count);
    }

    public void strategy(int num){
        if(num==8){
            for(int val:position){
                System.out.printf("%d,", val);
            }
            System.out.println();
            count++;
            return;
        }
        for(int col=0;col<position.length;col++){
            if(num==0){
                position[num] = col;
                strategy(num+1);
            }else if(judge(num, col)) {
                position[num] = col;
                strategy(num+1);
            }
        }
    }

    public boolean judge(int num, int col){
        int rowGap;
        int colGap;
        for(int i=0;i<num;i++){
            if(position[i]==col){
                return false;
            }
            rowGap = num-i;
            colGap = Math.abs(col-position[i]);
            if(rowGap==colGap){
                return false;
            }
        }
        return true;
    }
}
