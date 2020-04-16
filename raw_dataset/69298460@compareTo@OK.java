@Override
public int compareTo(pair arg0) {
    if (x < arg0.x)
        return -1;
    else if (x == arg0.x) {
        if (y < arg0.y)
            return -1;
        else if (y > arg0.y)
            return 1;
        else
            return 0;
    } else
        return 1;
}