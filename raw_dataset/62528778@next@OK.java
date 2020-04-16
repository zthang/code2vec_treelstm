String next() {
    while (root == null || !root.hasMoreTokens()) {
        try {
            root = new StringTokenizer(br.readLine());
        } catch (Exception r) {
            r.printStackTrace();
        }
    }
    return root.nextToken();
}