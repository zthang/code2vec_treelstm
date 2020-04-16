private static boolean equivalent(int[] tmp, String word) {
    char[] myword = word.toCharArray();
    for (char c : myword) {
        if (tmp[c - 'a'] == 1)
            return true;
    }
    return false;
}