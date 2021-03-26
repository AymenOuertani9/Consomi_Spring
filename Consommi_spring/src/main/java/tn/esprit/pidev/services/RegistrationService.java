//package tn.esprit.pidev.services;
//
//import java.time.LocalDateTime;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import tn.esprit.pidev.entities.ConfirmationToken;
//
//@Service
//public class RegistrationService {
//	@Autowired
//    ConfirmationTokenService1 confirmationTokenService;
//	
//	@Autowired
//	UserServiceImpl uimpl;
//
//	
//	
//	
//	
//	
//	@Transactional
//    public String confirmToken(String token) {
//        ConfirmationToken confirmationToken = confirmationTokenService
//        		.getToken(token);
//        		
//        		
//                    
//                
////                .orElseThrow(() ->
////                        new IllegalStateException("token not found"));
//
//        if (confirmationToken.getConfirmedAt() != null) {
//            throw new IllegalStateException("email already confirmed");
//        }
//
//        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
//
//        if (expiredAt.isBefore(LocalDateTime.now())) {
//            throw new IllegalStateException("token expired");
//        }
//
//        confirmationTokenService.setConfirmedAt(token);
//        uimpl.enableAppUser(
//                confirmationToken.getUser().getEmail());
//        return "confirmed";
//    }
//
//
//}
