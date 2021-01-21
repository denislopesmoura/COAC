package entities;

public enum StatusUsuario {

	APROVADO, REJEITADO, EM_ESPERA;

	@Override
	public String toString() {
		return String.format("StatusUsuario(status: %s)", this.name());
	}

}
