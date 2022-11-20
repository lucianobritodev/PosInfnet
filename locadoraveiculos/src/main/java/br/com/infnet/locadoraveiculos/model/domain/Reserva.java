package br.com.infnet.locadoraveiculos.model.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.infnet.locadoraveiculos.model.domain.enuns.StatusReserva;

@Entity
@Table(name = "tb_reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dataReserva;
	private int diasReservados;
	@Enumerated(EnumType.ORDINAL)
	private StatusReserva status;
	private String descricao;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Veiculo> veiculos;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public Reserva() {
		dataReserva = LocalDateTime.now();
	}
	
	public Reserva(Cliente cliente) {
		this();
		this.cliente = cliente;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDateTime dataReserva) {
		this.dataReserva = dataReserva;
	}

	public int getDiasReservados() {
		return diasReservados;
	}

	public void setDiasReservados(int diasReservados) {
		this.diasReservados = diasReservados;
	}

	public StatusReserva getStatus() {
		return status;
	}

	public void setStatus(StatusReserva status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public float getTotalReserva() {
		float valores = 0;
		for (Veiculo v : veiculos) {
			valores += v.getValor();
		}
		return diasReservados * valores; 
	}
	
	@Override
	public String toString() {
		return status + ";" + descricao + ";" + dataReserva + ";" + cliente + ";" + veiculos.size();
	}
}
