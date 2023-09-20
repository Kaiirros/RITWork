package Practice;

public class scratchcode {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n+m; i++){
            
            for (int y = 0; y < n; y++){
                if (nums1[i] < nums2[y]){
                    nums1[i] = nums2[y];
                    
                }
                
            }
            System.out.println(nums1[i]);            
        
    }

}

public static void main(String[] args) {
    int [] nums1 = {1,2,3,0,0,0};
    int[] nums2 = {2,5,6};
    int n = 3;
    int m = 3;    

    scratchcode scratchcode = new scratchcode();
    scratchcode.merge(nums1, m, nums2, n);
}
    

}
