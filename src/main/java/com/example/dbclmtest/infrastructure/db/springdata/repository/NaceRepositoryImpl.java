package com.example.dbclmtest.infrastructure.db.springdata.repository;

import com.example.dbclmtest.domain.model.Nace;
import com.example.dbclmtest.domain.repository.NaceRepository;
import com.example.dbclmtest.infrastructure.db.springdata.dbo.NaceEntity;
import com.example.dbclmtest.infrastructure.db.springdata.mapper.NaceEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NaceRepositoryImpl implements NaceRepository {

    private final NaceEntityRepository naceEntityRepository;
    private final NaceEntityMapper naceEntityMapper;

    @Override
    public Nace putNaceDetails(Nace nace) {
        NaceEntity naceEntity = naceEntityRepository.save(naceEntityMapper.naceEntityToNace(nace));
        return naceEntityMapper.naceyToNaceEntity(naceEntity);
    }

    @Override
    public Nace getNaceDetails(Long order) {
        Optional<NaceEntity> nace = naceEntityRepository.findById(order);
        return nace.map(naceEntityMapper::naceyToNaceEntity).orElse(null);
    }

    @Transactional
    @Override
    public List<Nace> setNaseDataDetails(List<Nace> naceList) {
        List<NaceEntity> naceEntityList = naceEntityRepository.saveAll(naceList.stream().map(naceEntityMapper::naceEntityToNace).collect(Collectors.toList()));
        return naceEntityList.stream().map(naceEntityMapper::naceyToNaceEntity).collect(Collectors.toList());
    }
}
