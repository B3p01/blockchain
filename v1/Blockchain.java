// Blockchain.java            Author: B. Rowe
// demonstrates simple blockchain concepts

public class Blockchain
{
   public static void main(String[] args)
   {
      Block genesisBlock = new Block("Hi im the first block", "0");
      System.out.println("Hash for block 1: " + genesisBlock.hash);
      
      Block secondBlock = new Block("Hey im the second block",genesisBlock.hash);
      System.out.println("Hash for block 2: " + secondBlock.hash);
      
      Block thirdBlock = new Block("Hello im the third block",secondBlock.hash);
      System.out.println("Hash for block 3: " + thirdBlock.hash);
   }
}