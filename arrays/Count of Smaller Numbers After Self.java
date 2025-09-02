class Solution {
    private int[] counts;   // This array will store the final result: counts[i] = number of smaller elements after nums[i].
    private int[] indexes;  // This array keeps track of the original positions of elements during sorting.

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        counts = new int[n];   // initially all 0
        indexes = new int[n];  // index mapping from sorted array to original positions

        for (int i = 0; i < n; i++) {
            indexes[i] = i;    // at the start, element i is at index i
        }

        mergeSort(nums, 0, n - 1);  // run modified merge sort

        List<Integer> result = new ArrayList<>();
        for (int c : counts) result.add(c);  // convert counts[] into a List<Integer>
        return result;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) return;              // base case: single element
        int mid = low + (high - low) / 2;     // divide step
        mergeSort(nums, low, mid);            // sort left half
        mergeSort(nums, mid + 1, high);       // sort right half
        merge(nums, low, mid, high);          // merge two halves
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int i = low;        // pointer for left half
        int j = mid + 1;    // pointer for right half
        int rightCount = 0; // how many right-half elements are smaller than left-half elements seen so far

        List<Integer> newIdx = new ArrayList<>(); // temporary array for merged indices
        List<Integer> newVals = new ArrayList<>(); // temporary array for merged values

        // Merge both halves while counting
        while (i <= mid && j <= high) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                // nums[j] is smaller than nums[i], so it comes first in sorted order
                newIdx.add(indexes[j]);
                newVals.add(nums[indexes[j]]);
                rightCount++;   // every left element after i will have one more smaller element on its right
                j++;
            } else {
                // nums[i] is smaller or equal, so place it in sorted array
                counts[indexes[i]] += rightCount;  // add how many right elements were smaller than nums[i]
                newIdx.add(indexes[i]);
                newVals.add(nums[indexes[i]]);
                i++;
            }
        }

        // If any left elements remain
        while (i <= mid) {
            counts[indexes[i]] += rightCount;  // all smaller right-side elements counted
            newIdx.add(indexes[i]);
            newVals.add(nums[indexes[i]]);
            i++;
        }

        // If any right elements remain
        while (j <= high) {
            newIdx.add(indexes[j]);
            newVals.add(nums[indexes[j]]);
            j++;
        }

        // Copy merged results back into indexes[] and nums[]
        for (int k = 0; k < newIdx.size(); k++) {
            indexes[low + k] = newIdx.get(k);          // update index mapping
            nums[indexes[low + k]] = newVals.get(k);   // update nums at the right position
        }
    }
}
