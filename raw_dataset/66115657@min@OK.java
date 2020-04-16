public static char min(Map<Character, Character> map, char ch) {
    char search = ch;
    while (map.containsKey(search)) {
        if (search == map.get(search))
            break;
        search = map.get(search);
    }
    return search;
}