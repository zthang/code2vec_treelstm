static char findRoot(Map<Character, Character> letterToParent, char letter) {
    char root = letter;
    while (letterToParent.get(root) != null) {
        root = letterToParent.get(root);
    }
    char p = letter;
    while (p != root) {
        char next = letterToParent.get(p);
        letterToParent.put(p, root);
        p = next;
    }
    return root;
}