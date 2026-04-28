package org.dgnl.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.dgnl.Entity.Artifact;
import org.dgnl.repository.ArtifactRepository;

@Service
public class ArtifactService {

    @Autowired
    private ArtifactRepository repository;

    public Page<Artifact> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void save(Artifact a) {
        repository.save(a);
    }

    public Artifact findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}