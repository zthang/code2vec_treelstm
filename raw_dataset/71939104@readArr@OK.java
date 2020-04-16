public static int[] readArr(int N, BufferedReader infile, StringTokenizer st) throws Exception {
    int[] arr = new int[N];
    st = new StringTokenizer(infile.readLine());
    for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
    return arr;
}