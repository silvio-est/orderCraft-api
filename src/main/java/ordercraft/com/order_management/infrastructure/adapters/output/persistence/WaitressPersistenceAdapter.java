package ordercraft.com.order_management.infrastructure.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import ordercraft.com.order_management.application.ports.output.WaitressPersistencePort;
import ordercraft.com.order_management.domain.model.Waitress;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.mapper.WaitressPersistenceMapper;
import ordercraft.com.order_management.infrastructure.adapters.output.persistence.repository.WaitressRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WaitressPersistenceAdapter implements WaitressPersistencePort {

    private final WaitressRepository repository;
    private final WaitressPersistenceMapper mapper;

    @Override
    public Optional<Waitress> findByUsername(String username) {
        return repository.findByUsername(username)
                .map(mapper::toWaitress);
    }
}
