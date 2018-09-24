package edu.mum.cs.cs544.ocr.service;


import edu.mum.cs.cs544.ocr.domain.Timespan;

import java.util.List;

public interface TimespanService {
	List<Timespan> findAll();

	Timespan getById(int id);
}
