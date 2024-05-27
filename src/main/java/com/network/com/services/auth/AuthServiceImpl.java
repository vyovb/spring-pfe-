package com.network.com.services.auth;


import com.network.com.dto.SignupRequest;
import com.network.com.dto.UserDto;
import com.network.com.entity.Order;
import com.network.com.entity.User;
import com.network.com.enums.OrderStatus;
import com.network.com.enums.UserRole;
import com.network.com.repository.OrderRepo;
import com.network.com.repository.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserDto createUser(SignupRequest signupRequest){
        User user=new User();
        user.setEmail(signupRequest.getEmail());
        user.setUsername(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        User createdUser = userRepo.save(user);
        Order order=new Order();
        order.setAmount(0L);
        order.setTotalAmount(0L);
        order.setDiscount(0L);
        order.setUser(createdUser);
        order.setOrderStatus(OrderStatus.Pending);
        orderRepo.save(order);
        UserDto userDto=new UserDto();
        userDto.setId(createdUser.getId());
        return userDto;


    }
    public boolean hasUserWithEmail(String email){
        return userRepo.findFirstByEmail(email).isPresent();
    }





@PostConstruct
    public void createAdminAccount(){
        User adminAccount = userRepo.findByRole(UserRole.ADMIN);
        if (null==adminAccount){
            User user = new User();
            user.setEmail("admin1@emsi.com");
            user.setUsername("admin1");
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepo.save(user);
        }
    }
}
