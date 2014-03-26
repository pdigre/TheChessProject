public class HelloJNI {
   static {
      System.loadLibrary("hello"); // hello.dll (Windows) or libhello.so (Unixes)
   }
   private native void sayHello();
 
   public static void main(String[] args) {
      new HelloJNI().sayHello();  // invoke the native method
   }
}