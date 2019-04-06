package may.springframework.recipeapp.Converters;

import may.springframework.recipeapp.DTO.NotesDto;
import may.springframework.recipeapp.model.Notes;
import may.springframework.recipeapp.model.Recipe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesToNotesDtoTest {

    private final Long ID = new Long(1L);
    private final String NOTES = "notes";
    private NotesToNotesDto converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesToNotesDto();
    }

    @Test
    public void testNull() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    public void convert() {
        //when
        Notes notes = new Notes();
        notes.setId(ID);
        notes.setRecipeNotes(NOTES);
        notes.setRecipe(new Recipe());

        //given
        NotesDto notesDto = converter.convert(notes);

        //then
        assertEquals(ID, notesDto.getId());
        assertEquals(NOTES, notesDto.getRecipeNotes());
    }
}