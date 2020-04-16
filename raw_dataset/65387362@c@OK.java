static char c() throws IOException {
    if (!st.hasMoreTokens())
        st = new StringTokenizer(br.readLine());
    return st.nextToken().charAt(0);
}