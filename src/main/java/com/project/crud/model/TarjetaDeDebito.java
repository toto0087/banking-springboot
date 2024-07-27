package com.project.crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tarjetaDeDebito")
public class TarjetaDeDebito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long numeroDeTarjeta;
    @Column
    private String fechaDeVencimiento;
    @Column
    private String codigoDeSeguridad;
}
