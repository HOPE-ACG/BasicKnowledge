package sequence;

/*
* Divide-conquer strategy
* @param nums sorted array
* */
public class Merge {

    private final int[] nums;

    public Merge(int[] nums){
        this.nums = nums;
    }

    public void sort(){
        int[] temp = new int[nums.length];
        algorithm(0, nums.length-1, temp);
        //System.arraycopy(temp, 0, nums, 0, temp.length);
        //System.out.println(Arrays.toString(nums));
    }

    /*
     * First dividing array into smallest unit, and then merge sorted array
     * @param left far left index of array
     * @param mid middle index
     * */
    public void algorithm(int left, int right, int[] temp){
        if(left<right){
            int mid = (left + right) / 2;
            //left recursion
            algorithm(left, mid, temp);
            //right recursion
            algorithm(mid +1, right, temp);
            //merge two sequential array
            algorithm_merge(left, mid, right, temp);
        }
    }

    /*
    * Merging divided array by order
    * */
    public void algorithm_merge(int left, int mid, int right, int[] temp){
        int l = left;
        int m = mid+1;
        int index = 0;
        while(l<=mid && m<=right){
            if(nums[l]<=nums[m]){
                temp[index] = nums[l];
                l++;
            }else {
                temp[index] = nums[m];
                m++;
            }
            index++;
        }
        //Insert remain elements to temporary array
        while(l<=mid){
            temp[index++] = nums[l];
            l++;
        }
        while(m<=right){
            temp[index++] = nums[m];
            m++;
        }
        //Why need to copy now???
        //ANSWER:In every round only copying sorted nums array to temp array make temp array later in order
        //Copy temp array to nums array
        index = 0;
        while(left<=right){
            nums[left] = temp[index];
            index++;
            left++;
        }
    }
}
