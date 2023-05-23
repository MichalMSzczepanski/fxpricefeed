package work.szczepanskimichal.fxpricefeed.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Price {

    private int id;
    private FX name;
    private BigDecimal bid;
    private BigDecimal ask;
    private LocalDateTime timestamp;

    private final BigDecimal bidEquation = new BigDecimal("0.99");
    private final BigDecimal askEquation = new BigDecimal("1.01");

    public PriceDTO toDTO(Price price) {
//todo        preferably use mapstruct
        return PriceDTO.builder()
                .name(price.name)
                .ask(price.ask.multiply(askEquation))
                .bid(price.bid.multiply(bidEquation))
                .build();

    }
}


