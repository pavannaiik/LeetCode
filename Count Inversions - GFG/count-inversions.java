//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inv =0;
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long l=0, r = N-1;
        return sort(arr,(int)l,(int)r);
    }
    static long sort(long arr[],int l, int r){
        if(l < r){
            int mid = l + (r-l)/2;
            long m1 = sort(arr, l, mid);
            long  m2 = sort(arr, mid+1, r);
            long m3= merge(arr, l, mid, r);
            return (m1+m2+m3);
        }
        else return 0;
        
    }
    static long merge(long arr[], int l, int m, int r){
    int n1 = m-l+1;
    int n2 = r-m;
    long count =0;
    long L[] = new long[n1];
    long R[] = new long[n2];
    for(int i=0;i<n1;i++){
        L[i] = arr[l+i];
    }
    for(int i=0;i<n2;i++){
        R[i] = arr[m+1+i];
    }
    
    int p =0, q =0, k=l;
    while(p < n1 && q < n2){
        if(L[p] <= R[q]){
            arr[k++] = L[p++];
        }else{
            arr[k++] = R[q++];
            count += (m + 1) - (l + p);
        }
    }
    while( p < n1){
         arr[k++] = L[p++];
    }
    while( q < n2){
        arr[k++] = R[q++];
    }
    return count;
}

}