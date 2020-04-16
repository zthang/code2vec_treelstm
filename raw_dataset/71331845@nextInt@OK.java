public int nextInt() {
    if (st == null || !st.hasMoreTokens())
        try {
            readLine();
        } catch (Exception e) {
        }
    return Integer.parseInt(st.nextToken());
}