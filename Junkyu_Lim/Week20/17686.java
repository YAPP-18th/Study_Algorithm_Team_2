import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        ArrayList<File> fileList = new ArrayList<>();
        
        for (String file : files) {
            fileList.add(new File(file));
        }
        
        Collections.sort(fileList);
        
        String[] answer = new String[fileList.size()];
        
        for (int i = 0; i < fileList.size(); i++) {
            answer[i] = fileList.get(i).fullName;
        }
        
        return answer;
    }
}

class File implements Comparable<File>{
    String fullName;
    String head;
    Integer number;
    
    public File(String name) {
        this.fullName = name;
        String headString = name.split("[0-9]")[0];
        String nameWithoutHead = name.replace(headString, "");
        this.head = headString.toLowerCase();
        String numString = nameWithoutHead.split("[^0-9]")[0];
        
        this.number = Integer.parseInt(numString);
    }
    
    @Override
    public int compareTo(File o) {
        if (!this.head.equals(o.head)) {
            return this.head.compareTo(o.head);
        }
        if (this.number != o.number) {
            return this.number - o.number;
        }
        return 0;
    }
}
