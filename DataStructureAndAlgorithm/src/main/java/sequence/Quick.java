package sequence;
/*
* Speedy sort,bubble sort updating version
* @param nums sorted array
* */
public class Quick {

    private final int[] nums;
    public int[] getNums() {
        return nums;
    }

    public Quick(int[] nums){
        this.nums = nums;
    }

    public void algorithm(int left, int right){ //5,35,1,2;5 2 35 1
        //split data and recursion
        int l = left;
        int r = right;
        int refVal = nums[(r+l)/2];
        int temp;
        while(l<r){
            while(nums[l]<refVal){
                l++;
            }
            while(nums[r]>refVal){
                r--;
            }
            if(l>=r){
                break;
            }
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            if(nums[l]==refVal){
                r--;
            }
            if(nums[r]==refVal){
                l++;
            }
        }
        //???Why will cause stack of flow when deleting this code
        //ANSWER:Will cause two separate part using the same number
        if(l==r){
            l++;
            r--;
        }
        //recursion
        if(left<r){
            algorithm(left, r);
        }
        if(right>l){
            algorithm(l, right);
        }
    }
}
