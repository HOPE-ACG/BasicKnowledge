package sequence;

/*
* Put selected minimum number in the front
* @para nums sorted array
* */
public class Selected {

    private final int[] nums;

    public Selected(int[] nums) {
        this.nums = nums;
    }

    public void algorithm(){
        //Two round circle
        int temp;
        int pos;
        for(int i=0;i<nums.length-1;i++){
            temp = nums[i];
            pos = i;
            for(int j=i+1;j<nums.length;j++){
                if(temp<nums[j]){
                    temp = nums[j];
                    pos = j;
                }
            }
            nums[pos] = nums[i];
            nums[i] = temp;
        }
       // System.out.println(Arrays.toString(nums));
    }
}
