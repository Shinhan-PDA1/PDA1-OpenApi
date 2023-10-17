package com.pda1.information_connector.domain.stock_info;

import com.pda1.information_connector.domain.BaseTimeEntity;
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
public class StockInformation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;

    @Column
    private String stockCode;
    private String stockName;

    public StockInformation(String korSecnNm, String shotnIsin) {
        this.stockName = korSecnNm;
        this.stockCode = shotnIsin;
    }
}
