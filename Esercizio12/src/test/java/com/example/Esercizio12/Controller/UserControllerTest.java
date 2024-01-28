package com.example.Esercizio12.Controller;

import com.example.Esercizio12.Entities.UserEntity;
import com.example.Esercizio12.Repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepo userRepo;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetAllUsers() throws Exception {
        UserEntity user1 = new UserEntity(1L, "user1", "user1@example.com");
        UserEntity user2 = new UserEntity(2L, "user2", "user2@example.com");
        List<UserEntity> users = Arrays.asList(user1, user2);

        when(userRepo.findAll()).thenReturn(users);

        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(users.size()));
    }

    @Test
    public void testDeleteUser() throws Exception {
        Long userId = 1L;
        UserEntity user = new UserEntity(userId, "testuser", "testuser@example.com");

        when(userRepo.findById(userId)).thenReturn(Optional.of(user));

        mockMvc.perform(MockMvcRequestBuilders.delete("/users/{id}", userId))
                .andExpect(status().isOk())
                .andExpect(content().string("User deleted successfully!"));

        verify(userRepo, times(1)).deleteById(userId);
    }
}
