//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long countKdivPairs(int nums[], int n, int k)
    {
        // long[] aux=new long[B];
        // Arrays.fill(aux,0);
        // for(int i=0;i<A.length;i++){
        //     ++aux[A[i]%B];
        // }
        // int mod=1000000007;
        // long ans=(aux[0]*(aux[0]-1))/2;
        // int i=1,j=B-1;
        //  while(i<=j){
        //     if(i!=j){
        //         ans+=(aux[i]*aux[j]);
        //         ans=ans%mod;
        //     }else{
        //         ans+=((aux[i]*(aux[j]-1))/2);
        //          ans=ans%mod;
        //     }
        //     i++;
        //     j--;
        // }
        // return ans;
        // //code here
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:nums){
            map.put(i%k,map.getOrDefault(i%k,0)+1);
        }
        
        long ans=(map.getOrDefault(0,0)*(map.getOrDefault(0,0)-1))/2;
        for(int i=1;i<=k/2 && i != (k - i);i++){
            ans+=map.getOrDefault(i,0)*map.getOrDefault(k-i,0);
            
        }
        if(k%2==0)
        ans+= (map.getOrDefault(k/2,0)*(map.getOrDefault(k/2,0)-1))/2;
            
        //ans+=map.getOrDefault(0,0);
        return ans;
    }
}