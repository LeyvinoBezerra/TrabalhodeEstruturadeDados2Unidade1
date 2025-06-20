package br.edu.ufersa;

public class ArvoreAVL {
    NoAVL raiz;

    int altura(NoAVL no) {
        return no == null ? 0 : no.altura;
    }

    int fatorBalanceamento(NoAVL no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    NoAVL rotacaoDireita(NoAVL y) {
        System.out.println("Rotação à direita em " + y.chave);
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;
        x.direita = y;
        y.esquerda = T2;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        return x;
    }

    NoAVL rotacaoEsquerda(NoAVL x) {
        System.out.println("Rotação à esquerda em " + x.chave);
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;
        y.esquerda = x;
        x.direita = T2;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        return y;
    }

    NoAVL inserir(NoAVL no, int chave, RegistroClimatico referencia) {
        if (no == null) return new NoAVL(chave, referencia);
        if (chave < no.chave)
            no.esquerda = inserir(no.esquerda, chave, referencia);
        else if (chave > no.chave)
            no.direita = inserir(no.direita, chave, referencia);
        else return no;

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        int balance = fatorBalanceamento(no);

        if (balance > 1 && chave < no.esquerda.chave) {
            System.out.println("Rotação simples à direita necessária em " + no.chave);
            return rotacaoDireita(no);
        }
        if (balance < -1 && chave > no.direita.chave) {
            System.out.println("Rotação simples à esquerda necessária em " + no.chave);
            return rotacaoEsquerda(no);
        }
        if (balance > 1 && chave > no.esquerda.chave) {
            System.out.println("Rotação dupla esquerda-direita necessária em " + no.chave);
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        if (balance < -1 && chave < no.direita.chave) {
            System.out.println("Rotação dupla direita-esquerda necessária em " + no.chave);
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }
        return no;
    }

    public void inserir(int chave, RegistroClimatico referencia) {
        raiz = inserir(raiz, chave, referencia);
        System.out.println("Altura da árvore após inserção: " + altura(raiz));
    }

    public RegistroClimatico buscar(int chave) {
        NoAVL atual = raiz;
        while (atual != null) {
            if (chave < atual.chave) atual = atual.esquerda;
            else if (chave > atual.chave) atual = atual.direita;
            else return atual.referencia;
        }
        return null;
    }
}
