import java.util.Scanner;

 public class PerfectNumber{
    public static boolean checknum(int num){
            if(num<=1) return false;// Ckecking whether num is lesser than or equal to 1 
            int sum=1;
            for(int i=2;i*i<=num;i++){
                if(num%i==0){//find the divisor of num
                    sum+=i;
                    if(i!=num/i) sum+=num/i;// finding out square root number so not to double count the num
                }
            }
            return sum==num;// returing boolean value
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num= sc.nextInt();
            System.out.println(checknum(num));
            sc.close();
    }
}