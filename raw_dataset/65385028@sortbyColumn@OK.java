public static void sortbyColumn(int[][] arr, int col) {
    Arrays.sort(arr, new Comparator<int[]>() {

        public int compare(int[] o1, int[] o2) {
            return (Integer.valueOf(o1[col]).compareTo(o2[col]));
        }
    });
}