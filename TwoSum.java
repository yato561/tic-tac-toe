
import java.util.Scanner;

public class TwoSum {
    public static int[] sum(int []nums, int target){
            int n=nums.length;
            for(int i=0;i<=n-1;i++){
                for(int j=i+1;j<n;j++){
                    if(nums[i]+nums[j]==target){
                        return new int[]{i,j};
                    }
                }
            }
            return new int[]{};
        }
        public static void main(String[] args) {
            Scanner sc= new Scanner(System.in);
            int n=sc.nextInt();
            int t=sc.nextInt();
            int[] nums= new int[n];
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            int []result= TwoSum.sum(nums,t);
            System.out.println(result[0]+","+result[1]);
            sc.close();
    }
}
