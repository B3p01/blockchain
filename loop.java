import java.math.BigInteger; 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
  
// Java program to calculate SHA hash value 
  
class GFG { 
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    { 
        // Static getInstance method is called with hashing SHA 
        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
  
        // digest() method called 
        // to calculate message digest of an input 
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8)); 
    }
    
    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation 
        BigInteger number = new BigInteger(1, hash); 
  
        // Convert message digest into hex value 
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
  
        // Pad with leading zeros
        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        } 
  
        return hexString.toString(); 
    }
  
    // Driver code 
    public static void main(String args[])
    { 
        try 
        {
            int t = 10000000;
            String hash;
            String genesis = "Genesis";
            String genout = "Block 0: Genesis Block Minted";
            System.out.println("Hash Timer"); 
            System.out.println(genout);
            
            for (int i=1; i<t; i++)
            {  
               hash = String.valueOf(i);
               genesis = genesis + hash;
               System.out.println("Block " + i + ": " + toHexString(getSHA(genesis)));
            }
            
        }
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            System.out.println("Exception thrown for incorrect algorithm: " + e); 
        } 
    } 
} 
         