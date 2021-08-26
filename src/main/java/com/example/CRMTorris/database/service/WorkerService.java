package com.example.CRMTorris.database.service;

import com.example.CRMTorris.database.model.Worker;
import com.example.CRMTorris.database.repository.RoleRepository;
import com.example.CRMTorris.database.repository.WorkerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerService implements UserDetailsService {

    private static final String NOT_FOUND_MESSAGE = "User %s not found";

    @PersistenceContext
    private EntityManager entityManager;
    private final WorkerRepository workerRepository;
    private final RoleRepository roleRepository;

    public WorkerService(WorkerRepository workerRepository, RoleRepository roleRepository) {
        this.workerRepository = workerRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return workerRepository
                .findByName(s)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(NOT_FOUND_MESSAGE, s)));
    }

    public Worker findUserById(Long userId) {
        Optional<Worker> userFromDb = workerRepository.findById(userId);
        return userFromDb.orElse(new Worker());
    }

    public List<Worker> allWorkers() {
        return workerRepository.findAll();
    }

    public boolean saveWorker(Worker worker) {
        if (workerRepository.findByName(worker.getName()).isPresent()) {
            return false;
        }

        worker.setRole(roleRepository.findAll().get(0));
        worker.setPassword(new BCryptPasswordEncoder().encode(worker.getPassword()));
        workerRepository.save(worker);
        return true;
    }

    public boolean deleteWorker(Long userId) {
        if (workerRepository.findById(userId).isPresent()) {
            workerRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<Worker> userList(Long idMin) {
        return entityManager.createQuery("SELECT u FROM Worker u WHERE u.id > :paramId", Worker.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
