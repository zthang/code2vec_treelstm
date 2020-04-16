public static int digitSum(String s) {
    int toReturn = 0;
    for (int i = 0; i < s.length(); i++) toReturn += Integer.parseInt(s.charAt(i) + " ");
    return toReturn;
}