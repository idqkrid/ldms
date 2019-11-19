 package org.traffic.ldms.institution;

import java.sql.Date;
import java.util.List;

public interface InstitutionService {
	public String addInstitution(Institution institution);
	public List<Institution> getInstitutionsInfo(Institution institution);
	public Date setExpiration(String id);
}
