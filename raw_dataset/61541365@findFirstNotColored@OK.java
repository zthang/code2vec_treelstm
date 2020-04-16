private static int findFirstNotColored(int[] colors) {
    for (int i = 0; i < colors.length; i++) {
        if (colors[i] == 0) {
            return i;
        }
    }
    throw new RuntimeException();
}