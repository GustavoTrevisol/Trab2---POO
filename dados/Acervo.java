package dados;

import java.util.ArrayList;

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

}
