package com.example.hps.service;

import java.util.List;

import com.example.hps.dto.GroupeDto;
import com.example.hps.entity.Sous_Groupe;

public interface GroupeService {
	GroupeDto AjouterGroupe(GroupeDto groupeDto);
	GroupeDto ModifierGroupe(GroupeDto groupeDto, Long id);
	void SupperimerGroupe(Long id);
	List<GroupeDto> GetAllGroupe();
	GroupeDto GetById(Long id);
	GroupeDto Affecte_Utilisateur_Groupe(Long iduser,Long id);
	GroupeDto Supperimer_User_Groupe(Long idgroupe,Long iduser);
	GroupeDto Affecte_Sous_Group_Groupe(Sous_Groupe sousGroupe,Long id);
	GroupeDto Supperimer_Sous_groupe_Groupe(Long idgroupe,Long idsousgroupe);
	Long GetCountUserInGroupe(Long id);

}
