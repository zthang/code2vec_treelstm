private static int findSetid(char c, List<Set<Character>> charsets, int[] setidOf) {
    if (setidOf[c - 'a'] > -1)
        return setidOf[c - 'a'];
    Set<Character> charset = new HashSet<>();
    charset.add(c);
    charsets.add(charset);
    setidOf[c - 'a'] = charsets.size() - 1;
    return charsets.size() - 1;
}