import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * AndelaJavaTest
 */
public class CountFruits {

    public static void main(String[] args) {

        String[] fruits = {"Strawberry","Mango", "Cherry", "Lime", "Guava", "Papaya", "Nectarine", "Pineapple", "Lemon", "Plum", "Tangerine",
        "Fig", "Blueberry", "Grape", "Jackfruit", "Pomegranate", "Apple", "Pear", "Orange", "Watermelon", "Raspberry", "Banana"};
       


        firstCharacters(fruits);

    }

    public static void firstCharacters(String[] words) {

        Arrays.sort(words,(a,b) -> a.compareToIgnoreCase(b));
        int[] frequency = new int[26];
        Map<Character,LinkedHashSet<String>> charFruitMap = new HashMap<>();

        Map<String,Integer> fruitCount = new HashMap<>();

    
        for(String word : words){
            if( word != null && !word.isEmpty()){
                char c = word.charAt(0);
                frequency[c-'A']++;

                charFruitMap.putIfAbsent(c, new LinkedHashSet());
                LinkedHashSet<String> list = charFruitMap.get(c);
                list.add(word);
                charFruitMap.put(c,list);

                fruitCount.put(word, fruitCount.getOrDefault(word, 0) + 1);

            }
            
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i<frequency.length; i++){
            builder.delete(0, builder.length());
            char c = (char)(i + 'A');
            builder.append(c);
            builder.append(':');
            builder.append(' ');
            builder.append(frequency[i]);
            
            System.out.println(builder.toString());
            
            builder.delete(0, builder.length());
            LinkedHashSet<String> list = charFruitMap.getOrDefault(c,new LinkedHashSet<>());

            for(String fruit : list){
                builder.delete(0, builder.length());
                builder.append(fruitCount.get(fruit));
                builder.append(' ');
                builder.append(fruit);
                System.out.println(builder.toString());
            }

            System.out.println();
        }
    }
    
}

