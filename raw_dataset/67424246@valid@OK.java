static boolean valid(int i, int j, int r, int c) {
    if (i >= 0 && i < r && j >= 0 && j < c) {
        // System.out.println(i+" /// "+j);
        return true;
    } else {
        // System.out.println(i+" //f "+j);
        return false;
    }
}