long[] nextLongs(int count) {
    long[] res = new long[count];
    for (int i = 0; i < count; ++i) {
        res[i] = in.nextInt();
    }
    return res;
}