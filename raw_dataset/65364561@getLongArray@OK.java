private static long[] getLongArray(int N, BufferedReader br) throws Exception {
    String s = br.readLine();
    String[] tokens = s.split(" ");
    long[] result = new long[N + 1];
    for (int i = 0; i < N; i++) {
        result[i + 1] = Long.parseLong(tokens[i]);
    }
    return result;
}