# Perceptron com três entradas — exemplo de classificação

## 1. Descrição do projeto

Este projeto implementa, em Java, um **Perceptron** com três entradas, seguindo o Exemplo 2.13, página 69, do livro *Fundamentals of Neural Networks*, de Laurene V. Fausett.

O programa treina o Perceptron com quatro padrões de entrada, ajustando os pesos e o bias sempre que a saída calculada for diferente do alvo esperado. Depois do treinamento, permite testar os padrões por meio de caixas de diálogo.

> **Nota sobre o exemplo:** o comentário do código identifica o programa como “Teste Perceptron”, e não especifica explicitamente o nome de uma função lógica. Por isso, este README descreve os padrões e alvos conforme estão definidos no código, sem atribuir uma função lógica que não esteja indicada na fonte.

## 2. Objetivos

- Implementar o algoritmo Perceptron em Java.
- Treinar uma rede com três entradas binárias.
- Utilizar alvos bipolares (`1` e `-1`).
- Calcular a soma ponderada das entradas e aplicar uma função de ativação.
- Atualizar os pesos e o bias quando a saída for diferente do alvo.
- Registrar as estatísticas por época e permitir testes interativos.

## 3. Conjunto de treinamento

O programa define quatro padrões de entrada na matriz `s` e os respectivos alvos no vetor `alvo`.

| Padrão (índice) | `x1` | `x2` | `x3` | Alvo |
|---:|---:|---:|---:|---:|
| 0 | 1 | 1 | 1 | 1 |
| 1 | 1 | 1 | 0 | -1 |
| 2 | 1 | 0 | 1 | -1 |
| 3 | 0 | 1 | 1 | -1 |

A variável `num` indica que existem quatro padrões, e `n` define três entradas por padrão. Os valores de entrada são binários (`0` e `1`), enquanto os alvos são bipolares (`1` e `-1`).

## 4. Conceito de Perceptron

O Perceptron é um modelo de rede neural artificial que calcula a soma ponderada das entradas e adiciona um bias. O resultado é utilizado pela função de ativação para determinar a saída da rede.

A soma de entrada é calculada por:

\[
y_{in} = \sum_{i=1}^{n} x_i w_i + b
\]

Em que:

- `x_i` representa uma entrada;
- `w_i` representa o peso associado à entrada;
- `b` representa o bias;
- `n` é a quantidade de entradas;
- `y_in` é a soma ponderada antes da ativação.

## 5. Função de ativação

O código utiliza uma função de ativação com três possíveis saídas, determinada pelo parâmetro `omega`.

| Condição | Saída `y` |
|---|---:|
| `y_in > omega` | `1` |
| `-omega <= y_in <= omega` | `0` |
| `y_in < -omega` | `-1` |

O parâmetro `omega` recebe `0.1`. Assim, a saída é `1` quando `y_in > 0.1`, `0` quando `y_in` está entre `-0.1` e `0.1`, inclusive, e `-1` quando `y_in < -0.1`.

## 6. Regra de aprendizagem

O programa compara a saída calculada (`y`) com o alvo esperado (`t`). Quando são diferentes, os pesos e o bias são atualizados.

A atualização de cada peso é:

\[
w_i \leftarrow w_i + \alpha \cdot t \cdot x_i
\]

A atualização do bias é:

\[
b \leftarrow b + \alpha \cdot t
\]

A taxa de aprendizagem `alfa` recebe o valor `1`. As atualizações acontecem apenas quando `y != t`; caso contrário, os parâmetros permanecem inalterados para o padrão atual.

## 7. Como o programa funciona

A implementação está concentrada no método `main` da classe `Principal`. O programa executa as seguintes etapas:

1. Define os quatro padrões de entrada e seus alvos.
2. Define a taxa de aprendizagem, o threshold e o número máximo de épocas.
3. Inicializa os três pesos e o bias com zero.
4. Percorre cada padrão e calcula a soma de entrada `y_in`.
5. Aplica a função de ativação para obter a saída `y`.
6. Compara a saída com o alvo e atualiza os pesos e o bias quando forem diferentes.
7. Registra se houve alguma atualização durante a época.
8. Repete o treinamento enquanto não atingir o limite de épocas e enquanto houver alterações nos pesos ou no bias.
9. Apresenta as estatísticas acumuladas.
10. Permite ao usuário selecionar um dos quatro padrões para testar a rede treinada.

### 7.1 Parâmetros utilizados

| Parâmetro | Valor utilizado | Significado |
|---|---:|---|
| `num` | `4` | Quantidade de padrões do conjunto de treinamento. |
| `n` | `3` | Quantidade de entradas por padrão. |
| `alfa` | `1` | Taxa de aprendizagem para atualizar os pesos e o bias. |
| `omega` | `0.1` | Limite usado pela função de ativação para definir a região em que a saída é `0`. |
| `epoca` | `26` | Número máximo de épocas de treinamento. |
| `b` | `0` | Bias inicial. |
| `w` | `{0, 0, 0}` | Pesos iniciais das três entradas. |
| `conta_epoca` | Inicialmente `0` | Contador das épocas executadas. |
| `alterou_peso` | Inicialmente `1` | Indica se houve atualização de pesos ou bias durante a época e controla a continuidade do treinamento. |

O treinamento termina quando são executadas 26 épocas ou quando uma época inteira é concluída sem nenhuma atualização nos pesos e no bias.

## 8. Principais métodos e recursos

O código fornecido concentra a implementação no método `main`; não há métodos auxiliares definidos na classe `Principal`.

| Método ou recurso | Responsabilidade |
|---|---|
| `main(String args[])` | Ponto de entrada. Define os dados, inicializa os parâmetros, executa o treinamento e conduz os testes. |
| `JOptionPane.showInputDialog(...)` | Exibe caixas de diálogo para perguntar se o usuário deseja testar a rede e qual padrão deseja executar. |
| `String` e concatenação | Armazenam as estatísticas das épocas na variável `saida` para exibição ao final do treinamento. |

### 8.1 Tecnologias e ferramentas

| Tecnologia ou ferramenta | Utilização |
|---|---|
| **Java 8 (JDK 8)** | Linguagem e ambiente de desenvolvimento utilizados para implementar e executar o programa. |
| **Apache Maven** | Gerencia a estrutura do projeto, as configurações de compilação e as tarefas definidas no arquivo `pom.xml`. O código apresentado não possui dependências externas explícitas. |
| `javax.swing.JOptionPane` | Exibe caixas de diálogo para interação com o usuário durante os testes. |
| `String` | Armazena as estatísticas de treinamento que serão apresentadas no terminal. |

## 9. Requisitos

- **JDK 8** ou versão compatível.
- **Apache Maven** instalado e configurado, caso a compilação e a execução sejam realizadas por Maven.
- Ambiente com interface gráfica para utilizar as caixas de diálogo do `JOptionPane`.
- Terminal ou prompt de comando para executar os comandos Maven.

## 10. Estrutura do projeto

Considerando a estrutura convencional de um projeto Maven, os arquivos podem estar organizados da seguinte forma:

```text
perceptron-teste/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── Principal.java
```

O arquivo `Principal.java` contém a implementação do treinamento e dos testes. O arquivo `pom.xml` define as configurações do projeto Maven. Se o projeto utilizar um pacote Java ou uma estrutura diferente, ajuste essa representação para corresponder à organização real dos arquivos.

## 11. Compilação e execução

Na pasta raiz do projeto, onde está localizado o arquivo `pom.xml`, execute:

```bash
mvn clean package
```

Esse comando limpa os arquivos de compilação anteriores e empacota o projeto. A forma exata de execução depende das configurações definidas no `pom.xml`.

Se o projeto estiver configurado com o plugin Maven Exec, execute:

```bash
mvn exec:java -Dexec.mainClass="Principal"
```

Se a classe `Principal` estiver dentro de um pacote, informe o nome totalmente qualificado, por exemplo `br.edu.exemplo.Principal`.

Em um projeto simples sem pacote, também é possível compilar e executar diretamente pelo JDK:

```bash
javac -d target/classes src/main/java/Principal.java
java -cp target/classes Principal
```

## 12. Saída e interação do programa

Durante o treinamento, o programa apresenta:

- Mensagem de início do treinamento.
- Número da época atual.
- Valores das três entradas, taxa de aprendizagem, soma de entrada `y_in`, saída ativada `y`, alvo, pesos e bias.
- Mensagem de término do treinamento.

Na etapa de testes, o usuário informa se deseja testar a rede e seleciona o índice de um padrão. Os índices válidos são `0`, `1`, `2` e `3`, correspondentes às quatro linhas da matriz `s` e do vetor `alvo`. O resultado apresenta o padrão escolhido, seu alvo e a saída calculada.

## 13. Observações sobre a implementação

- Os três pesos e o bias começam em zero.
- O treinamento está limitado a 26 épocas e pode terminar antes caso não ocorram atualizações em uma época inteira.
- A função de ativação pode retornar `0`, embora os alvos sejam somente `1` e `-1`. Nesse caso, a saída `0` é diferente de ambos os alvos e provoca atualização dos parâmetros.
- A variável `alterou_peso` indica se houve pelo menos uma atualização durante a época. Apesar do nome, ela sinaliza alterações nos pesos e/ou no bias.
- O cabeçalho de estatísticas declara as colunas `w1` e `w2`, mas o código registra três pesos (`w1`, `w2` e `w3`). A formatação do cabeçalho, portanto, não corresponde completamente aos dados apresentados.
- O programa não valida os valores digitados pelo usuário. O índice selecionado deve estar entre `0` e `3`, e as respostas às caixas de diálogo devem ser números inteiros válidos.
- A variável `saida` acumula as estatísticas de todas as épocas em uma única `String`, o que pode aumentar o consumo de memória em execuções mais longas.
- O código identifica o exemplo como “Teste Perceptron”; não atribui explicitamente um nome de função lógica ao conjunto de treinamento.

## 14. Limitações

- O programa trabalha apenas com quatro padrões de entrada e três entradas por padrão.
- O treinamento é limitado a 26 épocas.
- A função de ativação inclui uma saída intermediária `0`, embora os alvos sejam bipolares.
- Não há validação dos dados digitados durante os testes.
- A interface utiliza `JOptionPane`, exigindo um ambiente gráfico.
- A implementação está concentrada no método `main`, o que limita a modularidade e a reutilização do código.
- O cabeçalho das estatísticas não apresenta corretamente todos os três pesos.

## 15. Referência

FAUSETT, Laurene V. *Fundamentals of Neural Networks: Architectures, Algorithms, and Applications*. Exemplo 2.13, p. 69.
