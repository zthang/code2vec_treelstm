public String next() {
    if (st == null || !st.hasMoreTokens())
        try {
            readLine();
        } catch (Exception e) {
        }
    return st.nextToken();
}