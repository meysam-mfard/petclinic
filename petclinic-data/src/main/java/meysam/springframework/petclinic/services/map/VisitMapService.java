package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.Visit;
import meysam.springframework.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet()==null || visit.getPet().getId()==null || visit.getPet().getOwner()==null ||
                visit.getPet().getOwner().getId()==null)
            throw new RuntimeException("Invalid Visit!");

        return super.save(visit);
    }
}