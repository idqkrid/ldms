package org.traffic.ldms.institution;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/institution")
public class InstitutionController {
	@Autowired
	private InstitutionService institutionService;

	// 기관 등록 화면
	@GetMapping(value = "/add")
	public ModelAndView addInstiotutionForm() {
		return new ModelAndView("/institution/add");
	}

	// 기관 등록
	@PostMapping(value = "/add")
	public ModelAndView addInstiotution(Institution institution) {
		String accessKey = this.institutionService.addInstitution(institution);

		return new ModelAndView(new RedirectView("/institution/result/" + accessKey));
	}

	// 접근키 발급
	@GetMapping(value = "/result/{accessKey}")
	public ModelAndView issueAccessKey(@PathVariable String accessKey) {
		ModelAndView mav = new ModelAndView("/institution/result");
		mav.addObject("accessKey", accessKey);

		return mav;
	}

	// 기관목록 조회
	@GetMapping(value = "/list")
	public ModelAndView getInstiotution(Institution institution)
			throws Exception {
		ModelAndView mav = new ModelAndView("/institution/list");

		List<Institution> institutions = this.institutionService.getInstitutionsInfo(institution);
		mav.addObject("institutions", institutions);
		mav.addObject("keyword", institution.getName());

		return mav;
	}

	@GetMapping(value = "/validity/{id}")
	public Map<String, Object> validity(@PathVariable String id) {
		Date expirationDate = this.institutionService.setExpiration(id);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("expirationDate", expirationDate.toLocalDate());
		
		return result;
	}
}