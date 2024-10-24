package dados;

import java.util.ArrayList;

public class Acervo {

	private ArrayList<Video> video;

	public boolean addVideo(Video v) {
		if(video.add(v)){
			return true;
		}
		return false;
		
	}

}
