package dados;

public class Filme extends Video {

	private String diretor;
	private double duracao;

	public Filme(int codigo, String titulo, String diretor, double duracao){
		super(codigo, titulo);
		this.diretor = diretor;
		this.duracao = duracao;

	}

	// @Override
	// public int getCodigo(){
	// 	return super.getCodigo();
	// }

	// @Override
	// public String getTitulo(){
	// 	return super.getTitulo();
	// }

	public String getDiretor() {
		return diretor;
	}

	public double getDuracao() {
		return duracao;
	}

	@Override
	public double calculaCusto() {
		return duracao * 0.30;
	}
	
	public String geraTexto(){
		return "1:" + getCodigo() + "-" + getTitulo() + "-" + diretor + "-" + duracao;
	}

	

	



}
