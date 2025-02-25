import java.util.Scanner;

public class SubstringIndex {
    static int CheckIndex(String str, String val){
        for(int i=0,j=val.length();j<=str.length();i++,j++){
            if(str.substring(i,j).equals(val)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
        String val=sc.nextLine();
        int r=CheckIndex(str,val);
        System.out.println(r);
        sc.close();
    }
}
