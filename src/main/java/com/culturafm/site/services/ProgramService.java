// src/main/java/com/culturafm/site/services/ProgramService.java

package com.culturafm.site.services;

import com.culturafm.site.dto.LocutorDTO; // IMPORTAR
import com.culturafm.site.dto.ProgramDTO;
import com.culturafm.site.entities.Locutor; // IMPORTAR
import com.culturafm.site.entities.Program;
import com.culturafm.site.entities.ProgramImage;
import com.culturafm.site.repository.LocutorRepository; // IMPORTAR
import com.culturafm.site.repository.ProgramRepository;
import com.culturafm.site.services.exceptions.ResourceConflictException;
import com.culturafm.site.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProgramService {

	@Autowired
	private ProgramRepository programRepository;

	// INJEÇÃO DO NOVO REPOSITÓRIO DE LOCUTOR
	// Precisamos dele para buscar os locutores pelos IDs que virão no DTO
	@Autowired
	private LocutorRepository locutorRepository;

	@Transactional(readOnly = true)
	public ProgramDTO findById(Long id) {
		Optional<Program> obj = programRepository.findById(id);
		Program entity = obj.orElseThrow(() -> new ResourceNotFoundException("Programa não encontrado com o ID: " + id));
		return new ProgramDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<ProgramDTO> findAll() {
		List<Program> list = programRepository.findAll();
		return list.stream().map(ProgramDTO::new).collect(Collectors.toList());
	}


	@Transactional
	public ProgramDTO insert(ProgramDTO dto) {
		validateConflict(dto, null);

		Program entity = new Program();
		copyDtoToEntity(dto, entity);
		entity = programRepository.save(entity);
		return new ProgramDTO(entity);
	}

	@Transactional
	public ProgramDTO update(Long id, ProgramDTO dto) {
		try {
			Program entity = programRepository.getReferenceById(id);
			validateConflict(dto, id);

			copyDtoToEntity(dto, entity);
			entity = programRepository.save(entity);
			return new ProgramDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Não foi possível atualizar. Programa não encontrado com o ID: " + id);
		}
	}

	public void delete(Long id) {
		try {
			programRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não foi possível deletar. Programa não encontrado com o ID: " + id);
		}
	}


	private void validateConflict(ProgramDTO dto, Long programIdToIgnore) {
		LocalTime newStartTime = dto.getStartTime();
		LocalTime newEndTime = dto.getEndTime();
		Set<String> newDays = parseDaysOfWeek(dto.getDaysOfWeek());

		List<Program> existingPrograms = programRepository.findAll();

		for (Program existing : existingPrograms) {
			if (existing.getId().equals(programIdToIgnore)) {
				continue;
			}

			LocalTime existingStartTime = existing.getStartTime();
			LocalTime existingEndTime = existing.getEndTime();

			boolean timeOverlap = newStartTime.isBefore(existingEndTime) && existingStartTime.isBefore(newEndTime);

			if (timeOverlap) {
				Set<String> existingDays = parseDaysOfWeek(existing.getDaysOfWeek());
				existingDays.retainAll(newDays);
				if (!existingDays.isEmpty()) {
					throw new ResourceConflictException("Conflito de horário! O programa '"
							+ existing.getName() + "' já ocupa o horário no(s) dia(s) " + existingDays);
				}
			}
		}
	}


	// MÉTODO TOTALMENTE CORRIGIDO
	private void copyDtoToEntity(ProgramDTO dto, Program entity) {
		// Copia os dados simples
		entity.setName(dto.getName());
		entity.setDaysOfWeek(dto.getDaysOfWeek());
		entity.setStartTime(dto.getStartTime());
		entity.setEndTime(dto.getEndTime());

		// Lógica para sincronizar as imagens
		entity.getImages().clear();
		for (String imgUrl : dto.getImageUrls()) {
			ProgramImage img = new ProgramImage();
			img.setImageUrl(imgUrl);
			img.setProgram(entity);
			entity.getImages().add(img);
		}

		// NOVA LÓGICA PARA SINCRONIZAR OS LOCUTORES
		entity.getAnnouncers().clear();
		for (LocutorDTO locutorDto : dto.getAnnouncers()) {
			// Para cada DTO de locutor, buscamos a entidade correspondente no banco
			Locutor locutor = locutorRepository.getReferenceById(locutorDto.getId());
			entity.getAnnouncers().add(locutor);
		}
	}


	private Set<String> parseDaysOfWeek(String days) {
		days = days.toLowerCase();
		Set<String> parsedDays = new HashSet<>();

		if (days.contains("segunda a sexta")) {
			parsedDays.addAll(Arrays.asList("seg", "ter", "qua", "qui", "sex"));
		} else if (days.contains("segunda a sábado")) {
			parsedDays.addAll(Arrays.asList("seg", "ter", "qua", "qui", "sex", "sab"));
		} else if (days.contains("segunda a quinta")) {
			parsedDays.addAll(Arrays.asList("seg", "ter", "qua", "qui"));
		}

		if (days.contains("sexta-feira")) {
			parsedDays.add("sex");
		}
		if (days.contains("sábado")) {
			parsedDays.add("sab");
		}
		if (days.contains("domingo")) {
			parsedDays.add("dom");
		}
		return parsedDays;
	}
}