static boolean next_bits(boolean[] b) {
    for (int i = 0; i < b.length; i++) {
        if (b[i]) {
            b[i] = false;
        } else {
            b[i] = true;
            return true;
        }
    }
    return false;
}