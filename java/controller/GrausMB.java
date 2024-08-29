package controller;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import model.ConverteGraus;

@RequestScoped
@Named
public class GrausMB {

	
	private Double resultadoF;
	
	@EJB
	private ConverteGraus converteGraus;

	private double c;

	public void converterParaFahrenheit() {
		this.resultadoF = this.converteGraus.converterParaFahrenheit(c);
	}

	public Double getResultadoF() {
		return resultadoF;
	}

	public void setResultadoF(Double resultadoF) {
		this.resultadoF = resultadoF;
	}

	public double getC() {
		return c;
		
	}

	public void setC(double c) {
		this.c = c;
	}
}
