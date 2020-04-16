public void debug(String name, Object... x) {
    if (!allowDebug) {
        return;
    }
    outputName(name);
    System.out.println(Arrays.deepToString(x));
}