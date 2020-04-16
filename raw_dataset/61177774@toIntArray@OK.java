private static int[] toIntArray(String s) {
    int[] text = new int[s.length()];
    for (int i = 0; i < s.length(); i++) text[i] = s.charAt(i);
    return text;
}