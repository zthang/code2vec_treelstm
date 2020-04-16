int getNext(int from, String s) {
    for (int i = 0; i < s.length(); i++) {
        int t = s.charAt(i) - '0';
        if (next[t][from] == -1) {
            next[t][from] = getNode(curH[from] + 1, from, t);
        }
        from = next[t][from];
    }
    return from;
}