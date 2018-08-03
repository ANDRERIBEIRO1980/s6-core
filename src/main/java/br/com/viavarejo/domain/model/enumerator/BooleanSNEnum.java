package br.com.viavarejo.domain.model.enumerator;

public enum BooleanSNEnum {

	SIM("S", true), NAO("N", false);

	private final String sigla;
	private final boolean flag;

	private BooleanSNEnum(final String sigla, final boolean flag) {
		this.sigla = sigla;
		this.flag = flag;
	}

	public String getSigla() {
		return this.sigla;
	}

	public boolean getFlag() {
		return this.flag;
	}

	public static BooleanSNEnum getInstance(final String sigla) {
		BooleanSNEnum objEnum = null;
		for (final BooleanSNEnum element : BooleanSNEnum.values()) {
			if (element.getSigla() == sigla) {
				objEnum = element;
				break;
			}
		}
		return objEnum;
	}

	public static BooleanSNEnum getInstance(final boolean flag) {
		BooleanSNEnum objEnum = null;
		for (final BooleanSNEnum element : BooleanSNEnum.values()) {
			if (element.getFlag() == flag) {
				objEnum = element;
				break;
			}
		}
		return objEnum;
	}

}