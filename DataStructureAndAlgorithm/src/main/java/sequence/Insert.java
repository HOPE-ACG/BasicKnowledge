package sequence;

/*
 * Put right elements to left in order
 * @param nums sorted array
 * */
public class Insert {

    private final int[] nums;

    public Insert(int[] nums){
        this.nums = nums;
    }

    public void algorithm(){
        //Intangible ordered and inordered table
        int temp;
        int pos;
        for(int i=1;i<nums.length;i++){
            temp = nums[i];
            pos = i-1;
            while(pos>=0 && temp<nums[pos]){
                nums[pos+1] = nums[pos];
                pos--;
            }
            nums[pos+1] = temp;
        }
        
        //System.out.println(Arrays.toString(nums));
    }
}
