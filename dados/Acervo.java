package dados;

import java.util.ArrayList;

public class Acervo {

	private ArrayList<Video> video;

	public Acervo(){
		this.video = new ArrayList<>(); 
	}

	public boolean addVideo(Video v) {
		for(int i = 0; i < video.size(); i++){
			if(v.getCodigo() != video.get(i).getCodigo()){
				video.add(v);
				return true;
			}
		}
		System.out.println("1:Erro - codigo de video repetido.");
		return false;
		
	}

}
