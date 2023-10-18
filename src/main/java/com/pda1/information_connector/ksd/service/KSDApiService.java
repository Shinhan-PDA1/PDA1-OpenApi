package com.pda1.information_connector.ksd.service;

import com.pda1.information_connector.domain.chart_comment.ChartComment;
import com.pda1.information_connector.domain.chart_comment.ChartCommentRepository;
import com.pda1.information_connector.domain.chart_table.ChartTable;
import com.pda1.information_connector.domain.chart_table.ChartTableRepository;
import com.pda1.information_connector.domain.statement_comment.StatementComment;
import com.pda1.information_connector.domain.statement_comment.StatementCommentRepository;
import com.pda1.information_connector.domain.stock_info.StockInformation;
import com.pda1.information_connector.domain.stock_info.StockInformationRepository;
import com.pda1.information_connector.ksd.controller.response.StockInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class KSDApiService {

    private final KSDUriRequestService uriRequestService;

    private final StockInformationRepository stockInformationRepository;
    private final ChartTableRepository chartTableRepository;
    private final ChartCommentRepository chartCommentRepository;
    private final StatementCommentRepository statementCommentRepository;
    String Statement_ShortComment = """
            주어진 재무제표를 통해 기업의 재무 상황과 투자 가능성에 대해 알 수 있습니다.
                        
            1. 수익성:
            - 2022년 6월부터 2022년 9월까지의 기간 동안 기업의 ROE(지배주주)는 15.1%에서 13.42%로 감소했습니다. 그러나 2022년 12월에는 17.07%로 다시 상승하였습니다. 이는 기업이 지배주주의 자본에 대해 생성한 이익의 정도를 보여줍니다. 높은 ROE는 기업의 수익성이 높고 효율적으로 자본을 운용하는 것을 의미합니다.
                        
            2. 안정성:
            - 2022년 12월까지의 기간 동안 부채비율은 36.64%에서 26.41%로 감소하였습니다. 부채비율은 기업의 부채에 대한 자본의 비율을 나타냅니다. 낮은 부채비율은 기업의 재무 안정성을 나타내며, 감소하는 경향은 기업의 재무상태가 개선되고 있는 것을 의미합니다.
                        
            3. 성장 가능성:
            - 매출액은 2022년 6월부터 2022년 12월까지 일정한 수준에서 유지되었습니다. 그러나 2023년 3월까지는 637,454억원으로 줄어들었습니다. 이는 기업의 매출 성장이 의문스러울 수 있음을 나타냅니다. 따라서 투자자는 기업의 매출 동향을 계속 주시해야 합니다.
                        
            4. 가치 평가:
            - PBR(배)과 PER(배)는 주가 대비 자산과 이익을 나타내는 지표입니다. 낮은 PBR과 PER은 주가가 저렴하다는 것을 의미하며, 많은 투자자에게 관심을 받을 수 있습니다. 2022년 6월과 2022년 9월에는 PBR이 1.21에서 1.08로 감소하였고, PER은 8.65에서 8.61로 거의 그대로 유지되었습니다. 이는 기업의 가치가 상대적으로 저렴하고 투자 가치가 있는 것을 나타냅니다.
                        
            종합적으로 봤을 때, 기업은 경쟁력 있는 ROE와 안정적인 부채비율을 가지고 있으며, 주가가 상대적으로 저렴합니다. 그러나 매출 성장에 대한 우려가 있으므로 투자자는 추가적인 연구를 통해 기업의 성장 가능성을 확인해야 합니다.
            """;
    String Statement_LongComment = """
            주어진 재무제표 데이터를 분석해보면, 기업의 재무상태와 성과가 점진적으로 개선되고 있음을 알 수 있습니다.
            \n2020년에는 매출액이 2,368,070억원이었고 영업이익은 359,939억원이었습니다. 
            순이익률은 11.15%로 나타났으며, ROE(지배주주)는 9.98%입니다. 또한, 당기순이익은 264,078억원이며 부채비율은 37.07%입니다.
            \n2021년에는 매출액이 2,796,048억원이며 영업이익은 516,339억원이었습니다. 
            순이익률은 14.27%로 증가하였으며, ROE(지배주주)는 13.92%입니다. 
            당기순이익은 399,074억원이며 부채비율은 39.92%입니다.
            \n2022년에는 매출액이 3,022,314억원이며 영업이익은 433,766억원이었습니다. 
            순이익률은 18.41%로 상승하였으며, ROE(지배주주)는 17.07%입니다. 
            당기순이익은 556,541억원이며 부채비율은 26.41%입니다.
            \n2023년(E)에는 매출액이 2,609,703억원이며 영업이익은 72,145억원입니다. 순이익률은 3.52%입니다. 
            이를 기반으로 예측된 데이터로써, 당기순이익은 91,894억원으로 추정됩니다.
            \n기업의 재무상태를 보면, 부채비율이 점차 감소하고 있으며, ROE(지배주주) 또한 증가하는 경향을 보입니다. 
            또한, 순이익률과 영업이익률이 상승하고 있으며, 이는 기업의 효율성이 향상되고 있다는 것을 의미합니다.
            \n또한, 배당성향은 2020년에는 77.95%였으나, 2021년에는 25%로 감소하였습니다. 
            이는 기업이 배당 정책을 조정하고 있다는 것을 나타냅니다.
            \n2023년의 예측 데이터(E)를 살펴보면, 당기순이익이 91,894억원으로 크게 감소하며 ROE(지배주주)도 2.48%로 하락하는 것을 확인할 수 있습니다. 
            이는 해당 기간에 기업의 수익성이 저조할 것으로 예상되며, 주가에 영향을 줄 수 있습니다.
            \n따라서, 기업의 재무 상태는 미래 경제 상황에 따라 변동할 수 있으므로 투자를 고려한다면 기업의 재무성과와 전망을 지속적으로 모니터링해야 합니다. 
            특히, 향후 1년 동안 수익 실현을 원하는 장기 투자자는 현재 수치에 기반하여 타당한 평가를 하고 투자여부를 결정해야 합니다.
            """;
    String Chart_ShortComment = """
     주어진 데이터를 기반으로 5일, 20일, 60일 이동평균선을 계산해보겠습니다.
     이동평균선은 가격 변동의 추세를 파악하는데 도움을 줄 수 있습니다.
     \n먼저, 각각의 이동평균선에 대한 계산 결과는 다음과 같습니다:
     - 5일 이동평균선: 68080
     - 20일 이동평균선: 68840
     - 60일 이동평균선: 68136.67
     \n5일 이동평균선은 최근 5일 동안의 평균 가격을 나타냅니다.
     20일 이동평균선은 최근 20일 동안의 평균 가격을 나타냅니다.
     60일 이동평균선은 최근 60일 동안의 평균 가격을 나타냅니다.
     \n이동평균선을 통해 주가의 추세를 파악할 수 있습니다. 
     일반적으로 5일 이동평균선이 20일 이동평균선을 상향 돌파하고, 
     20일 이동평균선이 60일 이동평균선을 상향 돌파하는 경우에는 상승추세로 볼 수 있습니다.
     \n하지만, 단기 투자자의 수익 실현을 원하는 경우 역추세에 대한 신속한 반응을 필요로 하기 때문에 단지 이동평균선만으로는 투자 의견을 제시하기 어렵습니다.
     \n따라서, 추가로 다른 요소들을 고려하여 투자 의견을 제시해드릴 수 있습니다. 예를 들어, 주가의 상승추세가 강력하거나 거래량이 증가하는 경우 매수 의견을 제시할 수 있습니다. 
     반면에, 주가의 하락이 지속되거나 거래량이 감소하는 경우 매도 의견을 제시할 수 있습니다. 또한, 기업의 재무상태, 시장 동향, 관련 뉴스 및 이벤트 등을 고려할 수도 있습니다.
     \n투자 의견은 단기 투자자의 투자 목표, 위험 수용도, 자금 상황, 전망 등에 따라 다를 수 있으므로 개인적인 상담이 필요합니다.
     """;
    String Chart_LongComment = """
            주어진 데이터를 기반으로 5일, 20일, 60일의 이동평균선을 계산해보겠습니다. 
            \n5일 이동평균선: 약 67860원
            \n20일 이동평균선: 약 69050원
            \n60일 이동평균선: 약 68840원
            \n이동평균선을 바탕으로 투자 의견을 제시해보겠습니다.
            \n1. 5일 이동평균선이 종가보다 높을 경우:
              - 주가는 상승세이고, 단기적으로 상승 가능성이 높을 수 있습니다. 
            장기 투자자에게는 매수 추천할 수 있습니다. 
            \n2. 20일 이동평균선이 종가보다 높고, 5일 이동평균선이 20일 이동평균선보다 높을 경우:
              - 주가는 상승세이고, 중기적으로 상승 가능성이 높을 수 있습니다. 
            장기 투자자에게는 매수 추천할 수 있습니다.
            \n3. 20일 이동평균선이 종가보다 낮고, 5일 이동평균선이 20일 이동평균선보다 낮을 경우:
              - 주가는 하락세이고, 단기적으로 하락 가능성이 높을 수 있습니다. 
            장기 투자자에게는 매도 추천할 수 있습니다.
            \n4. 60일 이동평균선과 20일 이동평균선이 종가보다 높은 경우:
              - 주가는 상승세이며, 장기적으로 상승 추세일 수 있습니다. 장기 투자자에게는 매수 추천할 수 있습니다.
            \n5. 60일 이동평균선과 20일 이동평균선이 종가보다 낮은 경우:
              - 주가는 하락세이며, 장기적으로 하락 추세일 수 있습니다. 장기 투자자에게는 매도 추천할 수 있습니다.
            \n물론, 위의 투자 의견은 주어진 데이터를 바탕으로 한 가이드일 뿐이며, 개별 투자자의 판단에 따라 다를 수 있습니다. 
            추가적인 분석과 타이밍에 따라서 투자 의견이 달라질 수 있으니, 상세한 정보와 추가적인 지표를 고려하여 투자 결정을 내리는 것이 좋습니다.
            """;

    public boolean saveKSDStockData() throws UnsupportedEncodingException, URISyntaxException {

        StockInfoResponse kospi_response = uriRequestService.getKospiStockInfo();

        kospi_response.getStockInfoBody().getStockInfoItems().getStockInfoItem().getItem().forEach(item -> {
            System.out.println("Number: "+ item.getStockNumber());
            System.out.println("Name: " + item.getStockName());

            StockInformation stockInformation = new StockInformation(item.getStockName(), item.getStockNumber());
            stockInformationRepository.save(stockInformation);

            ChartTable chartTable = new ChartTable(
                    item.getStockMarket(),
                    item.getAnnualHigh(),
                    item.getAnnualLow(),
                    item.getNumberOfStock(),
                    item.getTotalAmount(),
                    item.getPER()
            );
            chartTable.setStockInformation(stockInformation);
            chartTableRepository.save(chartTable);


            ChartComment chartComment = new ChartComment(
                Chart_ShortComment, Chart_LongComment
            );
            chartComment.setStockInformation(stockInformation);
            chartCommentRepository.save(chartComment);

            StatementComment statementComment = new StatementComment(
                Statement_ShortComment, Statement_LongComment
            );
            statementComment.setStockInformation(stockInformation);
            statementCommentRepository.save(statementComment);

        });
        return true;
    }

}
