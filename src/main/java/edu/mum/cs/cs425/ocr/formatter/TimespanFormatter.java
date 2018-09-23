package edu.mum.cs.cs425.ocr.formatter;


import edu.mum.cs.cs425.ocr.domain.Timespan;
import edu.mum.cs.cs425.ocr.service.TimespanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class TimespanFormatter implements Formatter<Timespan> {

	@Autowired
	private TimespanService timespanService;

	@Override
	public String print(Timespan timespan, Locale locale) {
		return timespan.getId() + "";
	}

	@Override
	public Timespan parse(String text, Locale locale) {
		Timespan timespan = timespanService.getById(Integer.parseInt(text));
		return timespan;
	}

}
