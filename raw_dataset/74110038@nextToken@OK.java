String nextToken() throws IOException {
    if (st == null || !st.hasMoreTokens())
        st = new StringTokenizer(in.readLine());
    return st.nextToken();
}