package sequence;

/*
* Make every element compare to other elements in n times circle
* @para nums sorted array
* */
public class Bubble {

    private final int[] nums;

    public Bubble(int[] nums) {
        this.nums = nums;
    }

    public void algorithm(){
        //Exclude having been sorted elements in every circle
        int temp;
        boolean flag = false;
        for(int i=1;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i;j++){
                if(nums[j]>nums[j+1]){
                    temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                    flag= true;
                }
            }
            //Remain elements is squential,so ending circle
            if(flag){
                flag = false;
            }else {
                break;
            }
        }
        //System.out.println(Arrays.toString(nums));
    }
}
