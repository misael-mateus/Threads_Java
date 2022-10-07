public class Versao01 {
    public static void main(String[] args) {
        System.out.println("Versão 1");
        new MyThread(2).start(); //não use .run()
        new MyThread(4).start(); //não use .run()
        new MyThread(5).start(); //não use .run()
        new MyThread(7).start(); //não use .run()
    }
}

class MyThread extends Thread{
    int k;

    public MyThread(int k) {
        this.k = k;
    }

    @Override
    public void run() {
        var id = this.threadId();
        System.out.printf("%d(%d)",id,k);
        System.out.printf("%d(%d)",id,k);
        System.out.printf("%d(%d)",id,k);
        System.out.printf("%d(%d)\n",id,k);
    }
}
