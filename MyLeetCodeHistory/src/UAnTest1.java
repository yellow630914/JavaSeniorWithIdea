import org.junit.Test;

public class UAnTest1 {
    public static void main(String[] args) {
        String str = "";
        Test1(str);
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
}
