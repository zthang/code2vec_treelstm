void unite(int a, int b, long edge) {
    a = get(a);
    b = get(b);
    if (rank[a] > rank[b]) {
        parent[b] = a;
        cost_of_comp[a] += edge + cost_of_comp[b] - max(min_cost_for_station[a].x, min_cost_for_station[b].x);
        if (min_cost_for_station[a].x > min_cost_for_station[b].x)
            min_cost_for_station[a] = min_cost_for_station[b];
    } else if (rank[b] > rank[a]) {
        parent[a] = b;
        cost_of_comp[b] += edge + cost_of_comp[a] - max(min_cost_for_station[a].x, min_cost_for_station[b].x);
        if (min_cost_for_station[b].x > min_cost_for_station[a].x)
            min_cost_for_station[b] = min_cost_for_station[a];
    } else {
        parent[a] = b;
        cost_of_comp[b] += edge + cost_of_comp[a] - max(min_cost_for_station[a].x, min_cost_for_station[b].x);
        if (min_cost_for_station[b].x > min_cost_for_station[a].x)
            min_cost_for_station[b] = min_cost_for_station[a];
        rank[b]++;
    }
}