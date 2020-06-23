package guru.springframework.controllers;

import guru.springframework.model.Owner;
import guru.springframework.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

  @Mock
  OwnerService ownerService;

  @InjectMocks
  OwnerController ownerController;

  Set<Owner> owners;

  MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    owners = new HashSet<>();
    owners.add(Owner.builder().id(34L).build());
    owners.add(Owner.builder().id(23L).build());
    mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
  }

  @Test
  void listOwners() throws Exception {
    when(ownerService.findAll()).thenReturn(owners);
    mockMvc.perform(get("/owners/index"))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/index"))
            .andExpect(model().attribute("owners", hasSize(2)));
  }

  @Test
  void listOwnersRoot() throws Exception {
    when(ownerService.findAll()).thenReturn(owners);
    mockMvc.perform(get("/owners"))
            .andExpect(status().isOk())
            .andExpect(view().name("owners/index"))
            .andExpect(model().attribute("owners", hasSize(2)));
  }

  @Test
  void findOwners() throws Exception {
    mockMvc.perform(get("/owners/find"))
    .andExpect(status().isOk())
    .andExpect(view().name("notImplemented"));
    verifyZeroInteractions(ownerService);
  }
}