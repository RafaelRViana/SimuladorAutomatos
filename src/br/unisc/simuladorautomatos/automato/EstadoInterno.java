package br.unisc.simuladorautomatos.automato;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(value="estado-interno")
public class EstadoInterno {

	private String nome = "";

	private boolean inicio = false;

	private boolean fim = false;

        public EstadoInterno() {} //Exigido pelo XStream
        
	public EstadoInterno(String nome, TipoEstado tipoEstado) {
		this.nome = nome;

		// FIXME Adicionar verifica��o para string nula
		// FIXME O estado pode ser inicio e fim ao mesmo tempo??
		if (tipoEstado.equals(TipoEstado.INICIO)) {
			inicio = true;
		}

		if (tipoEstado.equals(TipoEstado.FIM)) {
			fim = true;
		}
	}

        public EstadoInterno(String nome, TipoEstado tipoEstadoI, TipoEstado tipoEstadoF) {
		this.nome = nome;
		inicio = true;
		fim = true;
	}
        
	public EstadoInterno(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public boolean isInicio() {
		return inicio;
	}
        
	public boolean isFim() {
		return fim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoInterno other = (EstadoInterno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}
}
