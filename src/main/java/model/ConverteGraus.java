package model;

import jakarta.ejb.Stateless;

@Stateless
public class ConverteGraus {

	public double converterParaFahrenheit(double c) {
		return c * 1.8 + 32;
	}
}
