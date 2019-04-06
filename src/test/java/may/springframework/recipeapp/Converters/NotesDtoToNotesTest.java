package may.springframework.recipeapp.Converters;

import may.springframework.recipeapp.DTO.NotesDto;
import may.springframework.recipeapp.model.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesDtoToNotesTest {

    private final Long ID = new Long(1L);
    private final String NOTES = "notes";
    NotesDtoToNotes converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesDtoToNotes();
    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new NotesDto()));
    }

    @Test
    public void convert() {
        //given
        NotesDto notesDto = new NotesDto();
        notesDto.setId(ID);
        notesDto.setRecipeNotes(NOTES);

        //when
        Notes notes = converter.convert(notesDto);

        //then
        assertNotNull(notes);
        assertEquals(ID, notes.getId());
        assertEquals(NOTES, notes.getRecipeNotes());
    }
}