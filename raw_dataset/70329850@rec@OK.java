// *************************************************************************
/**
 */
public static String rec(String s) {
    if (s.length() % 2 != 0) {
        return s;
    }
    String p1 = rec(s.substring(0, s.length() / 2));
    String p2 = rec(s.substring(s.length() / 2));
    if (p1.compareTo(p2) < 0)
        return p1 + p2;
    else
        return p2 + p1;
}