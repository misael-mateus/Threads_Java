import java.util.concurrent.atomic.AtomicInteger;

public class Versao03 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Versão 3");
        AtomicInteger s = new AtomicInteger();
        var qq = new Qualquer();
        new Thread(qq::metodo01).start();
        new Thread(qq::metodo01).start();
        new Thread(qq::metodo01).start();
        var t = new Thread(() -> s.set(qq.soma(5, 6)));
        t.start();
        t.join();
        System.out.println(s.get());
    }
}

class Qualquer{
    public void metodo01(){
        var id = Thread.currentThread().threadId();
        System.out.print(id+", ");
        System.out.print(id+", ");
        System.out.print(id+", ");
        System.out.println(id);
    }
    public int soma(int a, int b){
        return a+b;
    }
}

