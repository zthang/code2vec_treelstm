    static boolean check(TreeMap<Integer, Integer> parentMap) {
        int p = parentMap.firstEntry().getValue();
        for (int lvl : parentMap.keySet()) {
            int cur = parentMap.get(lvl);
            if (!isAncestor(p, cur)) return false;
            p = cur;
        }
        return true;
    }