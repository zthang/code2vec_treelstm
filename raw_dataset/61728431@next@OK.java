String next() {
    while (st == null || !st.hasMoreTokens()) {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    return st.nextToken();
}