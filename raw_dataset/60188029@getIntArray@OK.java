public int[] getIntArray(int size) throws Exception {
    int[] ar = new int[size];
    for (int i = 0; i < size; ++i) ar[i] = nextInt();
    return ar;
}