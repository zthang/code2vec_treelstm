public ArrayList<Integer> matchPattern(char[] text, char[] pattern) {
    char[] newString = new char[text.length + pattern.length + 1];
    int i = 0;
    for (char ch : pattern) {
        newString[i] = ch;
        i++;
    }
    newString[i] = '$';
    i++;
    for (char ch : text) {
        newString[i] = ch;
        i++;
    }
    ArrayList<Integer> result = new ArrayList<>();
    int[] Z = calculateZ(newString);
    for (i = 0; i < Z.length; i++) {
        if (Z[i] == pattern.length) {
            result.add(i - pattern.length - 1);
        }
    }
    return result;
}