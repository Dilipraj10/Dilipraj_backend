package com.excel.library.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genres {
	
	FICTION("FICTION"), NOVEL("NOVEL"), MYSTERY("MYSTERY"), NONFICTION("NONFICTION"),
	SCIENCEFICTION("SCIENCEFICTION"), NARRATIVE("NARRATIVE"), GENREFICTION("GENREFICTION"),
	HISTORICALFICTION("HISTORICALFICTION"), THRILLER("THRILLER");
	
	private final String genres;

}
