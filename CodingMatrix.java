import java.util.ArrayList;
import java.util.Arrays;

public class CodingMatrix {
    private final String key; 
    private final char[] key_array; 
    private final int key_length; 
    private final int hight; 
    private final int index_sum; 
    private final ArrayList<Pair<Character, Integer>> characters_indexes; 

    private ArrayList<ArrayList<Character>> matrix; 

    public CodingMatrix(String key) {
        this.key = key; 
        key_length = key.length(); 

        int sum=0; 
        for(int i=1; i<=key_length; i++) {
            sum += i; 
        }

        index_sum = sum; 
        hight = index_sum/key_length; 

        matrix = new ArrayList<>(hight); 

        for(int i=1; i<=hight; i++) {
            matrix.add(new ArrayList<>(key_length));  
        }

        key_array = sortKeyCharacters(); 
    }

    private char[] sortKeyCharacters() {
        char[] key_array = key.toCharArray(); 
        Arrays.sort(key_array);   
        return key_array; 
    } 

    public void debug() {
        System.out.println("Debug");
        System.out.println(key);
        System.out.println(key_length);
        System.out.println(hight);
        System.out.println(index_sum);

        for (char e : key_array) {
            System.out.println(e);            
        }
    }


}
