class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        long N = n; // use long to avoid overflow
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return powerOfNum(x, N);
    }

    private double powerOfNum(double x, long n) {
        if (n == 0) return 1;

        double half = powerOfNum(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}


/*class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
        return 1;
        long N = (long)Math.abs(n);
        if(n>0){
            return powerOfNum(x,N);
        }
        else
        {
            //long N = (long)n;
            return (1.0/powerOfNum(x, N));
        }
    }

    private double powerOfNum(double x, long n){
        if(n == 0)
        return 1;
        return x * powerOfNum(x,n-1);
    }
}*/
