String next() throws IOException {
    if (!st.hasMoreTokens()) {
        st = new StringTokenizer(br.readLine());
    }
    return st.nextToken();
}