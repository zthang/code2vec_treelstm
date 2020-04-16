String next() throws Exception {
    if (st.hasMoreTokens())
        return st.nextToken();
    st = new StringTokenizer(br.readLine());
    return next();
}