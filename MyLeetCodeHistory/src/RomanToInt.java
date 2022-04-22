public class RomanToInt {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() ; i++) {
            sum+=getValue(s.charAt(i));
            if(i == s.length()-1) break;
            switch (s.charAt(i)){
                case 'I':
                    if(s.charAt(i+1) == 'X' || s.charAt(i+1) == 'V'){
                        sum-=2;
                        continue;
                    }
                case 'X':
                    if(s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C'){
                        sum-=20;
                        continue;
                    }
                case 'C':
                    if(s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M'){
                        sum-=200;
                    }
            }
        }
        return sum;
    }
    private int getValue(char c){
        return switch (c) {
            case 'M' -> 1000;
            case 'D' -> 500;
            case 'C' -> 100;
            case 'L' -> 50;
            case 'X' -> 10;
            case 'V' -> 5;
            case 'I' -> 1;
            default -> 0;
        };
    }
}
