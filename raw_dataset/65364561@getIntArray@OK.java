private static int[] getIntArray(int N, BufferedReader br) throws Exception {
    String s = br.readLine();
    String[] tokens = s.split(" ");
    int[] result = new int[N];
    for (int i = 0; i < N; i++) {
        result[i] = Integer.parseInt(tokens[i]);
    }
    return result;
}