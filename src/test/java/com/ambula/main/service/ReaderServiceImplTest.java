package com.ambula.main.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ambula.main.dto.Data;
import com.ambula.main.entity.User;
import com.ambula.main.enums.Role;
import com.ambula.main.exception.MyRuntimeException;
import com.ambula.main.repository.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ReaderServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ReaderServiceImplTest {
    @Autowired
    private ReaderServiceImpl readerServiceImpl;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link ReaderServiceImpl#getUsers(int)}
     */
    @Test
    void testGetUsers() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(MyRuntimeException.class, () -> readerServiceImpl.getUsers(10));
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link ReaderServiceImpl#getUsers(int)}
     */
    @Test
    void testGetUsers2() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("User list is empty.");
        user.setRole(Role.ADMIN);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        assertThrows(MyRuntimeException.class, () -> readerServiceImpl.getUsers(10));
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link ReaderServiceImpl#getUsers(int)}
     */
    @Test
    void testGetUsers3() {
        when(userRepository.findAll()).thenThrow(new MyRuntimeException("An error occurred"));
        assertThrows(MyRuntimeException.class, () -> readerServiceImpl.getUsers(10));
        verify(userRepository).findAll();
    }

    /**
     * Method under test: {@link ReaderServiceImpl#getUsers(int)}
     */
    @Test
    void testGetUsers4() {
        User user = mock(User.class);
        when(user.getLatitude()).thenReturn(10.0d);
        when(user.getLongitude()).thenReturn(10.0d);
        when(user.getRole()).thenReturn(Role.READER);
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLatitude(anyDouble());
        doNothing().when(user).setLongitude(anyDouble());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("User list is empty.");
        user.setRole(Role.ADMIN);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        assertThrows(MyRuntimeException.class, () -> readerServiceImpl.getUsers(10));
        verify(userRepository).findAll();
        verify(user).getRole();
        verify(user).getLatitude();
        verify(user).getLongitude();
        verify(user).setId(anyLong());
        verify(user).setLatitude(anyDouble());
        verify(user).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
    }

    /**
     * Method under test: {@link ReaderServiceImpl#getUsers(int)}
     */
    @Test
    void testGetUsers5() {
        User user = mock(User.class);
        when(user.getLatitude()).thenReturn(10.0d);
        when(user.getLongitude()).thenReturn(10.0d);
        when(user.getRole()).thenReturn(Role.READER);
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLatitude(anyDouble());
        doNothing().when(user).setLongitude(anyDouble());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("User list is empty.");
        user.setRole(Role.ADMIN);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals(1, readerServiceImpl.getUsers(1).size());
        verify(userRepository).findAll();
        verify(user).getRole();
        verify(user).getLatitude();
        verify(user).getLongitude();
        verify(user).setId(anyLong());
        verify(user).setLatitude(anyDouble());
        verify(user).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
    }

    /**
     * Method under test: {@link ReaderServiceImpl#getUsers(int)}
     */
    @Test
    void testGetUsers6() {
        User user = mock(User.class);
        when(user.getLatitude()).thenThrow(new MyRuntimeException("An error occurred"));
        when(user.getLongitude()).thenThrow(new MyRuntimeException("An error occurred"));
        when(user.getRole()).thenReturn(Role.READER);
        doNothing().when(user).setId(anyLong());
        doNothing().when(user).setLatitude(anyDouble());
        doNothing().when(user).setLongitude(anyDouble());
        doNothing().when(user).setName((String) any());
        doNothing().when(user).setRole((Role) any());
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("User list is empty.");
        user.setRole(Role.ADMIN);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        assertThrows(MyRuntimeException.class, () -> readerServiceImpl.getUsers(10));
        verify(userRepository).findAll();
        verify(user).getRole();
        verify(user).getLongitude();
        verify(user).setId(anyLong());
        verify(user).setLatitude(anyDouble());
        verify(user).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
    }

    /**
     * Method under test: {@link ReaderServiceImpl#updateData(Data)}
     */
    @Test
    void testUpdateData() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(MyRuntimeException.class, () -> readerServiceImpl.updateData(new Data(123L, 10.0d, 10.0d)));
        verify(userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link ReaderServiceImpl#updateData(Data)}
     */
    @Test
    void testUpdateData2() {
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
        assertSame(user1, readerServiceImpl.updateData(new Data(123L, 10.0d, 10.0d)));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
        verify(user).getRole();
        verify(user).setId(anyLong());
        verify(user, atLeast(1)).setLatitude(anyDouble());
        verify(user, atLeast(1)).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
    }

    /**
     * Method under test: {@link ReaderServiceImpl#updateData(Data)}
     */
    @Test
    void testUpdateData3() {
        User user = new User();
        user.setId(123L);
        user.setLatitude(10.0d);
        user.setLongitude(10.0d);
        user.setName("Name");
        user.setRole(Role.ADMIN);
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findById((Long) any())).thenReturn(Optional.empty());
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
        assertThrows(MyRuntimeException.class, () -> readerServiceImpl.updateData(new Data(123L, 10.0d, 10.0d)));
        verify(userRepository).findById((Long) any());
        verify(user1).setId(anyLong());
        verify(user1).setLatitude(anyDouble());
        verify(user1).setLongitude(anyDouble());
        verify(user1).setName((String) any());
        verify(user1).setRole((Role) any());
    }

    /**
     * Method under test: {@link ReaderServiceImpl#updateData(Data)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateData4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.ambula.main.service.ReaderServiceImpl.updateData(ReaderServiceImpl.java:57)
        //   See https://diff.blue/R013 to resolve this issue.

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
        readerServiceImpl.updateData(null);
    }

    /**
     * Method under test: {@link ReaderServiceImpl#updateData(Data)}
     */
    @Test
    void testUpdateData5() {
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
        when(userRepository.save((User) any())).thenThrow(new MyRuntimeException("An error occurred"));
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(MyRuntimeException.class, () -> readerServiceImpl.updateData(new Data(123L, 10.0d, 10.0d)));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((Long) any());
        verify(user).getRole();
        verify(user).setId(anyLong());
        verify(user, atLeast(1)).setLatitude(anyDouble());
        verify(user, atLeast(1)).setLongitude(anyDouble());
        verify(user).setName((String) any());
        verify(user).setRole((Role) any());
    }
}

