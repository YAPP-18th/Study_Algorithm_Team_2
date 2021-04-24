import java.util.*;
class progsdfs{
    public static void main(String[] args){
        // String [] phone_book = 	{"1"};
        // String [] phone_book = 	{"123","456","789"};
        String [] phone_book = 	{"12","123","1235","88","567",};
        
        System.out.println(solution(phone_book));
    }
    public static boolean solution(String [] phone_book){
        // sort 안하고 이중포문 쓰면 틀린다.
        Arrays.sort(phone_book);

        for(int i=0; i<phone_book.length-1; i++){
            int j = i + 1;
            if(phone_book[i].length() > phone_book[j].length() ){
                continue;
            }
            if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length())) ){
                return false;
            }
        }
        return true;
    }
}
// 이중 포문은 효율성 테스트 탈락
// public boolean solution(String[] phone_book) {
//     for(int i=0; i<phone_book.length-1; i++){
//         for(int j=i+1; j<phone_book.length; j++){
//             int aSize = phone_book[i].length();
//             int bSize = phone_book[j].length();
//             if(aSize == bSize){
//                 if(phone_book[i].equals(phone_book[j])){
//                     return false;
//                 }
//             }else if(aSize > bSize){
//                 if(phone_book[j].equals(phone_book[i].substring(0, phone_book[j].length())) ){
//                     return false;
//                 }
//             }else{
//                 if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length())) ){
//                     return false;
//                 }
//             }
//         }
//     }
//     return true;
// }
