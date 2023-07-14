package com.ambula.main.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ambula.main.entity.User;
import com.ambula.main.enums.Role;
import com.ambula.main.exception.MyRuntimeException;
import com.ambula.main.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AdminServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AdminServiceImplTest {
    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link AdminServiceImpl#registerAdmin(User)}
     */
    @Test
    void testRegisterAdmin() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        when(userRepository.save((User) any())).thenReturn(user);

        User user1 = new User();
        user1.setId(123L);
        user1.setLatitude(10.0d);
        user1.setLongitude(10.0d);
        user1.setName("Name");
        user1.setRole(Role.ADMIN);
        assertSame(user, adminServiceImpl.registerAdmin(user1));
        verify(userRepository).save((User) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#registerAdmin(User)}
     */
    @Test
    void testRegisterAdmin2() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        when(userRepository.save((User) any())).thenReturn(user);
        User user1 = mock(User.class);
        when(user1.getRole()).thenReturn(Role.READER);
        doNothing().when(user1).setId(anyLong());
        doNothing().when(user1).setLatitude(anyDouble());
        doNothing().when(user1).setLongitude(anyDouble());
        doNothing().when(user1).setName((String) any());
        doNothing().when(user1).setRole((Role) any());
        user1.setId(123L);
        user1.setLatitude(10.0d);
        user1.setLongitude(10.0d);
        user1.setName("Name");
        user1.setRole(Role.ADMIN);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.registerAdmin(user1));
        verify(user1).getRole();
        verify(user1).setId(anyLong());
        verify(user1).setLatitude(anyDouble());
        verify(user1).setLongitude(anyDouble());
        verify(user1).setName((String) any());
        verify(user1).setRole((Role) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#registerUser(User, long)}
     */
    @Test
    void testRegisterUser() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);

        User user1 = new User();
        user1.setId(123L);
        user1.setLatitude(10.0d);
        user1.setLongitude(10.0d);
        user1.setName("Name");
        user1.setRole(Role.ADMIN);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.registerUser(user1, 123L));
        verify(userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#registerUser(User, long)}
     */
    @Test
    void testRegisterUser2() {
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.READER);
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLatitude(anyDouble());
        doNothing().when(user).setLongitude(anyDouble());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);

        User user1 = new User();
        user1.setId(123L);
        user1.setLatitude(10.0d);
        user1.setLongitude(10.0d);
        user1.setName("Name");
        user1.setRole(Role.ADMIN);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.registerUser(user1, 123L));
        verify(userRepository).findById((Long) any());
        verify(user).getRole();
        verify(user).setId(anyLong());
        verify(user).setLatitude(anyDouble());
        verify(user).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#registerUser(User, long)}
     */
    @Test
    void testRegisterUser3() {
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.ADMIN);
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLatitude(anyDouble());
        doNothing().when(user).setLongitude(anyDouble());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);

        User user1 = new User();
        user1.setId(123L);
        user1.setLatitude(10.0d);
        user1.setLongitude(10.0d);
        user1.setName("Name");
        user1.setRole(Role.ADMIN);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.registerUser(user1, 123L));
        verify(userRepository).findById((Long) any());
        verify(user).setId(anyLong());
        verify(user).setLatitude(anyDouble());
        verify(user).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#registerUser(User, long)}
     */
    @Test
    void testRegisterUser4() {
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.ADMIN);
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLatitude(anyDouble());
        doNothing().when(user).setLongitude(anyDouble());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setId(123L);
        user1.setLatitude(10.0d);
        user1.setLongitude(10.0d);
        user1.setName("Name");
        user1.setRole(Role.ADMIN);
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        User user2 = mock(User.class);
        when(user2.getRole()).thenReturn(Role.READER);
        doNothing().when(user2).setId(anyLong());
        doNothing().when(user2).setLatitude(anyDouble());
        doNothing().when(user2).setLongitude(anyDouble());
        doNothing().when(user2).setName((String) any());
        doNothing().when(user2).setRole((Role) any());
        user2.setId(123L);
        user2.setLatitude(10.0d);
        user2.setLongitude(10.0d);
        user2.setName("Name");
        user2.setRole(Role.ADMIN);
        assertSame(user1, adminServiceImpl.registerUser(user2, 123L));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
        verify(user).getRole();
        verify(user).setId(anyLong());
        verify(user).setLatitude(anyDouble());
        verify(user).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
        verify(user2).getRole();
        verify(user2).setId(anyLong());
        verify(user2).setLatitude(anyDouble());
        verify(user2).setLongitude(anyDouble());
        verify(user2).setName((String) any());
        verify(user2).setRole((Role) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#registerUser(User, long)}
     */
    @Test
    void testRegisterUser5() {
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.ADMIN);
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLatitude(anyDouble());
        doNothing().when(user).setLongitude(anyDouble());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.save((User) any())).thenThrow(new MyRuntimeException("An error occurred"));
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        User user1 = mock(User.class);
        when(user1.getRole()).thenReturn(Role.READER);
        doNothing().when(user1).setId(anyLong());
        doNothing().when(user1).setLatitude(anyDouble());
        doNothing().when(user1).setLongitude(anyDouble());
        doNothing().when(user1).setName((String) any());
        doNothing().when(user1).setRole((Role) any());
        user1.setId(123L);
        user1.setLatitude(10.0d);
        user1.setLongitude(10.0d);
        user1.setName("Name");
        user1.setRole(Role.ADMIN);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.registerUser(user1, 123L));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
        verify(user).getRole();
        verify(user).setId(anyLong());
        verify(user).setLatitude(anyDouble());
        verify(user).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
        verify(user1).getRole();
        verify(user1).setId(anyLong());
        verify(user1).setLatitude(anyDouble());
        verify(user1).setLongitude(anyDouble());
        verify(user1).setName((String) any());
        verify(user1).setRole((Role) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#updateUser(User, long)}
     */
    @Test
    void testUpdateUser() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setId(123L);
        user1.setLatitude(10.0d);
        user1.setLongitude(10.0d);
        user1.setName("Name");
        user1.setRole(Role.ADMIN);
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);

        User user2 = new User();
        user2.setId(123L);
        user2.setLatitude(10.0d);
        user2.setLongitude(10.0d);
        user2.setName("Name");
        user2.setRole(Role.ADMIN);
        assertSame(user1, adminServiceImpl.updateUser(user2, 123L));
        verify(userRepository).save((User) any());
        verify(userRepository, atLeast(1)).findById((Long) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#updateUser(User, long)}
     */
    @Test
    void testUpdateUser2() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.save((User) any())).thenThrow(new MyRuntimeException("An error occurred"));
        when(userRepository.findById((Long) any())).thenReturn(ofResult);

        User user1 = new User();
        user1.setId(123L);
        user1.setLatitude(10.0d);
        user1.setLongitude(10.0d);
        user1.setName("Name");
        user1.setRole(Role.ADMIN);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.updateUser(user1, 123L));
        verify(userRepository).save((User) any());
        verify(userRepository, atLeast(1)).findById((Long) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#updateUser(User, long)}
     */
    @Test
    void testUpdateUser3() {
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.READER);
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLatitude(anyDouble());
        doNothing().when(user).setLongitude(anyDouble());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setId(123L);
        user1.setLatitude(10.0d);
        user1.setLongitude(10.0d);
        user1.setName("Name");
        user1.setRole(Role.ADMIN);
        when(userRepository.save((User) any())).thenReturn(user1);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);

        User user2 = new User();
        user2.setId(123L);
        user2.setLatitude(10.0d);
        user2.setLongitude(10.0d);
        user2.setName("Name");
        user2.setRole(Role.ADMIN);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.updateUser(user2, 123L));
        verify(userRepository).findById((Long) any());
        verify(user).getRole();
        verify(user).setId(anyLong());
        verify(user).setLatitude(anyDouble());
        verify(user).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#updateUser(User, long)}
     */
    @Test
    void testUpdateUser4() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        User user1 = mock(User.class);
        when(user1.getRole()).thenReturn(Role.ADMIN);
        doNothing().when(user1).setId(anyLong());
        doNothing().when(user1).setLatitude(anyDouble());
        doNothing().when(user1).setLongitude(anyDouble());
        doNothing().when(user1).setName((String) any());
        doNothing().when(user1).setRole((Role) any());
        user1.setId(123L);
        user1.setLatitude(10.0d);
        user1.setLongitude(10.0d);
        user1.setName("Name");
        user1.setRole(Role.ADMIN);

        User user2 = new User();
        user2.setId(123L);
        user2.setLatitude(10.0d);
        user2.setLongitude(10.0d);
        user2.setName("Name");
        user2.setRole(Role.ADMIN);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.updateUser(user2, 123L));
        verify(userRepository).findById((Long) any());
        verify(user1).setId(anyLong());
        verify(user1).setLatitude(anyDouble());
        verify(user1).setLongitude(anyDouble());
        verify(user1).setName((String) any());
        verify(user1).setRole((Role) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#deleteUser(long, long)}
     */
    @Test
    void testDeleteUser() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);
        doNothing().when(userRepository).delete((User) any());
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(user, adminServiceImpl.deleteUser(123L, 123L));
        verify(userRepository, atLeast(1)).findById((Long) any());
        verify(userRepository).delete((User) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#deleteUser(long, long)}
     */
    @Test
    void testDeleteUser2() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);
        doThrow(new MyRuntimeException("An error occurred")).when(userRepository).delete((User) any());
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.deleteUser(123L, 123L));
        verify(userRepository, atLeast(1)).findById((Long) any());
        verify(userRepository).delete((User) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#deleteUser(long, long)}
     */
    @Test
    void testDeleteUser3() {
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.READER);
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLatitude(anyDouble());
        doNothing().when(user).setLongitude(anyDouble());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);
        doNothing().when(userRepository).delete((User) any());
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.deleteUser(123L, 123L));
        verify(userRepository).findById((Long) any());
        verify(user).getRole();
        verify(user).setId(anyLong());
        verify(user).setLatitude(anyDouble());
        verify(user).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#deleteUser(long, long)}
     */
    @Test
    void testDeleteUser4() {
        doNothing().when(userRepository).delete((User) any());
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.ADMIN);
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLatitude(anyDouble());
        doNothing().when(user).setLongitude(anyDouble());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.deleteUser(123L, 123L));
        verify(userRepository).findById((Long) any());
        verify(user).setId(anyLong());
        verify(user).setLatitude(anyDouble());
        verify(user).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#getAllUsers(long)}
     */
    @Test
    void testGetAllUsers() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.getAllUsers(123L));
        verify(userRepository).findAll();
        verify(userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#getAllUsers(long)}
     */
    @Test
    void testGetAllUsers2() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findAll()).thenThrow(new MyRuntimeException("An error occurred"));
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.getAllUsers(123L));
        verify(userRepository).findAll();
        verify(userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#getAllUsers(long)}
     */
    @Test
    void testGetAllUsers3() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);

        User user1 = new User();
        user1.setId(123L);
        user1.setLatitude(10.0d);
        user1.setLongitude(10.0d);
        user1.setName("User list is empty");
        user1.setRole(Role.ADMIN);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        when(userRepository.findAll()).thenReturn(userList);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        List<User> actualAllUsers = adminServiceImpl.getAllUsers(123L);
        assertSame(userList, actualAllUsers);
        assertEquals(1, actualAllUsers.size());
        verify(userRepository).findAll();
        verify(userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#getAllUsers(long)}
     */
    @Test
    void testGetAllUsers4() {
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.READER);
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLatitude(anyDouble());
        doNothing().when(user).setLongitude(anyDouble());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.getAllUsers(123L));
        verify(userRepository).findById((Long) any());
        verify(user).getRole();
        verify(user).setId(anyLong());
        verify(user).setLatitude(anyDouble());
        verify(user).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
    }

    /**
     * Method under test: {@link AdminServiceImpl#getAllUsers(long)}
     */
    @Test
    void testGetAllUsers5() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.ADMIN);
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLatitude(anyDouble());
        doNothing().when(user).setLongitude(anyDouble());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        assertThrows(MyRuntimeException.class, () -> adminServiceImpl.getAllUsers(123L));
        verify(userRepository).findById((Long) any());
        verify(user).setId(anyLong());
        verify(user).setLatitude(anyDouble());
        verify(user).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
    }
}

