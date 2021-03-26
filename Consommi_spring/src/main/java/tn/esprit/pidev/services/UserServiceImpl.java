package tn.esprit.pidev.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.pidev.entities.Chat;
import tn.esprit.pidev.entities.ConfirmationToken;
import tn.esprit.pidev.entities.Contrat;
import tn.esprit.pidev.entities.ResponseMessage;
import tn.esprit.pidev.entities.Role;
import tn.esprit.pidev.entities.UserConsomi;
import tn.esprit.pidev.repositories.ContratRepository;
import tn.esprit.pidev.repositories.IChatRepository;
import tn.esprit.pidev.repositories.RoleRepository;
import tn.esprit.pidev.repositories.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepository userrep;
	@Autowired
	RoleRepository rolerep;
	@Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	IChatRepository chatRepo;

//	@Autowired
//	ConfirmationTokenService conser;
	@Autowired
    ConfirmationTokenService1 confirmationTokenService;
	@Autowired
	   EmailSender emailSender;
	@Autowired
	ContratRepository cont;
	
    private final SimpMessagingTemplate messagingTemplate;


	  
//	@Override
//	public User ajouterUser(String userName ,String password, String confirmedPassword) {
//
//		User  user =userrep.findByUserName(userName);
//        if(user!=null) throw new RuntimeException("User already exists");
//        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
//        User User1=new User();
//        User1.setUserName(userName);
//        User1.setActive(true);
//        User1.setPassword(bCryptPasswordEncoder.encode(password));
//        userrep.save(User1);
//        addRoleToUser(userName,"USER");
//        return User1 ;
//        }
		
		
		
//		userrep.save(user);
//        appUser.setPassword(bCryptPasswordEncoder.encode(password));
//
//		return user.getIduser();	}

	@Override
	public Role save(Role role) {
        return rolerep.save(role);
	
	}

	@Override
	public UserConsomi loadUserByUsername(String username) {
        return userrep.findByUsername(username);
	}

	@Override
	public void addRoleToUser(String username, String role) {
		 UserConsomi User=userrep.findByUsername(username);
	        Role appRole=rolerep.findByRole(role);
	        User.getRole().add(appRole);		
	}



	@Override
	public String saveUser(UserConsomi user) {
		
		
     String hashPW =bCryptPasswordEncoder.encode(user.getPassword());
     user.setPassword(hashPW);
     userrep.save(user);
     String token = UUID.randomUUID().toString();
     ConfirmationToken confiramationtoken = new ConfirmationToken(
    		token,
    		LocalDateTime.now(),
    		LocalDateTime.now().plusMinutes(15),
    		user
    		
    		 );
     confirmationTokenService.saveConfiramationtoken(confiramationtoken);
     
     String link = "http://localhost:8085/confirm?token=" + token;
     emailSender.send(
    		 user.getEmail(),
             buildEmail(user.getUsername(), link));    	//return	userrep.save(user);
          return token;

	}
	
	
	public int activeUserConsomi(String username) {
        return userrep.activeUserConsomi(username);
    }
	
	
	@Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
        		.getToken(token);
        		
        		
                    
                
//                .orElseThrow(() ->
//                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        activeUserConsomi(
                confirmationToken.getUser().getUsername());
        return "confirmed";
    }

	
	
	
	@Override
	public UserConsomi findById(int User_id) {
		return userrep.findById(User_id).orElse(null);		
		
	}
	
	public int ajouterContrat(Contrat contrat) {
		cont.save(contrat);
		return contrat.getIdcontrat();
	}
	
	public void affecterContratAEmploye(int contratId, int employeId) {
		Contrat contratManagedEntity = cont.findById(contratId).get();
		UserConsomi employeManagedEntity = userrep.findById(employeId).get();

		contratManagedEntity.setUser(employeManagedEntity);
		cont.save(contratManagedEntity);
		
	}
	
	
	public int getNombreEmployeJPQL() {
		return cont.countemp();
	}
	
	public float getSalaireByEmployeIdJPQL(int employeId) {
		return userrep.getSalaire(employeId);
	}
	
	public Double getSalaires() {
		return userrep.getSalaires();
	}
	
	public Double getCarburant() {
		return userrep.getCarburant();
	}
	
	@Override
	public String sendMsg(Chat chat, int idSender, int idRecipient) {
		// TODO Auto-generated method stub
		UserConsomi senderUser=userrep.findById(idSender).orElse(null);
		UserConsomi recipientUser=userrep.findById(idRecipient).orElse(null);
		//test sur user connecte ou non
		//on va initialiser l'utilisateur is connected par true;
		
		if(senderUser!=null && recipientUser!=null) {
			recipientUser.setConnected(true);
			if(chat.getMsg()!=null && chat.getMsg().length()!=0)
						if(recipientUser.getConnected()==true) {
							notifyFrontend(chat.getMsg()+"  from :"+idSender+" to : "+idRecipient);
							//chat.setMsgDate(new Date());
							chat.setUserRecipient(recipientUser);
							chat.setUserSender(senderUser);
							chatRepo.save(chat);
							return "message sent successfully";
						}
			return "there is not a msg to send";
		}
		return "you need to verify the recipient user";
		
	}

	@Override
	public List<String> getMsg(int idSender, int idRecipient) {
		// TODO Auto-generated method stub
		
		return chatRepo.findMsgBetweenUsers(idSender, idRecipient);
	}

	 @Autowired
	    public UserServiceImpl(SimpMessagingTemplate messagingTemplate) {
	        this.messagingTemplate = messagingTemplate;
	    }
	 
	 @Override
	    public void notifyFrontend(final String message) {
	        ResponseMessage response = new ResponseMessage(message);
	        messagingTemplate.convertAndSend("/topic/messages", response);
	    }
	    
	    

	
	
//	
	
    private String buildEmail(String name, String link) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for registering. Please click on the below link to activate your account: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\"" + link + "\">Activate Now</a> </p></blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }

    


}
