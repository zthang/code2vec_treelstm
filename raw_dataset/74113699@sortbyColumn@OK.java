public static void sortbyColumn(int[][] arr, int col) {
    Arrays.sort(arr, new Comparator<int[]>() {

        @Override
        public int compare(final int[] entry1, final int[] entry2) {
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
        }
    });
}