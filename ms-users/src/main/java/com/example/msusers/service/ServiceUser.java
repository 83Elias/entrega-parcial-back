package com.example.msusers.service;


import com.example.msusers.domain.User;
import com.example.msusers.feing.BillsFeign;
import com.example.msusers.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.ws.rs.NotFoundException;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ServiceUser implements UserRepository {

    private final Keycloak keyclaokClient;
    private final BillsFeign billsFeign;

    @Value("${ms.keycloak.realm}")
    private String realm;


    @Override
    public Optional<User> findById(String id) {
        UserRepresentation userRepresentation;
        try {
            userRepresentation = keyclaokClient.realm(realm)
                    .users().get(id)
                    .toRepresentation();
        } catch (NotFoundException e) {
            return Optional.empty();
        }
        return Optional.of(toUser(userRepresentation));

    }

    private User toUser(UserRepresentation userRepresentation) {
        return User.builder()
                .id(userRepresentation.getId())
                .userName(userRepresentation.getUsername())
                .email(userRepresentation.getEmail())
                .firstName(userRepresentation.getFirstName())
                .lastName(userRepresentation.getLastName())
                .build();
    }


    public Optional<User> getUserWithBills(String id) {
        UserRepresentation userRepresentation;
        try {
            userRepresentation = keyclaokClient.realm(realm)
                    .users().get(id)
                    .toRepresentation();
        } catch (NotFoundException e) {
            return Optional.empty();
        }

        Optional<User> user =Optional.of(toUser(userRepresentation));

        user.get().setBills(billsFeign.getBillsPerIdUser(user.get().getId()));

        return user;

    }
}
