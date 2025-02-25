import java.util.Scanner;

public class RemoveElement {
    static int CheckElement(int[] arr, int n,int k){
            int s=0;
            for(int i=0;i<n;i++){
                if(arr[i]!=k){
                    arr[s]=arr[i];
                    s++;
                }
            }
            return s;
        }
        public static void main(String args[]){
            Scanner sc= new Scanner(System.in);
            int n=sc.nextInt();
            int s=sc.nextInt();
            int arr[]=new int [n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int k=CheckElement(arr,n,s);
        System.out.println(k);
        sc.close();
    }
}
