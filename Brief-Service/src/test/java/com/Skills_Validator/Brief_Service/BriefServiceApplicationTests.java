package com.Skills_Validator.Brief_Service;
import com.Skills_Validator.Brief_Service.Entities.Brief;
import com.Skills_Validator.Brief_Service.Controller.BriefController;
import com.Skills_Validator.Brief_Service.Services.BriefService;
import com.Skills_Validator.Brief_Service.Repositories.BriefRepositorie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BriefControllerTest {

	private BriefController briefController;
	private BriefService briefService;

	public static class SimpleBriefService extends BriefService {
		public SimpleBriefService() {
			super(null, null);
		}

		@Override
		public Brief create(Brief brief) {
			return brief;
		}

		@Override
		public Brief assignCompetences(Long id, java.util.List<Long> competenceIds) {
			return null;
		}
	}

	@BeforeEach
	void setUp() {
		briefService = new SimpleBriefService();
		briefController = new BriefController(briefService);
	}

	@Test
	void testCreateBrief() {
		Brief brief = new Brief(null, "Contexte test", "Outils test", "Livrable test", Arrays.asList(1L, 2L));
		Brief created = briefController.create(brief);

		assertNotNull(created);
		assertEquals("Contexte test", created.getContexte());
		assertEquals("Outils test", created.getOutils());
		assertEquals("Livrable test", created.getLivrable());
		assertEquals(2, created.getCompetenceIds().size());
		assertTrue(created.getCompetenceIds().contains(1L));
		assertTrue(created.getCompetenceIds().contains(2L));
	}
}
