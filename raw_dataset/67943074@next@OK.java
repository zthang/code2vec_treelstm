String next() {
    if (st.hasMoreTokens())
        return st.nextToken();
    try {
        st = new StringTokenizer(br.readLine());
    } catch (Exception e) {
    }
    return next();
}