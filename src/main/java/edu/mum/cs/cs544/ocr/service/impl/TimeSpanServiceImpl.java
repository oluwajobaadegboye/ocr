package edu.mum.cs.cs544.ocr.service.impl;


import edu.mum.cs.cs544.ocr.domain.Timespan;
import edu.mum.cs.cs544.ocr.repository.TimespanRepository;
import edu.mum.cs.cs544.ocr.service.TimespanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeSpanServiceImpl implements TimespanService {
	@Autowired
	private TimespanRepository tinmespanRepository;

	@Override
	public List<Timespan> findAll() {
		List<Timespan> list = new ArrayList<>();
		tinmespanRepository.findAll().forEach((Timespan t) -> list.add(t));
		return list;
	}

	@Override
	public Timespan getById(int id) {
		return tinmespanRepository.findById(id).orElse(null);
	}

}
