package br.unicesumar.projeto_1.tsp;

public class TSP {

    private final int n;
    private final double[][] dist;

    public TSP(double[][] coordinates) {
        this.n = coordinates.length;
        this.dist = new double[n][n];
        buildDistanceMatrix(coordinates);
    }

    private void buildDistanceMatrix(double[][] coordinates) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double dx = coordinates[i][0] - coordinates[j][0];
                double dy = coordinates[i][1] - coordinates[j][1];
                dist[i][j] = Math.sqrt(dx * dx + dy * dy);
            }
        }
    }

    public double nearestNeighbor(int startCity) {
        boolean[] visited = new boolean[n];
        int current = startCity;
        visited[current] = true;
        double totalDist = 0;

        for (int step = 0; step < n - 1; step++) {
            double minDist = Double.MAX_VALUE;
            int nearest = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[current][j] < minDist) {
                    minDist = dist[current][j];
                    nearest = j;
                }
            }
            visited[nearest] = true;
            totalDist += minDist;
            current = nearest;
        }
        totalDist += dist[current][startCity];
        return totalDist;
    }

    public int getN() {
        return n;
    }
}
