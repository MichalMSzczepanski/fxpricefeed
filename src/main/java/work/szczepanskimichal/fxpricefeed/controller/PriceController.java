package work.szczepanskimichal.fxpricefeed.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.szczepanskimichal.fxpricefeed.model.PriceDTO;
import work.szczepanskimichal.fxpricefeed.service.PriceService;

import java.util.List;

@RestController
@RequestMapping("/price")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;

    @GetMapping("")
    public List<PriceDTO> listMarketPrices() {
        return priceService.listMarketPrices();
    }


}
