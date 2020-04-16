void addEdge(int from, int to, String s) {
    for (int i = 0; i < s.length(); i++) {
        if (i + 1 == s.length()) {
            addOne(from, to, s.charAt(i) - '0');
        } else {
            int newV = vertices++;
            addOne(from, newV, s.charAt(i) - '0');
            from = newV;
        }
    }
}