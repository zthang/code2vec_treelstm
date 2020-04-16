public int nextInt() throws IOException {
    if (st == null || !st.hasMoreTokens())
        st = new StringTokenizer(br.readLine(), " ");
    return Integer.parseInt(st.nextToken());
}