public static void sortbyColumn(int[][] arr, final int col) {
    Arrays.sort(arr, new Comparator<int[]>() {

        public int compare(final int[] entry1, final int[] entry2) {
            if (entry1[col] > entry2[col])
                return 1;
            if (entry1[col] < entry2[col])
                return -1;
            return 0;
        }
    });
}