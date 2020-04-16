private static int[] find(int[] weights) {
    int min = Integer.MAX_VALUE;
    int minIndex = 0;
    for (int i = 0; i < weights.length; i++) {
        if (min > weights[i]) {
            min = weights[i];
            minIndex = i;
        }
    }
    min = Integer.MAX_VALUE;
    int nextIndex = 0;
    for (int i = 0; i < weights.length; i++) {
        if (i != minIndex) {
            if (min > weights[i]) {
                min = weights[i];
                nextIndex = i;
            }
        }
    }
    return new int[] { minIndex, nextIndex };
}