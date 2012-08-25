public class Quicksort {

    private static int __partition(int[] nums, int beginIndex, int endIndex, int pivot) {
        
        while (beginIndex <= endIndex) {
            while (nums[beginIndex] < pivot) {
                beginIndex++;
            }

            while (nums[endIndex] > pivot) {
                endIndex--;
            }
            
            if (beginIndex < endIndex) {
                int temp = nums[beginIndex];
                nums[beginIndex] = nums[endIndex];
                nums[endIndex] = temp;
            } else {
                break;
            }
        }
        
        if (nums[beginIndex] == pivot) {
            return beginIndex;
        } else if (nums[endIndex] == pivot) {
            return endIndex;
        } else {
            return 0;
        }    
    }

    private static void __sort(int[] nums, int beginIndex, int endIndex) {

        if (endIndex - beginIndex <= 0) {
            return;
        } else {
            int pivot = nums[endIndex];
            int partition = __partition(nums, beginIndex, endIndex, pivot);
        
            __sort(nums, beginIndex, partition-1);
            __sort(nums, partition+1, endIndex);
        }
        
    }
    
    public static void quicksort(int[] nums) {
        __sort(nums, 0, nums.length-1);
    }
    
    public static void main(String[] args) {
        
        // Choose our random numbers
        int[] input = {7, 33, 65, 1, 43, 81, 66, 99, 3, 5};
        
        // Sort it (the action)
        Quicksort.quicksort(input);
        
        // See the results 
        for (int num : input) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        /*                                  
         * Output: 1 3 5 7 33 43 65 66 81 99        
        */                                  
    }
}