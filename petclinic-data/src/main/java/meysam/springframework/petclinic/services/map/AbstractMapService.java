package meysam.springframework.petclinic.services.map;

import meysam.springframework.petclinic.model.BaseEntity;
import meysam.springframework.petclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    protected Map<Long, T> map = new HashMap<>();

    @Override
    public Set<T> findAll () {
        return new HashSet<>(map.values());
    }

    @Override
    public T findById (ID id) {
        return map.get(id);
    }

    public T save (T object) {
        if (object != null) {
            if (object.getId() == null)
                object.setId(getNextId());
            map.put(object.getId(), object);
        }
        else
            throw new RuntimeException(object.getClass()+" object cannot be null!");

        return  object;
    }

    @Override
    public void deleteById (ID id) {
        map.remove(id);
    }

    @Override
    public void delete (T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }
}
