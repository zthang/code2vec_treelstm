String next() {
    while (st == null || !st.hasMoreElements()) {
        st = new StringTokenizer(nextLine());
    }
    return st.nextToken();
}