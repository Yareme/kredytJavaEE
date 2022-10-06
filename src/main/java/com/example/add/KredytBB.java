package com.example.add;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
public class KredytBB {
	private String kwota;
	private String procent;
	private String termin;
	private Double result;

	@Inject
	FacesContext ctx;

	public String getKwota() {
		return kwota;
	}

	public void setKwota(String kwota) {
		this.kwota = kwota;
	}

	public String getProcent() {
		return procent;
	}

	public void setProcent(String procent) {
		this.procent = procent;
	}

	public String getTermin() {
		return termin;
	}

	public void setTermin(String termin) {
		this.termin = termin;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}



	public String calc() {
		doTheMath();
			return null;
	}



	public boolean doTheMath() {
		try{
			double kwota = Double.parseDouble(this.kwota);
			double procent = Double.parseDouble(this.procent);
			double termin = Double.parseDouble(this.termin);


			result = (kwota + kwota / 100 * procent) / (termin * 12);
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;

		}catch (Exception e){
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;

		}
	}



}
