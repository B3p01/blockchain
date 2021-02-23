// Block.java
import java.util.Date;

public class Block
{
   public String hash, prevHash; 
   private String data;
   private long timeStamp;
   
   public Block(String data, String previousHash)
   {
      this.data = data;
      this.prevHash = prevHash;
      this.timeStamp = new Date().getTime();
      this.hash = calculateHash();
   }
   
   public String calculateHash()
   {
      String calculatedhash = StringUtility.applySHA256(prevHash+Long.toString(timeStamp)+data);
      return calculatedhash;
   }
}