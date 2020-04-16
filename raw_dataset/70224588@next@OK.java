String next() {
    while (st == null || !st.hasMoreTokens()) {
        st = new StringTokenizer(nextLine());
    }
    return st.nextToken();
}