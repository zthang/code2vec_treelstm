public static void sortbyColumn(int[][] arr, int col) {
    // Using built-in sort function Arrays.sort
    Arrays.sort(arr, new Comparator<int[]>() {

        @Override
        public // Compare values according to columns
        int compare(final int[] entry1, final int[] entry2) {
            // the '>' Operator
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
        }
    });
// End of function call sort().
}