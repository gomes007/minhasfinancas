package com.curso.minhasfinancas.api.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Convert;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.curso.minhasfinancas.model.entity.Usuario;
import com.curso.minhasfinancas.model.enums.StatusLancamento;
import com.curso.minhasfinancas.model.enums.TipoLancamento;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Builder
@Data
public class LancamentoDTO {

	private Long id;

	private String descricao;

	private Integer mes;

	private Integer ano;

	private BigDecimal valor;
	
	private Long usuario;

	private String tipo;

	private String status;

}
