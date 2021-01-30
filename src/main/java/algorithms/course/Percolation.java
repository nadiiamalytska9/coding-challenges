package algorithms.course;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int n;
    private final int[][] sites;
    private boolean[][] openSites;
    private boolean[][] fullSites;
    private int openSitesAmount = 0;
    private final WeightedQuickUnionUF weightedQuickUnionUF;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        sites = new int[n + 1][n + 1];
        openSites = new boolean[n + 1][n + 1];
        fullSites = new boolean[n + 1][n + 1];
        weightedQuickUnionUF = new WeightedQuickUnionUF(n * n + 2);

        int element = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sites[i][j] = element;
                element++;
            }
        }
    }

    public void open(int row, int col) {
        validate(row, col);
        if (isOpen(row, col)) {
            return;
        }
        openSites[row][col] = true;
        openSitesAmount++;

        int site = xyTo1D(row, col);

        if (row == 1) {
            weightedQuickUnionUF.union(0, site);
            fullSites[row][col] = true;
        }
        if (row == n) {
            weightedQuickUnionUF.union(n * n + 1, site);
            fillSite(row, col);
        }
        if (!isFull(row, col)) {
            fillSite(row, col);
        }
        if (isFull(row, col)) {
            fillAdjacentSites(row, col, site);
        }
    }

    private void fillSite(int row, int col) {
        if (row - 1 >= 1) {
            fillSiteIfValid(row - 1, col, row, col);
        }
        if (row + 1 <= n) {
            fillSiteIfValid(row + 1, col, row, col);
        }
        if (col + 1 <= n) {
            fillSiteIfValid(row, col + 1, row, col);
        }
        if (col - 1 >= 1) {
            fillSiteIfValid(row, col - 1, row, col);
        }
    }

    private void fillSiteIfValid(int row, int col, int rowToFill, int colToFill) {
        if (!isOpen(row, col)) return;
        if (isFull(row, col)) {
            weightedQuickUnionUF.union(xyTo1D(row, col), xyTo1D(rowToFill, colToFill));
            fullSites[rowToFill][colToFill] = true;
        }
    }

    private void fillAdjacentSites(int row, int col, int fullSite) {
        if (row - 1 >= 1) {
            fillAdjacentSiteIfValidate(row - 1, col, fullSite);
        }
        if (row + 1 <= n) {
            fillAdjacentSiteIfValidate(row + 1, col, fullSite);
        }
        if (col + 1 <= n) {
            fillAdjacentSiteIfValidate(row, col + 1, fullSite);
        }
        if (col - 1 >= 1) {
            fillAdjacentSiteIfValidate(row, col - 1, fullSite);
        }
    }

    private void fillAdjacentSiteIfValidate(int row, int col, int fullSite) {
        if (isFull(row, col)) return;
        if (!isOpen(row, col)) return;
        weightedQuickUnionUF.union(fullSite, xyTo1D(row, col));
        fullSites[row][col] = true;
        fillAdjacentSites(row, col, fullSite);
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);
        return openSites[row][col];
    }

    public boolean isFull(int row, int col) {
        validate(row, col);
        return fullSites[row][col];
    }

    public int numberOfOpenSites() {
        return openSitesAmount;
    }

    public boolean percolates() {
        return weightedQuickUnionUF.find(0) == weightedQuickUnionUF.find(n * n + 1);
    }

    private int xyTo1D(int row, int col) {
        return sites[row][col];
    }

    private void validate(int row, int col) {
        if (row > n || row < 1 || col > n || col < 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 1);
        percolation.open(2, 1);
        percolation.open(3, 2);
        percolation.open(3, 1);

        if (percolation.weightedQuickUnionUF.find(percolation.xyTo1D(1, 1))
                == percolation.weightedQuickUnionUF.find(percolation.xyTo1D(3, 2))) {
            System.out.println("Sites are connected!");
        }
        else {
            System.out.println("Sites are NOT connected!");
        }

        if (percolation.percolates()) {
            System.out.println("Percolates!");
        }
        else {
            System.out.println("Doesn't percolates!");
        }
    }
}
