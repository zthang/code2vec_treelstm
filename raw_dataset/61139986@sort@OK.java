public static int[][] sort(int[][] array) {
    // Sort an array (immune to quicksort TLE)
    Random rgen = new Random();
    for (int i = 0; i < array.length; i++) {
        int randomPosition = rgen.nextInt(array.length);
        int[] temp = array[i];
        array[i] = array[randomPosition];
        array[randomPosition] = temp;
    }
    Arrays.sort(array, new Comparator<int[]>() {

        @Override
        public int compare(int[] arr1, int[] arr2) {
            // Descending Order
            return arr2[0] - arr1[0];
        }
    });
    return array;
}