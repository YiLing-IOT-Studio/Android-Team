package top.wuhaojie.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import top.wuhaojie.domain.User;

import java.util.List;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2016/10/12 21:43
 * Version: 1.0
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {


    List<User> findByName(String name);


}
