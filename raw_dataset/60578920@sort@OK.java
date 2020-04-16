// Main function that sorts arr[l..r] using
// merge()
void sort(int[] arr, int l, int r) {
    if (l < r) {
        // Find the middle point
        int m = (l + r) / 2;
        // Sort first and second halves
        sort(arr, l, m);
        sort(arr, m + 1, r);
        // Merge the sorted halves
        merge(arr, l, m, r);
    }
}