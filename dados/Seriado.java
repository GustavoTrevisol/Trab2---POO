package dados;

public class Seriado extends Video {

	private int anoInicio;
	private int anoFim;
	private int numEpisodios;

	public Seriado(int codigo, String titulo, int anoInicio, int anoFim, int numEpisodios){
		super(codigo, titulo);
	}

	public int getAnoFim() {
		return anoFim;
	}

	public int getAnoInicio() {
		return anoInicio;
	}

	public int getNumEpisodios() {
		return numEpisodios;
	}

	@Override
	public double calculaCusto() {
		return numEpisodios * 0.50;
	}


}
