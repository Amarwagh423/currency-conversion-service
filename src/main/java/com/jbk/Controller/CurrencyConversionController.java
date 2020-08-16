package com.jbk.Controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jbk.Bean.CurrencyConversionBean;
import com.jbk.Reposetory.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter-fegin/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean response = proxy.retriveExchangeValue(from, to);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConverstionMultiple(), quantity,
				quantity.multiply(response.getConverstionMultiple()), response.getPort());
	}

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,

			@PathVariable BigDecimal quantity) {
		Map<String, String> UriVariable = new HashMap<String, String>();
		UriVariable.put("from", from);
		UriVariable.put("to", to);

		ResponseEntity<CurrencyConversionBean> responceEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				UriVariable);
		CurrencyConversionBean response = responceEntity.getBody();
		return new CurrencyConversionBean(response.getId(), from, to, response.getConverstionMultiple(), quantity,
				quantity.multiply(response.getConverstionMultiple()), response.getPort());
	}

}
