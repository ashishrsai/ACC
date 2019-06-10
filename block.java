import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class block {
    int blockNumber;
    String prevHash;
    String presentHash;
    //block Block = new block();
    int attributeID = 0;
    ArrayList<Integer> dependencies = new ArrayList<Integer>();

    void setBlockNumber(int blockNo){
        blockNumber = blockNo;
    }

    void addBlock(block e){
        //This should also have an ArrayList of blocks
    }

    void setPrevHash(String prevHash){
        prevHash = prevHash;
    }

    String getPresentHash(){
        return presentHash;
    }

    void calculatePresentHash(){

        String sumOFTheBlockString = String.valueOf(blockNumber)+prevHash+String.valueOf(attributeID)+dependencies.toString();
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");


            byte[] messageDigest = md.digest(sumOFTheBlockString.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);


            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            presentHash = hashtext;

            System.out.println("The present hash of the block is = "+presentHash );
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown"
                    + " for incorrect algorithm: " + e);

            presentHash = "ERROR";
        }
    }
}
