import java.util.Arrays;
import java.util.Scanner;

public class AddOne {
    static int[] SumOne(int[] arr,int n){
        for(int i=n-1;i>=0;i--){
            if(arr[i]<9){
                arr[i]++;
                return arr;
            }
            arr[i]=0;
        }
            int[] r= new int[n+1];
            r[0]=1;
            return r;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(SumOne(arr,n)));
    }
}
