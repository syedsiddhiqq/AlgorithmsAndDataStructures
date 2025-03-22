import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Template {
    static long LowerBound(long[] a2, long x) { // x is the target value or key
        int l = -1, r = a2.length;
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (a2[m] >= x) r = m;
            else l = m;
        }
        return r;
    }

    static int UpperBound(int a[], int x) {// x is the key or target value
        int l = -1, r = a.length;
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= x) l = m;
            else r = m;
        }
        return l + 1;
    }

    public static long getClosest(long val1, long val2, long target) {
        if (target - val1 >= val2 - target)
            return val2;
        else
            return val1;
    }

    static void ruffleSort(long[] a) {
        int n = a.length;
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            long oi = r.nextInt(n), temp = a[i];
            a[i] = a[(int) oi];
            a[(int) oi] = temp;
        }
        Arrays.sort(a);
    }

    static void ruffleSort(int[] a) {
        int n = a.length;
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            int oi = r.nextInt(n), temp = a[i];
            a[i] = a[oi];
            a[oi] = temp;
        }
        Arrays.sort(a);
    }

    private int ceilIndex(int input[], int T[], int end, int s) {
        int start = 0;
        int middle;
        int len = end;
        while (start <= end) {
            middle = (start + end) / 2;
            if (middle < len && input[T[middle]] < s && s <= input[T[middle + 1]]) {
                return middle + 1;
            } else if (input[T[middle]] < s) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    public static int findIndex(long arr[], long t) {
        if (arr == null) {
            return -1;
        }
        int len = arr.length;
        int i = 0;
        while (i < len) {
            if (arr[i] == t) {
                return i;
            } else {
                i = i + 1;
            }
        }
        return -1;
    }

    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static int[] swap(int a[], int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        return a;
    }

    public static void swap(long x, long max1) {
        long temp = x;
        x = max1;
        max1 = temp;
    }

    public static int[] reverse(int a[], int left, int right) {

        // Reverse the sub-array
        while (left < right) {
            int temp = a[left];
            a[left++] = a[right];
            a[right--] = temp;
        }
        return a;
    }

    static int lowerLimitBinarySearch(ArrayList<Integer> A, int B) {
        int n = A.size();
        int first = 0, second = n;
        while (first < second) {
            int mid = first + (second - first) / 2;
            if (A.get(mid) > B) {
                second = mid;
            } else {
                first = mid + 1;
            }
        }

        if (first < n && A.get(first) < B) {
            first++;
        }
        return first; //1 index
    }


    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }


    //    *******----segement tree implement---*****
//    -------------START--------------------------
    void buildTree(int[] arr, int[] tree, int start, int end, int treeNode) {
        if (start == end) {
            tree[treeNode] = arr[start];
            return;
        }
        buildTree(arr, tree, start, end, 2 * treeNode);
        buildTree(arr, tree, start, end, 2 * treeNode + 1);
        tree[treeNode] = tree[treeNode * 2] + tree[2 * treeNode + 1];
    }

    void updateTree(int[] arr, int[] tree, int start, int end, int treeNode, int idx, int value) {
        if (start == end) {
            arr[idx] = value;
            tree[treeNode] = value;
            return;
        }
        int mid = (start + end) / 2;
        if (idx > mid) {
            updateTree(arr, tree, mid + 1, end, 2 * treeNode + 1, idx, value);
        } else {
            updateTree(arr, tree, start, mid, 2 * treeNode, idx, value);
        }
        tree[treeNode] = tree[2 * treeNode] + tree[2 * treeNode + 1];
    }

    //    	disjoint set implementation --start
    static void makeSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static void union(int u, int v) {
        u = findpar(u);
        v = findpar(v);
        if (rank[u] < rank[v]) parent[u] = v;
        else if (rank[v] < rank[u]) parent[v] = u;
        else {
            parent[v] = u;
            rank[u]++;
        }
    }

    private static int findpar(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findpar(parent[node]);
    }

    static int parent[];
    static int rank[];
//    	*************end


    static Long MOD = (long) (1e9 + 7);

    static boolean coprime(int a, long l) {
        return (gcd(a, l) == 1);
    }

    static long[][] dp;
    static long[] dpp;
    static ArrayList<Integer> arr;
    static boolean[] vis;
    static ArrayList<ArrayList<Integer>> adj;

    public static void main(String[] args) throws IOException {
        PrintWriter o = new PrintWriter(System.out);
        Reader s = new Reader();
        long tt = s.nextLong();
        sieve();
//	        ArrayList<Long>aa=new ArrayList<>();
//        	aa.add((long) 3);
//        	aa.add((long) 11);
//        	aa.add((long) 101);
//        	aa.add((long) 1009);
//        	aa.add((long) 10007);
//        	aa.add((long) 100003);
//        	aa.add((long) 1000003);
//        	aa.add((long) 10000019);
//        	aa.add((long) 100030001);
        while (tt-- > 0) {
            int n = s.nextInt();
            int x = s.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = s.nextLong();
            long[] b = new long[n];
            b = a.clone();
            Arrays.sort(b);
            boolean f = true;
            for (int i = n - x; i < x; i++) {
                if (b[i] != a[i]) {
                    f = false;
                    break;
                }
            }
            if (f) o.println("YES");
            else o.println("NO");
        }
        o.flush();
        o.close();
    }

    private static class Graph {
        // No. of vertices
        private int V;

        // Adjacency List Representation
        private List<Integer> adj[];

        // Constructor
        Graph(int v) {
            V = v;
            adj = new ArrayList[v + 1];
            for (int i = 0; i <= v; ++i)
                adj[i] = new ArrayList();
        }

        // Function to add an edge
        // into the graph
        void addEdge(Integer v, Integer w) {
            adj[v].add(w);
            adj[w].add(v);
        }


        void removeEdge(Integer v, Integer w) {
            adj[v].remove(w);
            adj[w].remove(v);
        }
    }

    static long myPow(long n, long i) {
        if (i == 0) return 1;

        if (i % 2 == 0) return (myPow(n, i / 2) % MOD * myPow(n, i / 2) % MOD) % MOD;

        return (n % MOD * myPow(n, i - i) % MOD) % MOD;
    }

    static void palindromeSubStrs(String str) {
        HashSet<String> set = new HashSet<>();
        char[] a = str.toCharArray();
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; j++, i++) {
                if (!set.contains(str.substring(i, i + 1)) && g == 0) {
                    dp[i][j] = 1;
                    set.add(str.substring(i, i + 1));
                } else {
                    if (!set.contains(str.substring(i, j + 1)) && isPalindrome(str, i, j)) {
                        dp[i][j] = 1;
                        set.add(str.substring(i, j + 1));
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
                if (dp[i][j] == 1) ans++;
            }
            System.out.println();
        }
        System.out.println(ans);
    }

    static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static boolean sign(long num) {
        return num > 0;
    }

    static boolean isSquare(long x) {
        if (x == 1) return true;
        long y = (long) Math.sqrt(x);
        return y * y == x;
    }

    private static void dfs(int i) {
        vis[i] = true;
        arr.add(i);
        for (int x : adj.get(i)) {
            if (vis[x] == false) dfs(x);
        }

    }

    static long power1(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long ans = power(a, b / 2);
        ans *= ans;
        if (b % 2 != 0) {
            ans *= a;
        }
        return ans;
    }

    static void swap(StringBuilder sb, int l, int r) {
        char temp = sb.charAt(l);
        sb.setCharAt(l, sb.charAt(r));
        sb.setCharAt(r, temp);
    }

    // function to reverse the string between index l and r
    static void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            swap(sb, l, r);
            l++;
            r--;
        }
    }

    // function to search a character lying between index l and r
    // which is closest greater (just greater) than val
    // and return it's index
    static int binarySearch(StringBuilder sb, int l, int r, char val) {
        int index = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (sb.charAt(mid) <= val) {
                r = mid - 1;
            } else {
                l = mid + 1;
                if (index == -1 || sb.charAt(index) >= sb.charAt(mid))
                    index = mid;
            }
        }
        return index;
    }

    // this function generates next permutation (if there exists any such permutation) from the given string
    // and returns True
    // Else returns false
    static boolean nextPermutation(StringBuilder sb) {
        int len = sb.length();
        int i = len - 2;

        while (i >= 0 && sb.charAt(i) >= sb.charAt(i + 1))
            i--;

        if (i < 0)
            return false;
        else {
            int index = binarySearch(sb, i + 1, len - 1, sb.charAt(i));
            swap(sb, i, index);
            reverse(sb, i + 1, len - 1);
            return true;
        }
    }

    private static int lps(int m, int n, String s1, String s2, int[][] mat) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) mat[i][j] = 1 + mat[i - 1][j - 1];
                else mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
            }
        }
        return mat[m][n];
    }

    static String lcs(String X, String Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];

        // Following steps build L[m+1][n+1] in bottom up fashion. Note
        // that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }

        // Following code is used to print LCS
        int index = L[m][n];
        int temp = index;

        // Create a character array to store the lcs string
        char[] lcs = new char[index + 1];
        lcs[index] = '\u0000'; // Set the terminating character

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            // If current character in X[] and Y are same, then
            // current character is part of LCS
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                // Put current character in result
                lcs[index - 1] = X.charAt(i - 1);

                // reduce values of i, j and index
                i--;
                j--;
                index--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i - 1][j] > L[i][j - 1])
                i--;
            else
                j--;
        }
        return String.valueOf(lcs);
        // Print the lcs
//            System.out.print("LCS of "+X+" and "+Y+" is ");
//            for(int k=0;k<=temp;k++)
//                System.out.print(lcs[k]);
    }

    static long lis(long[] aa2, int n) {
        long lis[] = new long[n];
        int i, j;
        long max = 0;
        for (i = 0; i < n; i++)
            lis[i] = 1;
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (aa2[i] >= aa2[j] && lis[i] <= lis[j] + 1)
                    lis[i] = lis[j] + 1;
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }

    static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static boolean issafe(int i, int j, int r, int c, char ch) {
        if (i < 0 || j < 0 || i >= r || j >= c || ch != '1') return false;
        else return true;
    }

    static long power(long a, long b) {
        a %= MOD;
        long out = 1;
        while (b > 0) {
            if ((b & 1) != 0) out = out * a % MOD;
            a = a * a % MOD;
            b >>= 1;
            a *= a;
        }
        return out;
    }

    static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;

        double temp = Math.log(n) / Math.log(2);
        return (int) (Math.ceil(temp)) ==
                (int) (Math.floor(temp));
    }

    static long[] sieve;

    public static void sieve() {
        int nnn = (int) 1e6 + 1;
        long nn = (int) 1e6;
        sieve = new long[(int) nnn];
        int[] freq = new int[(int) nnn];
        sieve[0] = 0;
        sieve[1] = 1;
        for (int i = 2; i <= nn; i++) {
            sieve[i] = 1;
            freq[i] = 1;
        }
        for (int i = 2; i * i <= nn; i++) {
            if (sieve[i] == 1) {
                for (int j = i * i; j <= nn; j += i) {
                    if (sieve[j] == 1) {
                        sieve[j] = 0;
                    }
                }
            }
        }
    }

}

class decrease implements Comparator<Long> {
    // Used for sorting in ascending order of
    // roll number
    public int compare(long a, long b) {
        return (int) (b - a);
    }

    @Override
    public int compare(Long o1, Long o2) {
        // TODO Auto-generated method stub
        return (int) (o2 - o1);
    }
}

class pair {
    long x;
    long y;
    long c;

    public pair(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public pair(long x, long y, long c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
}



 