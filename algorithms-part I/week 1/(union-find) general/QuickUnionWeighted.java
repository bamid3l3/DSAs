import java.util.Arrays;

public class QuickUnionWeighted {
    private int[] id;
    private int[] size;

    public QuickUnionWeighted(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int nodeSize(int i) {
        return size[root(i)];
    }

    private int root(int i) {
        int parent = id[i];

        if (i == parent) {
            return i;
        }
        return root(parent);
    }

    public void union(int p, int q) {
        if (root(p) == root(q)) {
            return;
        }

        int pSize = size[root(p)];
        int qSize = size[root(q)];

        if (pSize >= qSize) {
            id[root(q)] = id[root(p)];
            size[root(p)] += qSize;
        } else {
            id[root(p)] = id[root(q)];
            size[root(q)] += pSize;
        }
        display();
    }

    public void display() {
        System.out.println("Current ids..: " + Arrays.toString(id));
        System.out.println("Current sizes: " + Arrays.toString(size));
        System.out.println();

    }

    public boolean connected(int p, int q) {
        boolean isConnected = root(p) == root(q);
        System.out.println("Are " + p + " and " + q + " connected?: " + isConnected);
        return isConnected;
    }

    public static void main(String[] args) {
        QuickUnionWeighted qu = new QuickUnionWeighted(36);
        qu.union(11, 5);
        qu.union(3, 8);
//        qu.union(6, 5);
//        qu.union(9, 4);
//        qu.union(2, 1);
//        qu.connected(8, 9);
//        qu.connected(5, 4);
//        qu.union(5, 0);
//        qu.union(7, 2);
//        qu.union(6, 1);
//        qu.union(7, 3);
    }
}
