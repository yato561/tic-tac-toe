import java.util.Scanner;

public class Palindrome {
     static Boolean Checkn(int n){
        if(n<0) return false; 
        int r=0;
        int temp=n;
        while(temp!=0){
            int d=temp%10;
            r=r*10+d;
            temp/=10;
        }
        return r==n;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Checkn(n));
        sc.close();
    }
}
