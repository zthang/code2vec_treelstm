public int[] nextIntArr(int n) throws IOException {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        if (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine(), " ");
        arr[i] = Integer.parseInt(st.nextToken());
    }
    return arr;
}