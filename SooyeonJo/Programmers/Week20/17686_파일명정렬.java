import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String[] file1 = splitName(o1);
            String[] file2 = splitName(o2);

            int headValue = file1[0].compareTo(file2[0]);
            if(headValue == 0){
                int num1 = Integer.parseInt(file1[1]);
                int num2 = Integer.parseInt(file2[1]);

                return num1 - num2;
            }
            return headValue;
        });

        return files;
    }

    public String[] splitName(String str){
        String head;
        String number;
        String tail;

        int i=0;
        for(; i<str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                break;
            }
        }

        head = str.substring(0, i);

        int index = i;
        for(; i<str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                continue;
            }
            break;
        }

        number = str.substring(index, i);
        tail = str.substring(i);

        return new String[]{head.toLowerCase(), number, tail};
    }
}
