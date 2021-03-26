package tn.esprit.pidev.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pidev.entities.ConfirmationToken;
import tn.esprit.pidev.repositories.ConfirmationTokenRepository;

@Service
public class ConfirmationTokenService1 {
	
@Autowired
ConfirmationTokenRepository confirmationTokenRepository;

public void saveConfiramationtoken(	ConfirmationToken token){
	confirmationTokenRepository.save(token);
}

public ConfirmationToken getToken(String token) {
    return confirmationTokenRepository.findByToken(token);
}

public int setConfirmedAt(String token) {
    return confirmationTokenRepository.updateConfirmedAt(
            token, LocalDateTime.now());
}

}
