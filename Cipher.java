public class Cipher {

    private final static String key = "BALATON"; 

    public static void main(String[] args) {
        CodingMatrix codingMatrix = new CodingMatrix(key); 
        codingMatrix.debug();
    }

}