package com.kenzie.appserver.service;

import com.kenzie.appserver.controller.model.ChexMixBagCreateRequest;
import com.kenzie.appserver.repositories.ChexMixBagRepository;
import com.kenzie.appserver.repositories.model.ChexMixBag;
import com.kenzie.appserver.repositories.model.NutritionalInfo;
import com.kenzie.appserver.service.model.ChexMixBagDTO;
import com.kenzie.appserver.service.model.NutritionalInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service class for managing Chex Mix operations.
 */
@Service
public class ChexMixBagService {

    private ChexMixBagRepository chexMixBagRepository;

    @Autowired
    public ChexMixBagService(ChexMixBagRepository chexMixRepository) {
        this.chexMixBagRepository = chexMixRepository;
    }

    public ChexMixBagDTO findById(String id) {
        ChexMixBagDTO chexMixBagDTOFromBackend = chexMixBagRepository
                .findById(id)
                .map(chexMixBagModel -> {
                    ChexMixBagDTO chexMixBagDTO = new ChexMixBagDTO(chexMixBagModel.getId(), chexMixBagModel.getType());
                    chexMixBagDTO.setBatchNumber(chexMixBagModel.getBatchNumber());
                    chexMixBagDTO.setQuantity(chexMixBagModel.getQuantity());
                    chexMixBagDTO.setSupplier(chexMixBagModel.getSupplier());
                    chexMixBagDTO.setExpirationDate(chexMixBagModel.getExpirationDate());
                    NutritionalInfoDTO nutritionalInfoDTO = new NutritionalInfoDTO();

                    nutritionalInfoDTO.setCalories(chexMixBagModel.getNutritionalInfo().getCalories());
                    nutritionalInfoDTO.setProtein(chexMixBagModel.getNutritionalInfo().getProtein());
                    nutritionalInfoDTO.setSugars(chexMixBagModel.getNutritionalInfo().getSugars());
                    nutritionalInfoDTO.setTotalFat(chexMixBagModel.getNutritionalInfo().getTotalFat());


                    chexMixBagDTO.setNutritionalInfo(nutritionalInfoDTO);


                    return chexMixBagDTO;
                })
                .orElse(null);

        return chexMixBagDTOFromBackend;
    }


    public ChexMixBagDTO addNewChexMixBag(ChexMixBagDTO chexMixBagDTO) {
        ChexMixBag chexMixBag = new ChexMixBag();
        chexMixBag.setId(chexMixBagDTO.getId());
        chexMixBag.setType(chexMixBagDTO.getType());
        chexMixBag.setBatchNumber(chexMixBagDTO.getBatchNumber());
        chexMixBag.setQuantity(chexMixBagDTO.getQuantity());
        chexMixBag.setSupplier(chexMixBagDTO.getSupplier());
        chexMixBag.setExpirationDate(chexMixBagDTO.getExpirationDate());

        NutritionalInfoDTO nutritionalInfoDTO = chexMixBagDTO.getNutritionalInfo();
        NutritionalInfo nutritionalInfo = new NutritionalInfo();
        nutritionalInfo.setCalories(nutritionalInfoDTO.getCalories());
        nutritionalInfo.setProtein(nutritionalInfoDTO.getProtein());
        nutritionalInfo.setSugars(nutritionalInfoDTO.getSugars());
        nutritionalInfo.setTotalFat(nutritionalInfoDTO.getTotalFat());

        chexMixBag.setNutritionalInfo(nutritionalInfo);

        chexMixBagRepository.save(chexMixBag);
        chexMixBagDTO.setId(chexMixBag.getId());
        return chexMixBagDTO;
    }


    /**
     * Removes expired Chex Mix from the inventory.
     *
     * @return The removed expired Chex Mix.
     */
    public ChexMixBag removeExpiredChexMix() {
        // Implementation for removing expired Chex Mix
        // You can use chexMixRepository to interact with the database
        // Example: chexMixRepository.deleteByExpirationDateBefore(LocalDate.now());
        return null;
    }

    /**
     * Retrieves the available Chex Mix from the inventory.
     *
     * @return List of available Chex Mix.
     */
    public List<ChexMixBag> getAvailableChexMix() {
        // Implementation for retrieving available Chex Mix
        // You can use chexMixRepository to interact with the database
        // Example: return chexMixRepository.findAll();
        return null;
    }

    /**
     * Tracks the quantity of each type of Chex Mix in the inventory.
     *
     * @return Map with Chex Mix type as key and quantity as value.
     */
    public Map<String, Integer> trackChexMixQuantity() {
        // Implementation for tracking Chex Mix quantity
        // You can use chexMixRepository to interact with the database
        // Example: return chexMixRepository.getQuantityByType();
        return null;
    }

    /**
     * Removes Chex Mix from the inventory by batch number.
     *
     * @param batchNumber The batch number of the Chex Mix to be removed.
     */
    public void removeChexMixByBatchNumber(String batchNumber) {
        // Implementation for removing Chex Mix by batch number
        // You can use chexMixRepository to interact with the database
        // Example: chexMixRepository.deleteByBatchNumber(batchNumber);
    }
}