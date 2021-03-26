package tn.esprit.pidev.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.pidev.entities.Commentaire;
import tn.esprit.pidev.entities.Publication;
import tn.esprit.pidev.entities.Rating;
import tn.esprit.pidev.entities.UserConsomi;
import tn.esprit.pidev.repositories.CommentaireRepository;
import tn.esprit.pidev.repositories.PublicationRepository;
import tn.esprit.pidev.repositories.RatingRepository;
import tn.esprit.pidev.repositories.UserRepository;
import java.nio.file.Files;
import java.nio.file.Path;




@Service
public class PublicationServiceImpl implements IPublicationService {
	
	@Autowired
	ICommentaireService comServ;
	@Autowired
	PublicationRepository pubrep;
	@Autowired
	RatingRepository var3;
	@Autowired
	CommentaireRepository cmnt1;
    @Autowired
    UserRepository use;
	@Override
	public String addPublication (Publication pub,int idUser) {
		// TODO Auto-generated method stub
		
		if(pub.getTopic()==null || pub.getTopic().isEmpty()) return "you must fill in the topic";
		if(pub.getImageUrl()==null || pub.getImageUrl().isEmpty()) pub.setImageUrl("defaultImage.jpg");
		
		//Test sujets redondants  
		//if(pubRepo.findByTitle(pub.getTitle()).size()>5) return "there are 5 publications with this title so you can interact with them without publishing new one";
		

	    UserConsomi user = use.findById(idUser).orElse(null);
	    if(user!=null) {
			pub.setPublicationUser(user);
			//pub.setNotified(true);
			pubrep.save(pub);
			return "Successful Add";
	    }


		
		return "Failed Add";
	}


	
	
	@Override
	public int ajouterPublication(Publication publication) {
		pubrep.save(publication);
		return publication.getIdpub();		
	}

	

	@Override
	public void deletePublicationById(int idpub) {
		Publication pubde = pubrep.findById(idpub).get();
		pubrep.delete(pubde);		
	}

	@Override
	public List<String> getAllPublicationJPQL() {
		
 	return pubrep.publication();
	}
	
	@Override
	public List<Publication> findPublicationsByIdUser(int idUser) {
		// TODO Auto-generated method stub
		return (List<Publication>) pubrep.findPublicationsByIdUser(idUser);
	}


	@Override
	public void mettreAjourPublicationById(String topic, int pubId) {
		pubrep.mettreAjourtopicByPublication(topic, pubId);		
	}
	
//	public void uploadImage(final MultipartFile file) throws IOException {
//        UUID imgGeneratedId = UUID.nameUUIDFromBytes(file.getBytes());
//        File convertFile = new File("src/main/frontend/src/assets/images/" + imgGeneratedId + file.getOriginalFilename());
//        Publication foundPost = pubrep.findFirstByOrderByIdDesc();
//        foundPost.setImageUrl("./assets/images/" + imgGeneratedId + file.getOriginalFilename());
//        convertFile.createNewFile();
//        FileOutputStream fout = new FileOutputStream(convertFile);
//        fout.write(file.getBytes());
//        fout.close();
//        pubrep.save(foundPost);
//    }

	@PreAuthorize("hasRole('USER')")
    public void rate(final Integer idpub, final Integer buttonState) {
        Publication foundPost = pubrep.findById(idpub).get();
        if (buttonState.equals(0)) {
            foundPost.setRatingPoints(foundPost.getRatingPoints() - 1);
        } else if (buttonState.equals(1)) {
            foundPost.setRatingPoints(foundPost.getRatingPoints() + 1);
        }
        pubrep.save(foundPost);
    }
	
	
	@Override
	public List<Publication> Subjectnew() {
		// TODO Auto-generated method stub
		return (List<Publication>) pubrep.findAllSortedBydateTimeOfPublication();
	}
	@Override
	public List<Publication> search(String topic) {
		 List<Publication> list =  (List<Publication>) pubrep.search(topic); 
		  return list; }
	
	@Override
	public List<Publication> searchbest() {

		return pubrep.searchbest();

	}



	@Override
	public Rating addEv(Rating e, Integer id) {
		
			
		Publication c = pubrep.findById(id).get();
			
			List<Publication> my = var3.evsave();
			if(my.contains(c)) {
				Rating v = var3.findev(c);
				
				v.setNbretoile(v.getNbretoile()+e.getNbretoile());
					
					
				
//				v.setL(v.getL()+e.getL());
//				v.setD(v.getD()+e.getD());
//				v.setH(v.getH()+e.getH());
//				v.setS(v.getS()+e.getS());
//				v.setM(v.getM()+e.getM());
				
				var3.save(v);
				return v ;
				
				
		}
			else {
				e.setPublication(c);
				var3.save(e);
				return e;
				
				
			}
		}
	
	
	@Override
	public void assignCommentToPublication(int idComment, int idPublication) {
		// TODO Auto-generated method stub
		Commentaire cmt = cmnt1.findById(idComment).orElse(null);
		Publication pub = pubrep.findById(idPublication).orElse(null);
		
		
		if(cmt !=null && pub !=null) {
				cmt.setPublication(pub);
				//cmt.setNotified(false);
			//	pub.setNotified(false);
				pubrep.save(pub);
				cmnt1.save(cmt);
				
	}

}
	
	@Override
	public long getFileSize(Path path) {
		// TODO Auto-generated method stub
		long size=0;
		try {
			 size = Files.size(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return size;
	}
	
	
	@Override
	public Publication getPublicationById(int id,int idUser) {
		// TODO Auto-generated method stub
		Publication pub =pubrep.findById(id).orElse(null);
		if (pub!=null && pub.getPublicationUser().getIduser()==idUser) {
		//	pub.setNotified(true);
			for(Commentaire cmt:comServ.findCommentsByPublication(id)) {
		//		cmt.setNotified(true);
				cmnt1.save(cmt);
			}
		}
		
		return pub;
	}

	@Override
	public String updatePublication(Publication pub) {
		// TODO Auto-generated method stub
		//if(pub.getDescription()==null || pub.getDescription().isEmpty()) return "you must fill in the description";
	//	if(pub.getTitle()==null || pub.getTitle().isEmpty()) return "you have to put the title";
	//	pub.setPublicationDate(new Date());
		pubrep.save(pub);
		return "Successful Update";
	}


}
