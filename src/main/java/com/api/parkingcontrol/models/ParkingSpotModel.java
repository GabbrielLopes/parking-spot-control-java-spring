package com.api.parkingcontrol.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
    public static final long serialVersionUID = 1L;

    // 1° Define os atributos e depois mapeia campo por campo dp @column para passar as restrições que serão criadas

    @Id   // Nossa classe identificador, pois é uma entidade
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;  // Número da vaga

    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;   // Placa do carro

    @Column(nullable = false, length = 70)
    private String brandCar;          //  Marca do carro

    @Column(nullable = false, length = 70)
    private String modelCar;         //  Modelo do carro

    @Column(nullable = false, length = 70)
    private String colorCar;        //  Cor do carro

    @Column(nullable = false)
    private LocalDateTime registrationDate;   //  Data de registro da vaga

    @Column(nullable = false, length = 130)
    private String responsibleName;            // Nome do responsavel do veiculo/apartamento

    @Column(nullable = false, length = 30)
    private String apartment;                // Apartamento em si

    @Column(nullable = false, length = 30)
    private String block;                   // Bloco do apartamento

}
