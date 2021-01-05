package kr.co.crewmate.ojt.start;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
//        System.out.println("Hello World");

        Map<String, String> list = new TreeMap<>();
        Map<Integer, String> list2 = new TreeMap<>();
        Map<String, String> myList = new MyTreeMap<>();
        Map<Integer, String> myList2 = new MyTreeMap<>();

//        list.put("0", "첫");
//        list.put("1", "가");
//        list.put("2", "나");
//        list.put("3", "다");
//        list.put("4", "라");
//        list.put("5", "마");
//        list.put("6", "바");
//        list.put("7", "사");
//        list.put("8", "아");
//        list.put("9", "a");
//        list.put("10", "b");
//        list.put("11", "c");
//        list.put("12", "d");
//        list.put("13", "e");
//        list.put("14", "f");
//        list.put("15", "g");
//        list.put("16", "b");
//        list.put("17", "c");
//        list.put("18", "d");
//        list.put("19", "e");
//        list.put("20", "f");
//        list.put("21", "g");
//        list.put("22", "b");
//        list.put("23", "c");
//        list.put("24", "d");
//        list.put("25", "e");
//        list.put("26", "f");
//        list.put("27", "g");
        
//        list.put(16,  "a");
//        list.put(1,  "b");
//        list.put(18,  "c");
//        list.put(50,  "d");
//        list.put(28,  "e");
//        list.put(4,  "f");
//        list.put(21,  "g");
//        list.put(35,  "h");
//        list.put(41,  "i");
//        list.put(49,  "j");
//        list.put(19,  "k");
//        list.put(25,  "l");
//        list.put(29,  "l");
//        list.put(30,  "l");
//        list.put(31,  "l");
//        list.put(39,  null);
        
//        list.put("C", "C");
//        list.put("B", "B");
//        list.put("A", "A");
//        list.remove(new String("B"));
        
        
        list.put("15",  "h");
        list.put("10",  "a");
        list.put("20", "b");
        list.put("5",  "c");
        list.put("12",  "d");
        list.put("17",  "e");
        list.put("25", "f");
        list.put("2",  "g");
        list.put("7",  "i");
        list.put("1",  "j");
        list.put("3",  "k");
        list.put("6",  "l");
        list.put("8",  "l");
        list.put("9",  "l");
        
        
//        list.put("A", "a");
//        //myTmap.put(80, "a");
        list.remove("6");
//        System.out.println(list.keySet());
//        System.out.println(list.size());
        
//        list.put(25,  "l");
//        list.put(null, "A");
//        list.put(null, "C");
        
//        Set set = list.entrySet();
        
        list2.put(1, "어");
        list2.put(27, "떻");
        list2.put(33, "게");
        list2.put(42, "나");
        list2.put(50, "오");
        list2.put(6, "느"); 
        list2.put(17, null);       
//        list.putAll(list2);
//        list.remove(35);
     
//        list.remove(29);
        
        System.out.println(list);
//        System.out.println(list.get(49));
//        System.out.println(list.keySet());
//        System.out.println(list.values());
//        System.out.println(list.containsKey(null));
//        System.out.println(list.containsValue(null));
//        System.out.println(set);
//        System.out.println(list.get("첫"));
//        System.out.println(list.get("가"));
//        System.out.println(list.get("나"));
//        System.out.println(list.get("다"));
//        System.out.println(list.get("라"));
//        System.out.println(list.get("마"));
//        System.out.println(list.get("바"));
//        System.out.println(list.get("사"));
//        System.out.println(list.get("아"));
//        System.out.println(list.get("a"));
//        System.out.println(list.get("A"));
//        System.out.println(list.keySet());
//        System.out.println(list.values());
//        list.putAll(list);
//        System.out.println(list2);
        System.out.println("------------------------------");

//        myList.put("0", "첫");
//        myList.put("1", "가");
//        myList.put("2", "나");
//        myList.put("3", "다");
//        myList.put("4", "라");
//        myList.put("5", "마");
//        myList.put("6", "바");
//        myList.put("7", "사");
//        myList.put("8", "아");
//        myList.put("9", "a");
//        myList.put("10", "b");
//        myList.put("11", "c");
//        myList.put("12", "d");
//        myList.put("13", "e");
//        myList.put("14", "f");
//        myList.put("15", "g");
//        myList.put("16", "b");
//        myList.put("17", "c");
//        myList.put("18", "d");
//        myList.put("19", "e");
//        myList.put("20", "f");
//        myList.put("21", "g");
//        myList.put("22", "b");
//        myList.put("23", "c");
//        myList.put("24", "d");
//        myList.put("25", "e");
//        myList.put("26", "f");
//        myList.put("27", "g");
//        
//        myList2.put("1", "왜");
//        myList2.put("2", "안");
//        myList2.put("3", "나");
//        myList2.put("4", "오");
//        myList2.put("5", "느");
//        myList2.put("6", "냐");
        
        
                   
//        myList.put(16,  "B");
//        myList.put(null, "A");
//        myList.put(null, "C");
        
//        myList.put(16,  "a");
//        myList.put(1,  "b");
//        myList.put(18,  "c");
//        myList.put(50,  "d");
//        myList.put(28,  "e");
//        myList.put(4,  "f");
//        myList.put(21,  "g");
//        myList.put(35,  "h");
//        myList.put(41,  "i");
//        myList.put(49,  "j");
//        myList.put(19,  "k");
//        myList.put(25,  "l");
//        myList.put(29,  "l");
//        myList.put(30,  "l");
//        myList.put(31,  "l");
//        myList.put(39,  null);
//        myList.put(18, "Z");
        
        
        myList.put("15",  "h");
        myList.put("10",  "a");
        myList.put("20", "b");
        myList.put("5",  "c");
        myList.put("12",  "d");
        myList.put("17",  "e");
        myList.put("25", "f");
        myList.put("2",  "g");
        myList.put("7",  "i");
        myList.put("1",  "j");
        myList.put("3",  "k");
        myList.put("6",  "l");
        myList.put("8",  "l");
        myList.put("9",  "l");
//        myList.clear();
        
//        myList.put("A", "a");
        //myTmap.put(80, "a");
//        myList.remove("5");
//        System.out.println(myList.keySet());
//        System.out.println(myList.size());
        
        
        
//        myList.put(17, "B");
//        myList.put(33, "C");
//        myList.put(55, null);
//        myList.put(null, "a");
//        myList.put(null, "A");
//        myList.put(16,  "B");
//        myList.put(null, null);

//        myList.put("B", "B");
//        myList.put("A", "A");
//        myList.put("C", "C");
        myList.remove("6");
        
        
//        myList.remove(null);
//        myList.remove(55);
//        myList.put("A", "A");
//        myList.put("Q", "Q");
//        myList.remove("a");
//        myList.remove(null);
        myList2.put(1, "어");
        myList2.put(27, "떻");
        myList2.put(33, "게");
        myList2.put(42, "나");
        myList2.put(50, "오");
        myList2.put(6, "느"); 
        myList2.put(17, null);       
//        myList.putAll(myList2);
//        myList.remove(29);
//        Set mySet = myList.entrySet();
        
//        System.out.println(myList);
        System.out.println(myList.keySet());
        System.out.println(myList.size());
//        System.out.println(myList.values());
//        System.out.println(myList.get(null));
//        System.out.println(myList.containsKey(6));
//        System.out.println(myList.containsValue(null));
//        System.out.println(myList.get(1));
//        System.out.println(myList.get(4));
//        System.out.println(myList.put(1,"D"));
//        System.out.println(mySet);
//        System.out.println(mySet);
//        System.out.println(myList.containsKey(1));
//        System.out.println(myList.containsKey(17));
//        System.out.println(myList.containsKey(33));
//        System.out.println(myList.get("첫"));
//        System.out.println(myList.get("가"));
//        System.out.println(myList.get("나"));
//        System.out.println(myList.get("다"));
//        System.out.println(myList.get("라"));
//        System.out.println(myList.get("마"));
//        System.out.println(myList.get("바"));
//        System.out.println(myList.get("사"));
//        System.out.println(myList.get("아"));
//        System.out.println(myList.get("a"));
//        System.out.println(myList.get("A"));

//        System.out.println(myList.get(55));
//        System.out.println(myList.containsKey(55));
//        System.out.println(myList.containsValue("D"));
//        System.out.println(myList.containsValue("));
//        System.out.println(myList.containsValue("));
//        System.out.println(myList.containsValue("));
//        System.out.println(myList.containsValue("));
//        System.out.println(myList.containsValue("));
        
//        System.out.println(myList);
//        System.out.println(myList.containsKey("A"));
//        myList.clear();
//        myList.remove(5);
//        myList.remove(1);
//        myList.remove("1");
        
        
        System.out.println(myList);
////        System.out.println(myList.get("2"));
//        System.out.println(myList.keySet());
//        System.out.println(myList.values());
//        myList.putAll(myList2);
//        System.out.println(myList);

    }

}
