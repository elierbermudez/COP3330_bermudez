public class Git_Sample {
    public static void main(String[] args){
        Encrypter myEncrypter = new Encrypter();
        String encryptedValue = myEncrypter.encrypt("1234");
        //encrypts "1234" to "0189"
        System.out.println(encryptedValue);

        Decrypter myDecrypter = new Decrypter();
        String decryptedValue = myDecrypter.decrypt("0189");
        //decrypts "0189" to "1234"
        System.out.println(decryptedValue);
    }
}