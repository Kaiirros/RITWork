package Practice;

public class scratchcode {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){

            for (int j = 0; j < nums.length; j++){

                if (nums[i] + nums[j] == target){
                    int[] returnInt = {i, j};
                return returnInt;

                }
                
            }
        }
        return null;
        
    }
    

}
