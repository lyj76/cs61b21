package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class testThreeAddThreeRemove {

    @Test
    public void test(){
        AListNoResizing<Integer> L = new AListNoResizing<Integer>();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);

        BuggyAList<Integer> B = new BuggyAList<>();
        B.addLast(1);
        B.addLast(2);
        B.addLast(3);

        org.junit.Assert.assertEquals(L.removeLast(),B.removeLast());
        org.junit.Assert.assertEquals(L.removeLast(),B.removeLast());
        org.junit.Assert.assertEquals(L.removeLast(),B.removeLast());



    }


}
