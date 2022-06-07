
public class UAnTest1 {
    public static void main(String[] args) {
        String str = "a,b,c,d,e,f,g";
        Test1(str);

        Test2(7);
    }
    public static void Test1(String str){
        StringBuilder tempString = new StringBuilder();
        for (int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) != ','){
                tempString.append(str.charAt(i));
            }else {
                tempString.append(1);
                System.out.println(tempString);
                tempString.delete(0,tempString.length());
            }
        }
        if(!tempString.isEmpty()){
            tempString.append(1);
            System.out.println(tempString);
        }
    }

    public static void Test2(int count){
        for(int i = 1;i <= count;i++){
            int j = 0;
            for (; j < count - i; j++) {
                System.out.print(" ");
            }
            for (; j < count; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


