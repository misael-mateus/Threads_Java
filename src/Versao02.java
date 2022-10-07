import java.util.Arrays;

public class Versao02 {
    public static void main(String[] args) {
        System.out.println("Versao 2");
        var myrunnable = new MyRunnable(2);
        new Thread(myrunnable).start();
        new Thread(myrunnable).start();
        new Thread(myrunnable).start();
    }
}

class MyRunnable implements Runnable{
    int[] k;

    public MyRunnable(int x) {
        this.k = new int[x];
        k[0] = 55;
        k[1] = 12;
    }

    @Override
    public void run() {
        var id = Thread.currentThread().threadId();
        System.out.print(id+", ");
        System.out.print(id+", ");
        System.out.print(id+", ");
        System.out.println(id);
        System.out.println(Arrays.toString(k));
    }
}
