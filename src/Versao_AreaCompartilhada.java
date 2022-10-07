import java.util.Arrays;

//Fibonacci
//0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584
public class Versao_AreaCompartilhada {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Versão 3");
        var qq = new myClass();
        var t1 = new Thread(qq::metodo01);
        var t2 = new Thread(qq::metodo01);
        var t3 = new Thread(qq::metodo01);
        t1.start(); t2.start(); t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println();
        System.out.println(Arrays.toString(qq.vetor));
        //pesquisar sobre o join
        //pesquisar sobre o syncronized
    }
}

class myClass {
     int[] vetor;
     int   i;

    public myClass() {
        this.vetor = new int[14];
        this.i=2;
        vetor[0] = 1;
        vetor[1] = 1;
    }

    public void metodo01(){
        //var id = Thread.currentThread().threadId();
        this.soma();
        this.soma();
        this.soma();
        this.soma();
    }
    public synchronized void soma(){
        vetor[i] = vetor[i-1] + vetor[i-2];
        System.out.print(vetor[i]+", ");
        //var x = new Integer(4);
        i++;
    }
}

