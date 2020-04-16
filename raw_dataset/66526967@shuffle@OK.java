static void shuffle(int[] array) {
    Random rand = new Random();
    for (int i = 0; i < array.length; i++) {
        int x = rand.nextInt(array.length - i) + i;
        int temp = array[x];
        array[x] = array[i];
        array[i] = temp;
    }
}