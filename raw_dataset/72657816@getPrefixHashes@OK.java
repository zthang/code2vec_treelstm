public static HarmeyerHash[] getPrefixHashes(char[] word) {
    precomp();
    int n = word.length;
    HarmeyerHash[] toReturn = new HarmeyerHash[n + 1];
    toReturn[0] = new HarmeyerHash();
    for (int i = 1; i <= n; i++) {
        toReturn[i] = toReturn[i - 1].clone();
        toReturn[i].add(word[i - 1]);
    }
    return toReturn;
}