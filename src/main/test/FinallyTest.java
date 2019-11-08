
import java.util.ArrayList;
import java.util.List;


/**
 * Created by zengyouzu on 2019/11/5.
 */
public class FinallyTest {
    public static void main(String[] args) {
        //try-cach 异常退出
        try {
            // do something
            System.exit(1);
        } finally {
            System.out.println("Print from finally");
        }

        //死循环
        try {
            while (true){
                System.out.println("Print from finally");
            }
        } finally {
            System.out.println("Print from finally");
        }
    }
}