import java.util.ArrayList;

public class blockchain {
    ArrayList<block> ArchChain = new ArrayList<block>();
    blockchain(){
    //Here we will create gensis block
        block genesis = new block();
        genesis.presentHash = "0";
        genesis.prevHash = "0";
        System.out.printf("Worked till this point ");
        ArchChain.add(genesis);
    }

    void addNewBlock(block e){
        //Set the prevHash
        e.setPrevHash(ArchChain.get(ArchChain.size()-1).getPresentHash());
        //set the block Number
        e.setBlockNumber(ArchChain.size());
        //Set the PresentHash
        e.calculatePresentHash();
        ArchChain.add(e);
    }

    block getBlockAtHeight(int height){
        return ArchChain.get(height);
    }


}
