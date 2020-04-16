public static void shuffle(int[][] ar) {
    Random rd = new Random(new Random().nextInt());
    for (int i = 0; i < ar.length; i++) {
        int index = rd.nextInt(ar.length);
        int[] temp = ar[i];
        ar[i] = ar[index];
        ar[index] = temp;
    }
}