public String next() {
    while (st == null || !st.hasMoreTokens()) {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
        }
    }
    return st.nextToken();
}