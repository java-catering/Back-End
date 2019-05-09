package app.services;

import app.models.Role;
import app.repositorys.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService
{
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository)
    {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(Long id)
    {
        return roleRepository.findById(id).orElse(null);
    }
}
