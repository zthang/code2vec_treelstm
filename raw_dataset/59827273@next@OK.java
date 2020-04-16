String next() throws IOException {
    if (st == null || !st.hasMoreTokens())
        st = new StringTokenizer(br.readLine());
    return st.nextToken();
}