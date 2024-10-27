package dados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Acervo {

	private ArrayList<Video> video;

	public Acervo() {
		this.video = new ArrayList<>();
	}

	public ArrayList<Video> getVideo() {
		return video;
	}

	public boolean addVideo(Video v) {
		for (int i = 0; i < video.size(); i++) {

			if (video.get(i).getCodigo() == v.getCodigo()) {
				return false;
			}
		}

		video.add(v);
		return true;

	}

	public Video maiorTitulo() {
		if (video.isEmpty()) {
			return null;
		}

		Video videoComMaiorTitulo = video.get(0);

		for (Video v1 : video) {
			if (v1.getTitulo().length() > videoComMaiorTitulo.getTitulo().length()) {
				videoComMaiorTitulo = v1;
			}

		}
		return videoComMaiorTitulo;
	}

	public Video custoMaisBaixo(){
		if (video.isEmpty()) {
		 	return null;
		}

		Video videoComMenorCusto = video.get(0);

		for(Video v1 : video){
			if(v1.calculaCusto() < videoComMenorCusto.calculaCusto()){
				videoComMenorCusto = v1;
			}
		}
		
		return videoComMenorCusto;
	}

	

	public Seriado seriadoComMaiorExibicao(){
		
		Seriado seriadoComMaiorExibicao = null;

	   for(Video v1 : video){
		if(v1 instanceof Seriado){
			Seriado seriado = (Seriado) v1;
			if (seriadoComMaiorExibicao == null || 
                    seriado.tempoExibicao() > seriadoComMaiorExibicao.tempoExibicao()) {
                    seriadoComMaiorExibicao = seriado;
                }
		}
	   }
		return seriadoComMaiorExibicao;
	}

	public String diretorComMaisFilmes(){
		
		HashMap<String, Integer> contagemDiretores = new HashMap<>();
		if (video.isEmpty()){
			return null;
	   }

	   for(Video v1 : video){
		if(v1 instanceof Filme){
			Filme filme = (Filme) v1;
			String diretor = filme.getDiretor();
			contagemDiretores.put(diretor, contagemDiretores.getOrDefault(diretor, 0) + 1);
		}
	   }
	   String diretorMaisFamoso = null;
        int maiorQuantidade = 0;

        for (Map.Entry<String, Integer> entry : contagemDiretores.entrySet()) {
            if (entry.getValue() > maiorQuantidade) {
                maiorQuantidade = entry.getValue();
                diretorMaisFamoso = entry.getKey();
            }
        }

        return diretorMaisFamoso;
	}

	public int contarFilmesPorDiretor(String diretor) {
        int contador = 0;

        for (Video v : video) {
            if (v instanceof Filme) {
                Filme filme = (Filme) v;
                if (filme.getDiretor().equals(diretor)) {
                    contador++;
                }
            }
        }

        return contador;
	}

}
