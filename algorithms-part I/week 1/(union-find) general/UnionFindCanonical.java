// Add a method find() to the union-find data type so that find(i) returns the largest element in the connected component containing i.
// The operations, union(), connected(), and find() should all take logarithmic time or better. For example, if one of the connected components is {1,2,6,9}, then the find() method should return 
// 9 for each of the four elements in the connected components.

import java.util.Arrays;

public class UnionFindCanonical {
    private int[] id;
    private int[] size;
    private int[] max;

    public UnionFindCanonical(int N) {
        id = new int[N];
        size = new int[N];
        max = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
            max[i] = i;
        }
    }

    private int root(int i) {
        int parent = id[i];

        if (i == parent) {
            return i;
        }
        return root(parent);
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        int pRootMax = max[pRoot];
        int qRootMax = max[qRoot];
        int pSize = size[pRoot];
        int qSize = size[qRoot];

        if (pRoot == qRoot) {
            return;
        }

        if (pSize >= qSize) {
            id[qRoot] = id[pRoot];
            size[pRoot] += qSize;
        } else {
            id[pRoot] = id[qRoot];
            size[qRoot] += pSize;
        }

        if (pRootMax > qRootMax) {
            max[root(p)] = pRootMax;
        } else {
            max[root(p)] = qRootMax;
        }
//        display();
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

    public int find(int i) {
        return max[root(i)];
    }

    public static void main(String[] args) {
        UnionFindCanonical ufc = new UnionFindCanonical(10);
        ufc.union(3, 5);
        ufc.union(6, 0);
        ufc.union(8, 6);
        ufc.union(5, 0);
        System.out.println(ufc.find(1));
    }
}
