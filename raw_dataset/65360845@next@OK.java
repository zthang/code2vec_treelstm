public String next() throws IOException {
    if (st.hasMoreTokens())
        return st.nextToken();
    else
        st = new StringTokenizer(br.readLine());
    return next();
}