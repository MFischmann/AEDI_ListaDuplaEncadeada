
public class DoubleLinkedListOfInteger {
    
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Contador do numero de elementos da lista.
    private int count;

    private class Node {
        public Integer element;
        public Node next;
        public Node prev;
        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    /**
     * Metodo construtor.
     */
    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
		// Cria o nodo
        Node n = new Node(element);
		
		// Atualiza as referencias do nodo criado para liga-lo na lista
        Node last = trailer.prev;
        n.prev = last;
        n.next = trailer;
		
		// Atualiza as referencias para incluir o nodo criado
        last.next = n;
        trailer.prev = n;
		
		// Atualiza o contador
        count++;       
    }

    // Metodo privado que retorna a referência para o nodo
    // da posicao index, percorrendo a lista de forma otimizada.
    private Node getRefNode(int index) {
        Node aux = null;
        if (index <= count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        return aux;       
    }
    
    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
		// Verifica se o indice e´ valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
		
		// Pega a referencia para o nodo da posicao "index"
        Node aux = getRefNode(index);
		
		// Retorna o elemento da posicao "index"
        return aux.element;
    }
    
    /**
     * Remove o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
		// Verifica se o indice e´ valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
		
		// Pega a referencia para o nodo da posicao "index"
        Node aux = getRefNode(index);
		
		// Remove o nodo da lista
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
		
		// Atualiza o contador
        count--;
		
		// Retorna o elemento que foi removido
        return aux.element;
    }    
    
    /**
     * Insere um elemento em uma determinada posicao da lista
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) {
        // Implemente este método
        //TODO
    }
    
    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        // Implemente este método
        //TODO
        return false;
    }
    
   /**
    * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado
    * @param index a posicao da lista
    * @param element o elemento a ser armazenado na lista
    * @return o elemento armazenado anteriormente na posicao da lista
    * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
    */
    public Integer set(int index, Integer element) {
        // Implemente este método
        if(index >= count || index < 0){
            throw new IndexOutOfBoundsException("Indice nao valido");
        }
        Node aux = getRefNode(index); //ja usa busca otimizada
        int substituido = aux.element;
        aux.element = element; //substitui elemento
        return substituido;
    }
    //Retorna lista de tras para frente
    public String toStringBackToFront(){ //Caracterizacao O(n)
        String s = new String();
        Node aux = trailer.prev;
        for(int i = count-1; i >= 0; i--){
            s = s+ aux.element +"\n";
            aux = aux.prev;
        }
        return s;
    }

    //Inverte conteudo lista
    public void reverse(){ //Caracterizacao O(n)
        Node aux1 = header.next;
        Node aux2 = trailer.prev;
        int temp;

        for(int i = 0; i < count/2; i++){
            temp = aux1.element;
            aux1.element = aux2.element;
            aux2.element = temp;
            aux1 = aux1.next;
            aux2 = aux2.prev;
        }

    }

    //Percorre lista e retira elementos repetidos
    public void unique(){ //Caracterizacao O(n^2)
        Node aux_base = header.next; //nodo do elemento base
        Node aux_comp; //nodo do elemento a ser comparado com o elemento base
        while(aux_base.next != trailer){ //while necessario, pois muda dinamicamente o tamanho da lista
            aux_comp = aux_base.next; //seta para nodo seguinte do base
            while(aux_comp!=trailer){
                if(aux_base.element==aux_comp.element){
                    //remove elemento
                    //nao chama metodo de remover, pois aumentaria caracterizacao O
                    aux_comp.prev.next = aux_comp.next;
                    aux_comp.next.prev = aux_comp.prev;
                    count--;
                }
                aux_comp = aux_comp.next;
            }
            aux_base = aux_base.next;
        }
        
    }

    /**
     * Retorna um arranjo com os elementos da lista original entre fromIndex (inclusivo) e toIndex (exclusivo)
     * @param fromIndex posicao inicial do elemento a ser copiado (inclusivo)
     * @param toIndex posicao final do elemento a ser copiado (exclusivo)
     * @throws IndexOutOfBoundsException se fromIndex ou toIndex nao validos    
     * @return o arranjo com os elementos
     */
    public int[] subList(int fromIndex, int toIndex){
        if(fromIndex < 0 || toIndex >= count){
            throw new IndexOutOfBoundsException("Parametros fora dos limites da lista");
        }

        if(fromIndex >= toIndex){
            throw new IndexOutOfBoundsException("toIndex deve ser maior do que fromIndex");
        }
        
        int[] slst = new int[toIndex-fromIndex];

        Node aux = getRefNode(fromIndex);
        for(int i = 0; i < toIndex-fromIndex; i++){
            slst[i] = aux.element;
            aux = aux.next;
        }
        return slst;
    }

    /**
     * Conta o numero de ocorrencias do elemento passado como parametro na lista
     * @param element elemento a ser contado
     * @return occ numero de ocorrencias na lista
     */
    public int contaOcorrencias(int element){
        int occ = 0;
        Node aux = header.next;
        for(int i = 0; i < count; i++){
            if(element == aux.element){
                occ++;
            }

            aux = aux.next;
        }

        return occ;
    }

    /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = header.next;
        while (aux != trailer) {
            if (aux.element.equals(element)) {
                return (true);
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }
    
    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }    
        
    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }
    
    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }
        
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }    
       
}
