package com.app.services;

import java.util.List;

import javax.validation.Valid;

import com.app.models.RegisterDetails;

public interface RegisterService {

	public void save(RegisterDetails registerDetails);

	public List<RegisterDetails> findAll();

	public RegisterDetails update(@Valid RegisterDetails registerDetails);
}
