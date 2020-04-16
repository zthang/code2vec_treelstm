static boolean find(int n, int f) {
    if (map.containsKey(n)) {
        if (map.get(n) >= f) {
            map.put(n, map.get(n) - f);
            if (map.get(n) == 0)
                map.remove(n);
            return true;
        } else {
            f -= map.get(n);
            map.remove(n);
            if (find(n / 2, 2 * f))
                return true;
            else
                return false;
        }
    } else if (n > 1) {
        if (find(n / 2, 2 * f))
            return true;
        else
            return false;
    } else
        return false;
}