
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();
        lista.add(10);
        lista.add(21);
        lista.add(32);
        lista.add(43);
        lista.add(54);
        lista.add(43);
        lista.add(54);
        lista.add(65);
        lista.add(54);
        lista.add(65);
        lista.add(76);
        lista.add(76);
        lista.add(97);
        lista.add(54);        
        
        System.out.println("Conteudo da lista:\n"+lista);
        
        System.out.println("Elemento da posicao 0: " +lista.get(0));
        System.out.println("Elemento da posicao 2: " +lista.get(2));  
        System.out.println("Elemento da posicao 5: " +lista.get(5));          
        System.out.println("Elemento da posicao 7: " +lista.get(7));
        
        //lista.removeByIndex(0);
        //lista.removeByIndex(6);
        //lista.removeByIndex(2);

        //System.out.println("\nConteudo da lista apos remover elementos das posicoes 0,6 e 2 (nesta ordem):\n"+lista);        
        
        int[] slst1 = lista.subList(1, 4);
        String s = "Elementos sublista: ";
        for(int j = 0; j < slst1.length; j++){
            s= s + slst1[j] + " ";
        }
        System.out.println(s);


        System.out.println("Contagem ocorrencias (97): "+ lista.contaOcorrencias(97));
        System.out.println("Contagem ocorrencias (54): "+ lista.contaOcorrencias(54));
        System.out.println("Contagem ocorrencias (11): "+ lista.contaOcorrencias(11));

        System.out.println("Conteudo da lista:\n"+lista);
        lista.reverse();
        System.out.println("Conteudo da lista invertida:\n"+lista);
        lista.reverse(); //retorna lista ordem original

        System.out.println("Metodo toString():\n"+ lista.toString());
        System.out.println("Metodo toStringBackToFront():\n"+ lista.toStringBackToFront());


        System.out.println("Lista antes metodo unique:\n" + lista);
        System.out.println("Tamanho da lista antes metodo unique: " + lista.size());
        lista.unique();
        System.out.println("Lista apos metodo unique:\n" + lista);
        System.out.println("Tamanho da lista apos metodo unique: " + lista.size());

        System.out.println("Substitui elemento posicao 0 por 12. Elemento original: " + lista.set(0, 12));
        System.out.println("Substitui elemento posicao 0 por 9. Elemento original: " + lista.set(0, 9));
        System.out.println("Substitui elemento posicao 7 por 98. Elemento original: " + lista.set(7, 98));
        System.out.println("Substitui elemento posicao 4 por 3. Elemento original: " + lista.set(4, 3));
        System.out.println("Lista apos utilizar metodo set: \n" + lista);

        System.out.println("Remove elemento 3: "+lista.remove(3));
        System.out.println("Remove elemento 32: "+lista.remove(32));
        System.out.println("Remove elemento 17: "+lista.remove(17));
        System.out.println(lista);
    }
}
