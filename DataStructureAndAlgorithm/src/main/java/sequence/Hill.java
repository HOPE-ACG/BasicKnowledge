package sequence;

/*
* Hill exchange method
* @para nums sorted array
* */
public class Hill {

    private final int[] nums;

    public Hill(int[] nums){
        this.nums = nums;
    }

    public void algorithm(){
        //variable step sorting
        int temp;
        for(int step=nums.length/2;step>=1;step/=2){
            for(int i=step;i<nums.length;i++){
                for(int j=i;j>=step;j-=step){
                    if(nums[j]<nums[j-step]){
                        temp = nums[j];
                        nums[j] = nums[j-step];
                        nums[j-step] = temp;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(nums));
    }

    public void algorithm_opt(){
        //variable step sorting(position-moving method)
        int temp;
        for(int step=nums.length/2;step>=1;step/=2){
            for(int i=step;i<nums.length;i++){
                int j = i;
                temp = nums[j];
                while(j>=step){
                    if(temp<nums[j-step]){
                        nums[j] = nums[j-step];
                    }else {
                        break;
                    }
                    j-=step;
                }
                nums[j] = temp;
            }
        }
        //System.out.println(Arrays.toString(nums));
    }
}
