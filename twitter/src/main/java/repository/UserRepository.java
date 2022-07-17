package repository;

import base.repository.BaseRepository;
import domain.User;

public interface UserRepository extends BaseRepository<User,Long> {
    User signIn(String username,String Password);
}
