public static int[][] shuffle(int[][] array) {
    Random rgen = new Random();
    for (int i = 0; i < array.length; i++) {
        int randomPosition = rgen.nextInt(array.length);
        int[] temp = array[i];
        array[i] = array[randomPosition];
        array[randomPosition] = temp;
    }
    return array;
}