package com.example.dbclmtest.data;

import com.example.dbclmtest.domain.model.Nace;

import java.util.ArrayList;
import java.util.List;

public class NaceData {

    public static List<Nace> getListNaceDetails(Integer size) {

        List<Nace> naceList = new ArrayList<>(size);

        for (Integer count = 0; count < size; count++) {
            naceList.add(getNaceDetails(count));
        }

        return naceList;
    }

    public static Nace getNaceDetails(Integer count) {
        return Nace.builder()
                .order(398481L + count)
                .code("code")
                .level(1)
                .parent("03.2")
                .description("Growing of tropical and subtropical fruits")
                .thisItemIncludes("This class includes:\n- growing of tropical and subtropical fruits.")
                .thisItemAlsoIncludes("Fresh fruit")
                .rulings("")
                .thisItemExcludes("Frozen fruit")
                .referenceToIsicRev("0123")
                .build();
    }
}
