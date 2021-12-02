package doadores.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doadores implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 150)
	private String nome;
	
	@Column(nullable = false, length = 11)
	private String cpf;
	
	@Column(nullable = false, length = 2)
	private Integer idade;
	
	@Column(nullable = false, length = 4)
	private Double altura;
	
	@Column(nullable = false, length = 3)
	private Double peso;
	
	@Column(nullable = false, length = 1)
	private String sexo;
	
	@Column(nullable = false, length = 3)
	private String tipoSanguineo;
	
	@Column(nullable = false, length = 10)
	private String estado;
	
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro;
	
	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}

}
