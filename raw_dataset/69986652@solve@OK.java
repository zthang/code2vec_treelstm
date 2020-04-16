static int solve(String[] s) {
    Map<Character, Character> letterToParent = new HashMap<>();
    for (String si : s) {
        for (char letter : si.toCharArray()) {
            if (!letterToParent.containsKey(letter)) {
                letterToParent.put(letter, null);
            }
        }
    }
    for (String si : s) {
        for (int i = 0; i < si.length() - 1; ++i) {
            char root1 = findRoot(letterToParent, si.charAt(i));
            char root2 = findRoot(letterToParent, si.charAt(i + 1));
            if (root1 != root2) {
                letterToParent.put(root2, root1);
            }
        }
    }
    return (int) letterToParent.values().stream().filter(parent -> parent == null).count();
}