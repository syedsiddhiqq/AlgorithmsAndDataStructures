package templates.math;

public class Combinatorics {
    private static int MOD = 1_000_000_007; // Example modulus (prime)
    private static int MAX = 1_000_000;     // Max precomputed factorial
    private static long[] fact = new long[MAX + 1];
    private static long[] invFact = new long[MAX + 1];

    // Precompute factorials and inverse factorials modulo MOD
    private static void precompute() {
        fact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[MAX] = pow(fact[MAX], MOD - 2, MOD);
        for (int i = MAX - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    // Fast modular exponentiation
    public static long pow(long a, int b, int mod) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return result;
    }

    // Method 2: nCr with modulus using precomputed values
    public static long nCrMod(int n, int r) {
        if (r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    public static void main(String[] args) {
        precompute(); // Call once before queries

        System.out.println(nCrMod(5, 2));  // Output: 10 (5C2 mod 1e9+7)
        System.out.println(nCrMod(1000, 500)); // Efficient for large n
    }
}
