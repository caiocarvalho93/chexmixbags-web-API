package com.kenzie.appserver.service;

import com.kenzie.appserver.repositories.ChexMixBagRepository;
import com.kenzie.appserver.repositories.model.ChexMixBag;
import com.kenzie.appserver.repositories.model.NutritionalInfo;
import com.kenzie.appserver.service.model.ChexMixBagDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.Optional;

import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChexMixBagServiceTest {
    private ChexMixBagRepository chexMixBagRepository;
    private ChexMixBagService chexMixBagService;

    @BeforeEach
    void setup() {
        chexMixBagRepository = mock(ChexMixBagRepository.class);
        chexMixBagService = new ChexMixBagService(chexMixBagRepository);
    }
    /** ------------------------------------------------------------------------
     *  chexMixBagService.findById
     *  ------------------------------------------------------------------------ **/

    @Test
    void findById() {
        // GIVEN
        String id = randomUUID().toString();
        LocalDate expirationDate = LocalDate.of(2026, 10, 15);
        NutritionalInfo nutritionalInfo = new NutritionalInfo();
        nutritionalInfo.setCalories(55);
        nutritionalInfo.setProtein(145);
        nutritionalInfo.setSugars(3);
        nutritionalInfo.setTotalFat(14);

        ChexMixBag record = new ChexMixBag();
        record.setId(id);
        record.setType("SpicyMix");
        record.setQuantity(22);
        record.setBatchNumber(randomUUID().toString());
        record.setSupplier("PepsiCo");
        record.setExpirationDate(expirationDate.toString());
        record.setNutritionalInfo(nutritionalInfo);

        // WHEN
        when(chexMixBagRepository.findById(id)).thenReturn(Optional.of(record));
        ChexMixBagDTO chexMixBagDTO = chexMixBagService.findById(id);

        // THEN
        Assertions.assertNotNull(chexMixBagDTO, "The object is returned");
        Assertions.assertEquals(record.getId(), chexMixBagDTO.getId(), "The id matches");
        Assertions.assertEquals(record.getType(), chexMixBagDTO.getType(), "The type matches");
        Assertions.assertEquals(record.getQuantity(), chexMixBagDTO.getQuantity(), "The quantity matches");
        Assertions.assertEquals(record.getBatchNumber(), chexMixBagDTO.getBatchNumber(), "The BatchNumber matches");
        Assertions.assertEquals(record.getSupplier(), chexMixBagDTO.getSupplier(), "The Supplier matches");
        Assertions.assertEquals(record.getExpirationDate(), chexMixBagDTO.getExpirationDate(), "The ExpirationDate matches");
        Assertions.assertEquals(record.getExpirationDate(), chexMixBagDTO.getExpirationDate(), "The ExpirationDate matches");
        Assertions.assertNotNull(record.getNutritionalInfo(), "The NutritionalInfo is returned");
        Assertions.assertEquals(record.getNutritionalInfo().getCalories(), chexMixBagDTO.getNutritionalInfo().getCalories(), "The Calories matches");
        Assertions.assertEquals(record.getNutritionalInfo().getProtein(), chexMixBagDTO.getNutritionalInfo().getProtein(), "The Protein matches");
        Assertions.assertEquals(record.getNutritionalInfo().getSugars(), chexMixBagDTO.getNutritionalInfo().getSugars(), "The Sugars matches");
        Assertions.assertEquals(record.getNutritionalInfo().getTotalFat(), chexMixBagDTO.getNutritionalInfo().getTotalFat(), "The TotalFat matches");


    }

    @Test
    void findById_invalid() {
        // GIVEN
        String id = randomUUID().toString();

        when(chexMixBagRepository.findById(id)).thenReturn(Optional.empty());

        // WHEN
        ChexMixBagDTO chexMixBagDTO = chexMixBagService.findById(id);

        // THEN
        Assertions.assertNull(chexMixBagDTO, "The chexMixBagDTO is null when not found");
    }

}
