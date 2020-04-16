private static boolean cantBeReduced(String str, Set<Integer> used) {
    if (str == null || str.length() == 0) {
        return true;
    }
    int lastOpen = Integer.MAX_VALUE;
    int lastClosed = Integer.MIN_VALUE;
    for (int i = 0; i < str.length(); i++) {
        if (!used.contains(i)) {
            if (str.charAt(i) == ')') {
                lastClosed = Math.max(lastClosed, i);
            } else {
                lastOpen = Math.min(lastOpen, i);
            }
        }
    }
    if (lastOpen < lastClosed && lastOpen != Integer.MAX_VALUE && lastClosed != Integer.MIN_VALUE) {
        return false;
    }
    return true;
}