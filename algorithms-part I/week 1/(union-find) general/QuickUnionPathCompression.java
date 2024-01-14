public class QuickUnionPathCompression {
    private int[] id;
    private int[] size;

    public QuickUnionPathCompression(int N) {
        id = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        int pSize = size[pRoot];
        int qSize = size[qRoot];

        if (pRoot == qRoot) {
            return;
        }

        if (pSize >= qSize) {
            id[qRoot] = pRoot;
            size[pRoot] += qSize;
        } else {
            id[pRoot] = qRoot;
            size[qRoot] += pSize;
        }
    }

    public boolean connected(int p, int q) {
        boolean isConnected = root(p) == root(q);
        System.out.println("Are " + p + " and " + q + " connected?: " + isConnected);
        return isConnected;
    }


    public static void main(String[] args) {
        QuickUnionPathCompression qu = new QuickUnionPathCompression(10);
        qu.union(4, 3);
        qu.union(3, 8);
        qu.union(6, 5);
        qu.union(9, 4);
        qu.union(2, 1);
        qu.connected(8, 9);
        qu.connected(5, 4);
    }
}
