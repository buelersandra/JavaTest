import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * AndelaJavaTest
 */
public class CountFruits {

    public static void main(String[] args) {

        String[] fruits = {"Strawberry", "Mango", "Cherry", "Lime", "Guava", "Papaya", "Nectarine", "Pineapple", "Lemon", "Plum", "Tangerine",
        "Fig", "Blueberry", "Grape", "Jackfruit", "Pomegranate", "Apple", "Pear", "Orange", "Watermelon", "Raspberry", "Banana"};
       


        firstCharacters(fruits);

    }

    public static void firstCharacters(String[] words) {
        int[] frequency = new int[26];
        Map<Character,Set<String>> charFruitMap = new HashMap<>();

        Map<String,Integer> fruitCount = new HashMap<>();

    
        for(String word : words){
            if(!word.isEmpty()){
                char c = word.charAt(0);
                frequency[c-'A']++;

                charFruitMap.putIfAbsent(c, new HashSet());
                Set<String> list = charFruitMap.get(c);
                list.add(word);
                charFruitMap.put(c,list);

                fruitCount.put(word, fruitCount.getOrDefault(word, 0) + 1);

            }
            
        }

        for(int i = 0; i<frequency.length; i++){
            char c = (char)(i + 'A');
            System.out.println(""+c+":"+frequency[i]);
            
            Set<String> list = charFruitMap.getOrDefault(c,new HashSet<>());
            for(String fruit : list){
                System.out.println(""+fruitCount.get(fruit)+":"+fruit);
            }

            System.out.println();
        }
    }
    
}

