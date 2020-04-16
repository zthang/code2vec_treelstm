    private static void join(Map<Character, Character> groups, Map<Character, Set<String>> groupMap, char a, char b) {
        char aGroup = groups.get(a);
        char bGroup = groups.get(b);
        if (groupMap.get(aGroup).size() < groupMap.get(bGroup).size()) {
            char tmp = aGroup;
            aGroup = bGroup;
            bGroup = tmp;
        }
        groupMap.get(aGroup).addAll(groupMap.get(bGroup));
        groupMap.remove(bGroup);
        groups.put(bGroup, aGroup);
    }