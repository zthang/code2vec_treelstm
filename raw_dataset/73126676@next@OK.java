String next() {
    while (root == null || !root.hasMoreTokens()) {
        try {
            root = new StringTokenizer(br.readLine());
        } catch (Exception addd) {
            addd.printStackTrace();
        }
    }
    return root.nextToken();
}