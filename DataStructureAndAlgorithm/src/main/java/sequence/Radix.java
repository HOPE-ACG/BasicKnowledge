package sequence;

/*
 * Distribution strategy,called bucket method,steadily sort
 * @param nums sorted array
 * */
public class Radix {

    private final int[] nums;

    public Radix(int[] nums) {
        this.nums = nums;
    }

    /*
    * Using two-dimension array to represent bucket with serial number
    * @param bucket Saving elements of nums array in order
    * @param record Recording elements' number of every bucket
    * */
    public void algorithm(){
        int[][] bucket = new int[10][nums.length];
        int max = maxValue();
        for(int i=0;i<max;i++){
            int[] record = new int[10];
            //Iterating nums array and putting elements in order into bucket array
            for(int num:nums){
                int digit = ((num/(int)(Math.pow(10,i)))%10);
                bucket[digit][record[digit]] = num;
                record[digit]++;
            }
            //Iteration bucket array and putting elements in order into nums array
            int index = 0;
            for(int rec=0;rec<bucket.length;rec++){
                if(record[rec]!=0){
                    for(int j=0;j<record[rec];j++){
                        nums[index] = bucket[rec][j];
                        index++;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(nums));
    }

    //Getting max value in nums array
    private int maxValue(){
        int max = (""+nums[0]).length();
        String temp;
        for(int i:nums){
            temp = ""+i;
            if(max< temp.length()){
                max = temp.length();
            }
        }
        return max;
    }
}
