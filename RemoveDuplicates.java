import java.util.Scanner;

public class RemoveDuplicates {
    static int CheckDuplicate(int[] arr, int n){
        int s=1;
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[i-1]){
                arr[s]=arr[i];
                s++;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int s=CheckDuplicate(arr,n);
        System.out.println(s);
        sc.close();
    }
}
