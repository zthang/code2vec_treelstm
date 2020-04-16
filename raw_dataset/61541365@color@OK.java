private static void color(int color, int[] colors, Set<Integer> adjacent) {
    for (int i = 0; i < colors.length; i++) {
        if (!adjacent.contains(i)) {
            if (colors[i] != 0) {
                throw new RuntimeException();
            }
            colors[i] = color;
        }
    }
}