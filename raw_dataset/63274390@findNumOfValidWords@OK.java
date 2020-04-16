public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    List<Integer> ret = new ArrayList<Integer>();
    HashMap<Integer, Integer>[] mp = new HashMap[26];
    for (int i = 0; i < 26; i++) mp[i] = new HashMap<Integer, Integer>();
    // Dumper.print(enc(p));
    for (int i = 0; i < words.length; i++) {
        int v = enc(words[i]);
        for (int j = 0; j < words[i].length(); j++) {
            mp[words[i].charAt(j) - 'a'].put(v, 1);
        }
    }
    for (int i = 0; i < puzzles.length; i++) {
        int n = puzzles[i].length();
        int t = 0;
        for (int j = 1; j < 1 << (n - 1); j++) {
            int v = 0;
            for (int k = 0; k < 6; k++) {
                if ((j & (1 << k)) != 0) {
                    v |= (1 << (puzzles[i].charAt(k) - 'a'));
                }
            }
            v |= (1 << (puzzles[i].charAt(0) - 'a'));
        // t+=search(v,mp[puzzles[i].charAt(0)-'a']);
        }
        ret.add(t);
    }
    return ret;
}