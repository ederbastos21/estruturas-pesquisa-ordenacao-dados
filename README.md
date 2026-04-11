# Estruturas, Pesquisa e Ordenação de Dados – 2026/1

> **Avaliação Prática Bimestral | 1º Bimestre**
> Disciplina: Estruturas, Pesquisa e Ordenação de Dados
> Curso: Tecnologia em Análise e Desenvolvimento de Sistemas
> Instituição: UniCesumar – Campus Ponta Grossa
> Professor: Prof. MSc. Gabriel Passos de Jesus

---

## Sumário

- [Visão Geral](#visão-geral)
- [Tecnologias e Requisitos](#tecnologias-e-requisitos)
- [Estrutura do Repositório](#estrutura-do-repositório)
- [Como Compilar e Executar](#como-compilar-e-executar)
  - [Pré-requisitos](#pré-requisitos)
  - [Clonando o Repositório](#clonando-o-repositório)
  - [Build com Maven](#build-com-maven)
  - [Executando os Projetos](#executando-os-projetos)
- [Projeto 1 – Árvores e Balanceamento](#projeto-1--árvores-e-balanceamento)
- [Projeto 2 – Sistemas de Busca](#projeto-2--sistemas-de-busca)
- [Projeto 3 – Benchmark de Ordenação](#projeto-3--benchmark-de-ordenação)
- [Metodologia Experimental](#metodologia-experimental)
- [Documentação Técnica](#documentação-técnica)
- [Integrantes](#integrantes)

---

## Visão Geral

Este repositório contém os três projetos práticos desenvolvidos para a avaliação do 1º bimestre da disciplina de **Estruturas, Pesquisa e Ordenação de Dados**. O objetivo central é consolidar os fundamentos teóricos de estruturas de dados por meio de implementações manuais dos algoritmos — sem uso de bibliotecas prontas, análise formal de complexidade assintótica e metodologia experimental com análise estatística.

| Projeto | Tema |
|---------|------|
| Projeto 1 | Árvores e Balanceamento (BST, AVL, Rubro-Negra + TSP) |
| Projeto 2 | Sistemas de Busca (Sequencial, Binária, em Árvore) |
| Projeto 3 | Benchmark de Ordenação (5 algoritmos) |

---

## Tecnologias e Requisitos

- **Linguagem:** Java (utilizado JDK 21)
- **Build:** Apache Maven 3.9+
- **Sem necessidade de uso de dependências externas.**

---

## Estrutura do Repositório

```
estruturas-pesquisa-ordenacao-dados/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── br/
                └── unicesumar/
                    ├── projeto_1/
                    │   ├── bst/
                    │   │   ├── BinarySearchTree.java
                    │   │   ├── Node.java
                    │   │   └── Main.java
                    │   ├── avl/
                    │   │   ├── AVLTree.java
                    │   │   ├── Node.java
                    │   │   └── Main.java
                    │   ├── rubro_negra/
                    │   │   ├── RBT.java
                    │   │   ├── Node.java
                    │   │   └── Main.java
                    │   └── tsp/
                    │       ├── TSP.java
                    │       └── Main.java
                    ├── projeto_2/
                    │   ├── busca_sequencial/
                    │   │   └── Main.java
                    │   ├── busca_binaria/
                    │   │   └── Main.java
                    │   └── busca_arvore_busca/
                    │       └── Main.java
                    └── projeto_3/
                        ├── bubble_sort/
                        │   └── Main.java
                        ├── insertion_sort/
                        │   └── Main.java
                        ├── merge_sort/
                        │   └── Main.java
                        ├── quick_sort/
                        │   └── Main.java
                        └── heap_sort/
                            └── Main.java
```

Cada subpacote é autocontido e possui seu próprio `Main.java`, responsável por instanciar a estrutura e algoritmo correspondente, executar os experimentos e imprimir os resultados estatísticos no terminal.

---

## Como Compilar e Executar

### Pré-requisitos

Certifique-se de ter instalados e configurados no `PATH` do sistema:

- [Oracle JDK 21](https://www.oracle.com/java/technologies/downloads/#java21) (ou JDK 21 equivalente)
- [Apache Maven 3.9+](https://maven.apache.org/download.cgi)

Verifique as instalações:

```bash
java -version
# java version "21.0.0" ...

mvn -version
# Apache Maven 3.9.x
```

### Clonando o Repositório

```bash
git clone https://github.com/ederbastos21/estruturas-pesquisa-ordenacao-dados.git
cd estruturas-pesquisa-ordenacao-dados
```

### Build com Maven

Para compilar todo o projeto:

```bash
mvn compile
```

---

### Executando os Projetos

Cada algoritmo é executado individualmente pela sua própria classe `Main`. Os comandos abaixo usam o plugin `exec` do Maven a partir da raiz do repositório.

#### Projeto 1 – Árvores e Balanceamento

```bash
# Árvore BST
mvn exec:java -Dexec.mainClass="br.unicesumar.projeto_1.bst.Main"

# Árvore AVL
mvn exec:java -Dexec.mainClass="br.unicesumar.projeto_1.avl.Main"

# Árvore RBT
mvn exec:java -Dexec.mainClass="br.unicesumar.projeto_1.rubro_negra.Main"

# Heurística TSP (Caixeiro Viajante)
mvn exec:java -Dexec.mainClass="br.unicesumar.projeto_1.tsp.Main"
```

#### Projeto 2 – Sistemas de Busca

```bash
# Busca Sequencial
mvn exec:java -Dexec.mainClass="br.unicesumar.projeto_2.busca_sequencial.Main"

# Busca Binária
mvn exec:java -Dexec.mainClass="br.unicesumar.projeto_2.busca_binaria.Main"

# Busca em Árvore de Busca
mvn exec:java -Dexec.mainClass="br.unicesumar.projeto_2.busca_arvore_busca.Main"
```

#### Projeto 3 – Benchmark de Ordenação

```bash
# Bubble Sort
mvn exec:java -Dexec.mainClass="br.unicesumar.projeto_3.bubble_sort.Main"

# Insertion Sort
mvn exec:java -Dexec.mainClass="br.unicesumar.projeto_3.insertion_sort.Main"

# Merge Sort
mvn exec:java -Dexec.mainClass="br.unicesumar.projeto_3.merge_sort.Main"

# Quick Sort
mvn exec:java -Dexec.mainClass="br.unicesumar.projeto_3.quick_sort.Main"

# Heap Sort
mvn exec:java -Dexec.mainClass="br.unicesumar.projeto_3.heap_sort.Main"
```

> **Alternativa para execução sem Maven:** após `mvn package`, execute diretamente via:
> ```bash
> java -cp target/estrutura-dados-1.0-SNAPSHOT.jar br.unicesumar.projeto_1.bst.Main
> ```
> Substitua o caminho da classe conforme o módulo desejado.

---

## Projeto 1 – Árvores e Balanceamento

### Estruturas Implementadas

**Árvore Binária de Busca (`bst/`)** — implementação clássica sem balanceamento automático. As operações de inserção e busca têm complexidade O(log n) em média para árvores balanceadas, mas degradam para O(n) no pior caso (sequência ordenada de inserções).

**Árvore AVL (`avl/`)** — extensão da BST com balanceamento automático por fator de balanço. Após cada inserção ou remoção, a árvore verifica o fator de balanço de cada nó e aplica rotações simples (LL, RR) ou duplas (LR, RL) conforme necessário. Garante altura O(log n) em todos os casos.

**Árvore Rubro-Negra (`rubro_negra/`)** — implementação com as cinco propriedades clássicas da Red-Black Tree. O balanceamento é mantido por recoloração de nós e rotações, garantindo que a altura nunca ultrapasse 2·log(n+1).

Todas as três estruturas implementam as seguintes operações, seguindo todas exigências do edital:

| Operação | BST | AVL | Rubro-Negra |
|----------|:---:|:---:|:-----------:|
| Inserção | Y | Y | Y |
| Remoção | Y | Y | Y |
| Busca | Y | Y | Y |
| Cálculo de Altura | Y | Y | Y |

Legenda: [Y]es e [N]o

### Heurística para o Problema do Caixeiro-Viajante (`tsp/`)

Implementação de heurística aproximada para o TSP. A solução é avaliada experimentalmente com no mínimo três tamanhos distintos de entrada e 30 execuções por experimento, com análise estatística dos resultados.

---

## Projeto 2 – Sistemas de Busca

### Algoritmos Implementados

**Busca Sequencial (`busca_sequencial/`)** — percorre a estrutura linearmente, elemento a elemento, sem qualquer pré-condição sobre a ordenação dos dados. Complexidade O(n) no pior caso.

**Busca Binária (`busca_binaria/`)** — opera sobre arrays ordenados, dividindo o espaço de busca pela metade a cada passo. Complexidade O(log n). O array é ordenado previamente antes da execução dos experimentos.

**Busca em Árvore de Busca (`busca_arvore_busca/`)** — utiliza uma árvore binária de busca como estrutura de suporte. Complexidade média O(log n) para árvores aproximadamente balanceadas; pior caso O(n) para árvore degenerada.

### Experimentos – Projeto 2

Os experimentos comparam o tempo de busca empírico com a complexidade teórica esperada para diferentes volumes de dados, com 30 execuções por cenário. São reportadas média aritmética e desvio padrão dos tempos coletados.

---

## Projeto 3 – Benchmark de Ordenação

O edital exigia a implementação de (ao menos) dois algoritmos dentre os listados. Optou-se por implementar **todos os cinco**, ampliando o escopo comparativo dos experimentos.

### Algoritmos Implementados

| Algoritmo | Melhor Caso | Caso Médio | Pior Caso | In-place | Estável |
|-----------|:-----------:|:----------:|:---------:|:--------:|:-------:|
| Bubble Sort | O(n) | O(n²) | O(n²) | Y | Y |
| Insertion Sort | O(n) | O(n²) | O(n²) | Y | Y |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | N | Y |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | Y | N |
| Heap Sort | O(n log n) | O(n log n) | O(n log n) | Y | N |

Legenda: [Y]es e [N]o

### Cenários de Teste

Cada algoritmo é avaliado nos três casos clássicos de complexidade:

| Cenário | Configuração do array |
|---------|-----------------------|
| Melhor caso | Já ordenado em ordem crescente |
| Caso médio | Elementos em ordem aleatória |
| Pior caso | Ordenado em ordem decrescente |

São realizadas **30 execuções** para cada combinação de algoritmo × cenário × tamanho de entrada, com coleta de tempo via `System.nanoTime()`.

---

## Metodologia Experimental

Todos os experimentos deste repositório seguem a mesma metodologia para garantir reprodutibilidade e rigor estatístico:

- **Geração de dados:** arrays gerados com `java.util.Random` com seed fixo, garantindo que qualquer pessoa que execute o código obtenha os mesmos dados de entrada.
- **Aquecimento da JVM:** as primeiras iterações de cada série são descartadas para mitigar a interferência do compilador JIT.
- **Coleta de tempo:** uso exclusivo de `System.nanoTime()`, evitando a granularidade insuficiente de `currentTimeMillis()`.
- **Repetições:** 30 execuções independentes por experimento, conforme especificado no edital.
- **Estatísticas reportadas:**
  - Média aritmética (x̄)
  - Desvio padrão amostral (s)
- **Saída:** os resultados são impressos no console ao final de cada execução, em formato tabular para facilitar a análise e a transcrição para o relatório técnico, bem como auxílio para debug.

---

## Documentação Técnica

Os relatórios técnicos em PDF - contendo Introdução, Fundamentação Teórica, Análise Assintótica, Metodologia Experimental, Resultados, Discussão e Conclusão - estão disponíveis no diretório `/docs`

---

## Integrantes

| Nome | GitHub |
|------|--------|
| Eder Bastos | [@ederbastos21](https://github.com/ederbastos21) |
| Amauri B. S. Jr. | [@amauribsjr](https://github.com/amauribsjr) |
| Gustavo Bayer | [@gustabayer](https://github.com/gustabayer) |
| Gabriel Lazarine | [@Gabriellazarine](https://github.com/Gabriellazarine) |
| Carlos Aplewicz | [@aplewicz](https://github.com/aplewicz) |
| Rullian Paitch | [@rullianpeep19-dotcom](https://github.com/rullianpeep19-dotcom) |

---

- **OBS.:** A contribuição dos integrantes foi realizada integralmente nesse repositório com commits e pull requests, cada integrante compôs sua contribuição em branches separadas.
