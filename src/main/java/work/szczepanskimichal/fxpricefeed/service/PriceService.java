package work.szczepanskimichal.fxpricefeed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import work.szczepanskimichal.fxpricefeed.csvParser.CSVParser;
import work.szczepanskimichal.fxpricefeed.model.Price;
import work.szczepanskimichal.fxpricefeed.model.PriceDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceService implements PriceFacade {

    private final CSVParser csvParser;
    @Override
    public List<PriceDTO> listMarketPrices() {
        List<Price> prices = csvParser.parseCSVToPrices();
        return prices.stream()
                .map(p -> p.toDTO(p))
                .collect(Collectors.toList());
    }
}
