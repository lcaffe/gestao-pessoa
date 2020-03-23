package br.com.acme.api.gestaopessoa.enums;


public enum TipoDocumentoEnum {

	RG("R"), CPF("C"), TITULO_ELEITOR("E"), CARTEIRA_TRABALHO("T");

	private String identificador;

	private TipoDocumentoEnum(String identificador) {
		this.identificador = identificador;
	}

	public String getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public static TipoDocumentoEnum aPartirDoIdentificador(String tipo) {
		for (TipoDocumentoEnum v : TipoDocumentoEnum.values()) {
			if (v.getIdentificador().equals(tipo)) {
				return v;
			}
		}
		throw new IllegalArgumentException("TipoDocumento com código [" + tipo + "] não encontrado.");

	}

}