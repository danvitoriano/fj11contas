package br.com.caelum.contas.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe responsável por moldar as Contas do Banco
 * 
 * @author dvitoriano
 *
 */

public abstract class Conta {
	protected double saldo;
	private String titular;
	private int numero;
	private String agencia;

	/**
	 * Método que incrementa o valor
	 * @param valor
	 */
	public void deposita(double valor) throws IllegalArgumentException {
		if (valor < 0) throw new IllegalArgumentException("Você tentou depositar um valor negativo");
        else this.saldo += valor;
	}
	
	public abstract String getTipo();
	
	public void transfere(double valor, Conta conta) {
		this.saca(valor);
		conta.deposita(valor);
	}
	
	// getters and setters

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public void saca(double valor) {
		this.saldo -= valor;
	}

	public double getSaldo() {
		return this.saldo;
	}

    @Override
    public String toString() {
        return "[titular=" + titular.toUpperCase() + ", número=" + numero + ", agência=" + agencia + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Conta outraConta = (Conta) obj;

        return this.numero == outraConta.numero && this.agencia == outraConta.agencia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, agencia);
    }

}
