package reusables;

public class SegmentTreeRangeSum {
    private int[] segmentTree;
    private int size;
    private int[] lazy;

    public SegmentTreeRangeSum(int size) {
        this.size = size;
        this.segmentTree = new int[4 * size];
        this.lazy = new int[4 * size];
    }

    public void build(int[] input) {
        build(input, 0, 0, size - 1);
    }

    private void build(int[] input, int index, int left, int right) {
        if (left == right) {
            this.segmentTree[index] = input[left];
            return;
        }

        int mid = (left + right) / 2;
        // Left subtree
        build(input, 2 * index + 1, left, mid);
        // Right subtree
        build(input, 2 * index + 2, mid + 1, right);
        // Updating the index with left and right
        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
    }

    public int rangeSum(int l, int r) {
        return query(0, 0, size - 1, l, r);
    }

    private int query(int index, int left, int right, int queryLeft, int queryRight) {
        // If left and right completely overlaps within query left and query right then return
        // current node value
        if (left >= queryLeft && right <= queryRight) {
            return segmentTree[index];
        }
        // Outside the range
        if (queryLeft > right || queryRight < left ) {
            return 0;
        }

        // Partial overlap
        int mid = (left + right) / 2;
        int leftTree = query(2 * index + 1, left, mid, queryLeft, queryRight);
        int rightTree = query(2 * index + 2, mid + 1, right, queryLeft, queryRight);
        return leftTree + rightTree;
    }

    public void pointUpdate(int arrIndex, int value) {
        pointUpdate(0, arrIndex, value, 0, size - 1);
    }

    private void pointUpdate(int index, int arrIndex, int value, int left, int right) {
        if (left == right) {
            segmentTree[index] = value;
            return;
        }

        int mid = (left + right) / 2;
        if (arrIndex <= mid) {
            pointUpdate(2 * index + 1, arrIndex, value, left, mid);
        } else {
            pointUpdate(2 * index + 2, arrIndex, value, mid + 1, right);
        }
        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
    }

    public void rangeUpdate(int l, int r, int value) {
        rangeUpdate(0, 0, size - 1, l, r, value);
    }

    private void rangeUpdate(int index, int left, int right, int ql, int qr, int value) {
        if (lazy[index] != 0) {
            segmentTree[index] += (right - left + 1) * lazy[index];
            lazy[2 * index + 1] += lazy[index];
            lazy[2 * index + 2] += lazy[index];
            lazy[index] = 0;
        }

        // No overlap
        if (ql > right || qr < left || left > right) return;

        // Complete overlap
        if (left >= ql && right <= qr) {
            segmentTree[index] += (right - left + 1) * value;
            lazy[2 * index + 1] += value;
            lazy[2 * index + 2] += value;
            return;
        }

        // Partial Overlap
        int mid = (left + right) / 2;
        rangeUpdate(2 * index + 1, left, mid, ql, qr, value);
        rangeUpdate(2 * index + 2, mid + 1, right, ql, qr, value);
        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SegmentTreeRangeSum segmentTreeRangeSum = new SegmentTreeRangeSum(10);
        segmentTreeRangeSum.build(arr);
        System.out.println(segmentTreeRangeSum.rangeSum(0, 9));
        System.out.println(segmentTreeRangeSum.rangeSum(0, 3));
        System.out.println(segmentTreeRangeSum.rangeSum(4, 9));
        System.out.println(segmentTreeRangeSum.rangeSum(3, 7));

        segmentTreeRangeSum.rangeUpdate(3, 7, 1);
        System.out.println(segmentTreeRangeSum.rangeSum(3, 7));

        segmentTreeRangeSum.pointUpdate(9, 20);
        System.out.println(segmentTreeRangeSum.rangeSum(0, 9));
    }
}
