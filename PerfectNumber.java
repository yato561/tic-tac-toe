import java.util.Scanner;

class PerfectNumber{
    public static boolean checknum(int num){
            if(num<=1) return false;
            int sum=1;
            for(int i=2;i*i<=num;i++){
                if(num%i==0){
                    sum+=i;
                    if(i!=num/i) sum+=num/i;
                }
            }
            return sum==num;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num= sc.nextInt();
            System.out.println(checknum(num));
            sc.close();
    }
}