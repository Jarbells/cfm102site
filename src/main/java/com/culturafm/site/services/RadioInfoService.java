package com.culturafm.site.services;

import com.culturafm.site.dto.RadioInfoDTO;
import com.culturafm.site.entities.RadioInfo;
import com.culturafm.site.repository.RadioInfoRepository;
import com.culturafm.site.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RadioInfoService {

    @Autowired
    private RadioInfoRepository repository;

    // O ID será sempre 1 para este caso de uso "Singleton"
    private final Long fixedId = 1L;

    @Transactional(readOnly = true)
    public RadioInfoDTO getInfo() {
        RadioInfo entity = repository.findById(fixedId)
                .orElseThrow(() -> new ResourceNotFoundException("Informações da rádio não encontradas. O registro inicial precisa ser criado."));
        return new RadioInfoDTO(entity);
    }

    @Transactional
    public RadioInfoDTO updateInfo(RadioInfoDTO dto) {
        try {
            RadioInfo entity = repository.getReferenceById(fixedId);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new RadioInfoDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Não foi possível atualizar. Informações da rádio com ID " + fixedId + " não encontradas.");
        }
    }

    private void copyDtoToEntity(RadioInfoDTO dto, RadioInfo entity) {
        entity.setAddressStreet(dto.getAddressStreet());
        entity.setAddressNumber(dto.getAddressNumber());
        entity.setAddressNeighborhood(dto.getAddressNeighborhood());
        entity.setAddressCity(dto.getAddressCity());
        entity.setAddressState(dto.getAddressState());
        entity.setAddressZipCode(dto.getAddressZipCode());
        entity.setPhonePrimary(dto.getPhonePrimary());
        entity.setPhoneWhatsapp(dto.getPhoneWhatsapp());
        entity.setEmailContact(dto.getEmailContact());
        entity.setSocialInstagramUrl(dto.getSocialInstagramUrl());
        entity.setSocialFacebookUrl(dto.getSocialFacebookUrl());
        entity.setSocialYoutubeUrl(dto.getSocialYoutubeUrl());
        entity.setSocialXUrl(dto.getSocialXUrl());
    }
}