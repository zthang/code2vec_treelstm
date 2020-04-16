public double nextDouble() {
    if (st == null || !st.hasMoreTokens())
        try {
            readLine();
        } catch (Exception e) {
        }
    return Double.parseDouble(st.nextToken());
}