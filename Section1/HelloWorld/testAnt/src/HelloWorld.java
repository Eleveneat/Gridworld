import java.util.*;

public class HelloWorld {
   String str;
   public void hello() {
      str = "Hello World!";
   }


   public String getStr() {
      return str;
   }

   public void clear() {
      str = "";
   }
    public static void main(String[] args) {
    	HelloWorld hw = new HelloWorld();
    	hw.hello();
    	System.out.println(hw.getStr());
    }
}
