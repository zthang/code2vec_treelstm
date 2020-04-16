String next() throws IOException {
    while (as == null || !as.hasMoreTokens()) {
        as = new StringTokenizer(in.readLine().trim());
    }
    return as.nextToken();
}