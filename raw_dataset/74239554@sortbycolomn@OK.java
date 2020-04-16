static void sortbycolomn(long[][] arr, int col) {
    Arrays.sort(arr, new Comparator<long[]>() {

        @Override
        public int compare(final long[] entry1, final long[] entry2) {
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
        }
    });
}