package edu.mum.cs.cs425.ocr.service;


import edu.mum.cs.cs425.ocr.domain.Timespan;

import java.util.List;

public interface TimespanService {
	List<Timespan> findAll();

	Timespan getById(int id);
}
