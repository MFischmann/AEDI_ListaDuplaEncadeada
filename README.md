# AEDI_ListaDuplaEncadeada
Exercícios de ListaDuplaEncadeada, disciplina Algoritmos e Estruturas de Dados I (aula 25/09/2019)

**Enunciado:**\
**PUCRS – Algoritmos e Estruturas de Dados I**\
**Exercícios de Lista Duplamente Encadeada**\
**Professora Isabel Harb Manssour**
1. Apresente um algoritmo para o método “**void add (int index, int element)**” da classe
_DoubleLinkedListOfInteger_, sabendo que ele deve inserir “*element*” na lista na posição indicada por
“*index*”. Lembre que o *index* deve ser válido, os atributos devem ser atualizados sempre que
necessário. Teste a sua implementação para este método na classe *App* e analise a
caracterização O do seu tempo de execução.
2. Apresente um algoritmo para o método “**public boolean remove (Integer element)**” da classe
*DoubleLinkedListOfInteger*, sabendo que ele deve procurar e remover da lista o elemento recebido
por parâmetro. Caso o elemento não seja encontrado, o método retorna falso. Não chame nenhum
outro método da classe *DoubleLinkedListOfInteger* na implementação da sua solução.
3. Implemente o método “**public Integer set(int index, Integer element)**” de maneira otimizada, isto
é, lembrando que se “*index*” for menor que “*size()/2*”, a lista deve ser percorrida do início para o
final, caso contrário, a lista deve ser percorrida do final para o início.
4. Acrescentar na classe *DoubleLinkedListOfInteger* um **método** que retorne uma String com o
conteúdo da lista de trás para frente. A assinatura deste método deve ser: “**public String
toStringBackToFront()** ”. Teste a sua implementação para este método na classe *App* e analise a
caracterização O do seu tempo de execução.
5. Acrescentar na classe *DoubleLinkedListOfInteger* o seguinte método: **public void reverse()**. Este
método inverte o conteúdo da lista. Teste a sua implementação para este método na classe *App* e
analise a caracterização O do seu tempo de execução.
6. Implemente um método que percorre a lista e retira elementos repetidos, deixando apenas uma
ocorrência de cada elemento. A assinatura deste método deve ser: **public void unique()**.Teste a
sua implementação para este método na classe *App* e analise a caracterização O do seu tempo de
execução.
