String next() {
    while (!st.hasMoreTokens()) {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
        }
    }
    return st.nextToken();
}