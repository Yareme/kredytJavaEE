package com.example.add;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
public class KredytBB {
	private Double kwota;
	private Double procent;
	private Integer termin;
	private Double result;

	@Inject
	FacesContext ctx;

	public Double getKwota() {
		return kwota;
	}

	public void setKwota(Double kwota) {
		this.kwota = kwota;
	}

	public Double getProcent() {
		return procent;
	}

	public void setProcent(Double procent) {
		this.procent = procent;
	}

	public Integer getTermin() {
		return termin;
	}

	public void setTermin(Integer termin) {
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

			result = (kwota + kwota / 100 * procent) / (termin * 12);
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Rata: "+result, null));
			return true;

		}catch (Exception e){
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;

		}
	}



}
