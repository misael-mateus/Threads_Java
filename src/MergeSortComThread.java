import java.util.Arrays;

public class MergeSortComThread {
    // EXERCICIO
// REESCREVA O CÓDIGO UTILIZANDO THREADS
// ATENÇÃO: vetor e aux pertencem à área compartilhada
    Object[] vetor;
    Object[] aux;

    public void sort(Object[] vetor) {
        this.vetor = vetor;
        this.aux = new Object[vetor.length];
        sort(0, vetor.length - 1);
    }

    private void sort(int ini, int fim) {
        if ((fim - ini) < 1) return;
        var meio = (fim + ini) / 2;
        var t1 = new Thread(() -> sort(ini, meio));
        t1.start();
        var t2 = new Thread(() -> sort(meio + 1, fim));
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        merge(ini, meio, fim);
    }

    private void merge(int ini, int meio, int fim) {
        int i, j, ai, aj;
        for (i = 0; i < aux.length; i++) aux[i] = null;
        //1ª metade crescente, 2ª metade decrescente
        for (i = ini; i <= meio; i++) this.aux[i] = this.vetor[i];
        for (j = fim; i <= fim; i++, j--) this.aux[i] = this.vetor[j];

        ai = ini;
        aj = fim;
        for (i = ini; i <= fim; i++) {
            var a = (Comparable) this.aux[ai];
            var b = this.aux[aj];
            if (a.compareTo(b) <= 0) {
                this.vetor[i] = this.aux[ai];
                ai++;
            } else {
                this.vetor[i] = this.aux[aj];
                aj--;
            }
        }
    }

    public static void main(String[] args) {
        //10000000000000000
        int f = 1 << 3;
        Object[] v = new Integer[f];
        for (int i = 0; i < f; i++) {
            v[i] = (int) Math.round(Math.random() * 7 * f);
        }
        System.out.println(Arrays.toString(v));
        var ms = new MergeSort();
        long a = System.currentTimeMillis();
        ms.sort(v);
        long b = System.currentTimeMillis();
        System.out.println(Arrays.toString(v));
        System.out.println(b - a);

    }
}
