public static long[][] sort(long[][] array) {
    // Sort an array (immune to quicksort TLE)
    Random rgen = new Random();
    for (int i = 0; i < array.length; i++) {
        int randomPosition = rgen.nextInt(array.length);
        long[] temp = array[i];
        array[i] = array[randomPosition];
        array[randomPosition] = temp;
    }
    Arrays.sort(array, new Comparator<long[]>() {

        @Override
        public int compare(long[] arr1, long[] arr2) {
            if (arr1[0] < arr2[0])
                return -1;
            if (arr1[0] > arr2[0])
                return 1;
            return 0;
        }
    });
    return array;
}