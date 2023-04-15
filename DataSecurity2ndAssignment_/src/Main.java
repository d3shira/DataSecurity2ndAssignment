import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!!!!!!!!!!!!!!!!!");
    }
}
class VigenereCipher{
    private int[] key;

    public VigenereCipher(int seed) {
        Random rand = new Random(seed);
        this.key = new int[100];
        for (int i = 0; i < this.key.length; i++) {
            this.key[i] = rand.nextInt(26);
        }
    }

    public VigenereCipher(String seed) {
        int sum = 0;
        for (int i = 0; i < seed.length(); i++) {
            sum += (int)Character.toUpperCase(seed.charAt(i));
        }
        Random rand = new Random(sum);
        this.key = new int[100];
        for (int i = 0; i < this.key.length; i++) {
            this.key[i] = rand.nextInt(26);
        }
    }
    
    public String decrypt(String message) {
        StringBuilder decrypted = new StringBuilder();
        int keyIndex = 0;
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                int key = this.key[keyIndex];
                char newChar = (char)(((Character.toUpperCase(c) - 'A' - key + 26) % 26) + 'A');
                decrypted.append(newChar);
                keyIndex = (keyIndex + 1) % this.key.length;
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}
