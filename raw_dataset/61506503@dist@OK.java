public static int dist(int[] point, int[] point2) {
    return (int) (Math.pow((point2[1] - point[1]), 2) + Math.pow((point2[0] - point[0]), 2));
}