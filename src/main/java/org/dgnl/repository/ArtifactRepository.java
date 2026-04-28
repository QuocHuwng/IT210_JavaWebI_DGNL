package org.dgnl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.dgnl.Entity.Artifact;

public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
}
