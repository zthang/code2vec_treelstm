public String toString() {
    String s = letter + ": " + color + ";;; ";
    for (LetterNode ln : children) {
        s += ln.letter + ", ";
    }
    return s;
}