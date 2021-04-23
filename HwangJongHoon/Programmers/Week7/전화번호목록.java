package Programmers.YAPP.Week7;

import java.util.*;

public class 전화번호목록 {
	static class Solution {
		public boolean solution1(String[] phone_book){
			boolean answer = true;
			TreeMap<String, Integer>[] tm = new TreeMap[21];
			for(int i = 0; i < tm.length; ++i){
				tm[i] = new TreeMap<>();
			}

			for(String pn : phone_book){
				int len = pn.length();
				tm[len].put(pn, 1);
			}
			int diff;
			int result;
			for(int i = 1; i < tm.length - 1; ++i){
				if(!tm[i].isEmpty()){
					for(String pre : tm[i].keySet()){
						for(int j = i + 1; j < tm.length; ++j){
							if(!tm[j].isEmpty()){
								for(String key : tm[j].keySet()){
									result = pre.compareTo(key);
									if(result < 0){ // 접두사보다 키가 길거나 클 때
										diff = key.length() - pre.length();
										if(key.startsWith(pre)) {
											return false;
										} else if(result + diff >= 0) break;
									}
								}
							}
						}
					}
				}
			}
			return answer;
		}

		public static boolean solution2(String[] phone_book) {
			boolean answer = true;
			Arrays.sort(phone_book);
			HashMap<String, String> hm = new HashMap<>();

			for(int i = 0;i < phone_book.length; ++i){
				String phone = phone_book[i];
				hm.put(phone, phone);
				for(int j = 0; j < phone.length(); j++){
					String stub = phone.substring(0 ,j);
					if(hm.get(stub) != null){
						return false;
					}
				}
			}

			return answer;
		}
	}
}
