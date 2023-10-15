package com.pda1.information_connector.domain.chart_table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ChartTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chartTableId;

    @Column
    private String annualHigh;
    private String annualLow;
    private String capital;
    private String listedStockNumber;
    private String marketCapital;
    private String per;
    private String eps;

}
