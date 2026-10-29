
/**
 * Exemplo 2.13 pag. 69 Livro Fausett, Laurene V Fundamentals of Neural NetWorks
 * Teste Perceptron
 */
public class Principal {

    public static void main(String args[]) {
        //Matriz de dados binaria
        int s[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}, {0, 1, 1}};

        //alvo da matriz de dados polar
        int alvo[] = {1, -1, -1, -1};

        //Numero de Elementos em uma entrada
        int num = 4;

        //Numero de Entradas    
        int n = 3;

        //Taxa de aprendizagem
        int alfa = 1;

        //Threshold
        double omega = 0.1;

        //Numero de epocas		
        int epoca = 26;

        System.out.println(">>> Inicio do treinamento <<<");

        //passo 0
        //%inicializar pesos e bias
        int b = 0; //peso bias		
        int w[] = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = 0;
        }

        int conta_epoca = 0;
        //1 Verdade - 0 Falso
        int alterou_peso = 1;

        //Variavel utilizada para armazenar as estatisticas
        String saida = "";

        //passo 1
        while ((conta_epoca < epoca) && (alterou_peso != 0)) { //condicao de parada     
            alterou_peso = 0; //se nao alterar o peso no passo 5 sai do laco

            //conta o numero de epocas
            conta_epoca = conta_epoca + 1;

            //mostra uma mensagem sobre a epoca atual
            saida = saida + "\nEpoca => " + conta_epoca + "\n";
            saida = saida + "(      Entrada     )\t\t\t\t(     Pesos     )\n";
            saida = saida + "x1  x2  x3\talfa\ty_in\ty\talvo\tw1\tw2\tb";
            saida = saida + "\n";

            //laco para percorrer todas as entradas
            for (int entrada = 0; entrada < num; entrada++) {
                int t = alvo[entrada];

                //passo 3				
                //transfere os dados do conjunto de treinamento para a entrada da rede x(i)
                int x[] = new int[n];
                for (int i = 0; i < n; i++) {
                    x[i] = s[entrada][i];
                }

                //passo 4
                int y_in = 0;
                for (int i = 0; i < n; i++) {
                    y_in = y_in + (x[i] * w[i]);
                }
                y_in = y_in + b;

                //funcao de ativacao
                int y = 0;
                if (y_in > omega) {
                    y = 1;
                } else {
                    if ((-omega <= y_in) && (y_in <= omega)) {
                        y = 0;
                    } else { //y_in < -omega
                        y = -1;
                    }
                }
                //passo 5
                if (y != t) {
                    for (int i = 0; i < n; i++) {
                        w[i] = w[i] + (alfa * t * x[i]);
                    }
                    b = b + alfa * t;
                    alterou_peso = 1;
                }

                //Armazena as estatisticas 	
                for (int j = 0; j < n; j++) {
                    saida = saida + s[entrada][j] + "   ";
                }
                saida = saida + "\t";
                saida = saida + alfa + "\t";
                saida = saida + y_in + "\t";
                saida = saida + y + "\t";
                saida = saida + alvo[entrada] + "\t";
                for (int j = 0; j < n; j++) {
                    saida = saida + w[j] + "\t";
                }
                saida = saida + b + "\n";

            } //Fim For   			

        }//Fim While		
        System.out.print(saida);
        System.out.println(">>> Fim do treinamento <<<");

        //mensagem de inicio dos teste
        System.out.println(">>> Inicio dos testes <<< ");

        //Execucao da rede
        int res = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Deseja fazer teste (1 fazer ou 0 nao fazer) : "));

        while (res != 0) {
            int letra = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("informe o numero do elemento a ser executado => "));

            int t = alvo[letra];

            //passo 3
            //transfere os dados do conjunto de treinamento para a entrada da rede x(i)
            int x[] = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = s[letra][i];
            }

            //passo 4
            int y_in = 0;
            for (int i = 0; i < n; i++) {
                y_in = y_in + (x[i] * w[i]);
            }
            y_in = y_in + b;

            //funcao de ativacao
            int y = 0;
            if (y_in > omega) {
                y = 1;
            } else {
                if ((-omega <= y_in) && (y_in <= omega)) {
                    y = 0;
                } else { //y_in < -omega
                    y = -1;
                }
            }

            //mostra uma mensagem sobre o teste
            System.out.println("\nResultado: ");
            System.out.println("Entrada: " + letra + " Alvo:" + alvo[letra]);
            for (int i = 0; i < n; i++) {
                System.out.print("s[" + letra + "," + i + "] = " + s[letra][i] + " ");
            }
            System.out.print(" y:" + y);

            res = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("press 1 para continuar teste ou 0 para parar testes: "));
        }
        //mensagem
        System.out.println(">>> Fim dos teste <<<");
    }

}
