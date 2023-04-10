class Solution
{
    public int solution(int n, int a, int b)
    {
        int result = 0;
        while(a!=b){
            result++;
            a=a/2 + a%2;
            b=b/2 + b%2;
        }
        return result;
    }
}