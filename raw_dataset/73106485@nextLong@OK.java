public Long nextLong() {
    if (st == null || !st.hasMoreTokens())
        try {
            readLine();
        } catch (Exception e) {
        }
    return Long.parseLong(st.nextToken());
}