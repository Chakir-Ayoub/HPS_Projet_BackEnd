package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.GroupeDto;
import com.example.hps.entity.Sous_Groupe;

public interface GroupeService {
	GroupeDto AjouterGroupe(GroupeDto groupeDto,String email);
	GroupeDto ModifierGroupe(GroupeDto groupeDto, Long id,String email);
	void SupperimerGroupe(Long id,String email);
	List<GroupeDto> GetAllGroupe(String email);
	GroupeDto GetById(Long id,String email);
	GroupeDto Affecte_Utilisateur_Groupe(Long iduser,Long id,String email);
	GroupeDto Supperimer_User_Groupe(Long idgroupe,Long iduser,String email);
	GroupeDto Affecte_Sous_Group_Groupe(Sous_Groupe sousGroupe,Long id);
	GroupeDto Supperimer_Sous_groupe_Groupe(Long idgroupe,Long idsousgroupe);
	Long GetCountUserInGroupe(Long id);

}
