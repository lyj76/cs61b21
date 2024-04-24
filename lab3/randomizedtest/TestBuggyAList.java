package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE



    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();


        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size2 = broken.size();
                System.out.println("size: " + size+" "+size2);
                org.junit.Assert.assertEquals(size,size2);
            }
            else if ((operationNumber == 2)&&(L.size() > 0 && broken.size() >0))  {
                int a=0, b =0;


                     a = L.getLast();
                     b = broken.getLast();

                System.out.println("size: " + a +" "+b);
                org.junit.Assert.assertEquals(a,b);
            }
            else if ((operationNumber == 3)&&(L.size() > 0 && broken.size() >0))  {
                int a=0, b =0;


                    a = L.removeLast();
                    b = broken.removeLast();

                System.out.println("size: " + a +" "+b);
                org.junit.Assert.assertEquals(a,b);
            }
        }
    }
}
