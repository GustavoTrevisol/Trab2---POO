package app;

import dados.Acervo;
import dados.Filme;
import dados.Seriado;
import dados.Video;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;
import java.io.IOException;

public class ACMEVideos {
    private Scanner entrada = new Scanner(System.in); // Atributo para entrada padrao (teclado)
    private PrintStream saidaPadrao = System.out; // Guarda a saida padrao - tela (console)
    private final String nomeArquivoEntrada = "input.txt"; // Nome do arquivo de entrada de dados
    private final String nomeArquivoSaida = "output.txt"; // Nome do arquivo de saida de dados

    public ACMEVideos() {
        redirecionaEntrada(); // Redireciona Entrada para arquivos
        redirecionaSaida(); // Redireciona Saida para arquivos
    }

    public void processar() {
        redirecionaEntrada();

        Acervo acervo = new Acervo();

        // 1 - Cadastro dos videos
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String dadosVideo = entrada.nextLine();

            while ((dadosVideo = reader.readLine()) != null) {
                // Processa a linha lida, por exemplo, cadastrar um item

                String[] parteLinha = dadosVideo.split(";");
                int tipo = Integer.parseInt(parteLinha[0]);
                if (tipo == 1) {
                    int codigo = Integer.parseInt(parteLinha[1]);
                    String titulo = parteLinha[2];
                    String diretor = parteLinha[3];
                    double duracao = Double.parseDouble(parteLinha[4]);
                    Filme filme = new Filme(codigo, titulo, diretor, duracao);
                    if (acervo.addVideo(filme)) {
                        System.out.println(filme.geraTexto() + "-" + filme.calculaCusto());
                    } else {
                        System.out.println("1: Erro - codigo de video repetido.");
                    }
                }

                else if (tipo == 2) {
                    int codigo = Integer.parseInt(parteLinha[1]);
                    String titulo = parteLinha[2];
                    int anoInicio = Integer.parseInt(parteLinha[3]);
                    int anoFim = Integer.parseInt(parteLinha[4]);
                    int numEpisodios = Integer.parseInt(parteLinha[5]);
                    Seriado seriado = new Seriado(codigo, titulo, anoInicio, anoFim, numEpisodios);
                    if (acervo.addVideo(seriado)) {
                        System.out.println(seriado.geraTexto() + "-" + seriado.calculaCusto());
                    } else {
                        System.out.println("1: Erro - codigo de video repetido.");
                    }
                }
            }
            reader.close();

            // 2 - metodo que retorna o maior titulo
            if (acervo.maiorTitulo() != null) {
                System.out.println("2:" + acervo.maiorTitulo().getCodigo() + "-" + acervo.maiorTitulo().getTitulo());
            } else {
                System.out.println("2:Erro - nenhum vídeo cadastrado.");
            }

            // 3 - metodo que retorna menor custo

            if (acervo.custoMaisBaixo() != null) {
                System.out.println("3:" + acervo.custoMaisBaixo().getCodigo() + "-"
                        + acervo.custoMaisBaixo().getTitulo() + "-" + acervo.custoMaisBaixo().calculaCusto());
            } else {
                System.out.println("3:Erro - nenhum video cadastrado.");
            }

            // 4 - Seriado com maior tempo de exibicao

            if(acervo.seriadoComMaiorExibicao() != null){
                System.out.println("4:" + acervo.seriadoComMaiorExibicao().getCodigo() + "-" + acervo.seriadoComMaiorExibicao().getTitulo() + "-" + acervo.seriadoComMaiorExibicao().tempoExibicao());
            }
            else{
                System.out.println("4:Erro - nenhum seriado cadastrado.");
            }

        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void redirecionaEntrada() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            entrada = new Scanner(streamEntrada); // Usa como entrada um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH); // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH); // Ajusta para leitura para ponto decimal
    }

    // Redireciona Saida de dados para arquivos em vez da tela (terminal)
    // Chame este metodo para redirecionar a escrita de dados para arquivos
    private void redirecionaSaida() {
        try {
            PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(streamSaida); // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH); // Ajusta para ponto decimal
    }

    // Restaura Entrada padrao para o teclado
    // Chame este metodo para retornar a leitura de dados para o teclado
    private void restauraEntrada() {
        entrada = new Scanner(System.in);
    }

    // Restaura Saida padrao para a tela (terminal)
    // Chame este metodo para retornar a escrita de dados para a tela
    private void restauraSaida() {
        System.setOut(saidaPadrao);
    }

}
