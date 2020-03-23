package br.com.acme.api.gestaopessoa.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TipoDocumentoConverter implements AttributeConverter<TipoDocumentoEnum, String> {

	@Override
	public String convertToDatabaseColumn(TipoDocumentoEnum tipo) {
		return tipo.getIdentificador();
	}

	@Override
	public TipoDocumentoEnum convertToEntityAttribute(String tipo) {
		return TipoDocumentoEnum.aPartirDoIdentificador(tipo);
	}

}
