package dados;

public class Filme extends Video {

	private String diretor;
	private double duracao;

	public Filme(int codigo, String titulo, String diretor, double duracao){
		super(codigo, titulo);
		this.diretor = diretor;
		this.duracao = duracao;

	}

	public String getDiretor() {
		return diretor;
	}

	public double getDuracao() {
		return duracao;
	}

	public String geraTexto(){
		return getCodigo() + "-" + getTitulo() + "-" + diretor + "-" + duracao;
	}

	@Override
	public double calculaCusto() {
		return duracao * 0.30;
	}

	



}
