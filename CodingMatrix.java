import java.util.ArrayList;
import java.util.Arrays;

public class CodingMatrix {
    private final String key; 
    private final char[] key_array; 

    private final int width; 
    private final int hight; 
    private final int index_sum;

    private int[] key_index; 

    private ArrayList<ArrayList<Character>> matrix; 

    public CodingMatrix(String key) {
        this.key = key; 
        this.key_array = key.toCharArray(); 
        width = key.length(); 

        int sum=0; 
        for(int i=1; i<=width; i++) {
            sum += i; 
        }

        index_sum = sum; 
        hight = index_sum/width; 

        matrix = new ArrayList<>(hight); 

        for(int i=1; i<=hight; i++) {
            matrix.add(new ArrayList<>(width));  
        }

        char[] temp = key_array.clone(); 
        key_index = findKeyIndex(temp); 
    }

    private int findIndexOfMin(char[] charArray, int range) {
        char min = Character.MAX_VALUE; 
        int result = -1; 

        for (int i = 0; i < range; i++) {
            System.out.println(min);
            System.out.println(charArray[i]);

            if(Character.compare(charArray[i], min) < 0) {
                min=charArray[i]; 
                result=i; 
            }
        }

        return result; 
    }

        private int findIndexOfMin(char[] charArray) {
        char min = Character.MAX_VALUE; 
        int result = -1; 

        for (int i = 0; i < charArray.length; i++) {
            System.out.println(min);
            System.out.println(charArray[i]);

            if(Character.compare(charArray[i], min) < 0) {
                min=charArray[i]; 
                result=i; 
            }
        }

        return result; 
    }

    private void swap(char[] charArray, int x, int y) {
        char temp=charArray[x]; 
        charArray[x]=charArray[y]; 
        charArray[y]=temp; 
    }

    private int[] findKeyIndex(char[] charArray) {
        int[] result = new int[charArray.length]; 
        int currentIndex = 1; 

        for (int i = charArray.length; i >= 1; i--) {
            int minIndex = findIndexOfMin(charArray); 
            result[minIndex] = currentIndex; 
            charArray[minIndex] = Character.MAX_VALUE; 
            currentIndex++; 
        }

        return result; 
    }

    private char[] sortKeyCharacters() {
        char[] key_array = key.toCharArray(); 
        Arrays.sort(key_array);   
        return key_array; 
    } 

    public void debug() {
        System.out.println("Debug");
        System.out.println(key);
        System.out.println(width);
        System.out.println(hight);
        System.out.println(index_sum);

        for (char e : key_array) {
            System.out.println(e);            
        }

        
        for (int e : key_index) {
            System.out.println(e);            
        }
    }


}
