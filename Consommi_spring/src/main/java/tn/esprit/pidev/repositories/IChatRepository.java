package tn.esprit.pidev.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pidev.entities.Chat;

@Repository
public interface IChatRepository extends JpaRepository<Chat, Integer> {
	@Query("SELECT message.msg FROM Chat message WHERE message.userRecipient.id=:idRecipient AND message.userSender.id=:idSender ORDER BY message.msgDate ASC")
	public List<String> findMsgBetweenUsers(@Param("idSender")int idSender,@Param("idRecipient")int idRecipient);



}
