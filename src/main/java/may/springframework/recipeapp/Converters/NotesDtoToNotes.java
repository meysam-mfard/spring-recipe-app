package may.springframework.recipeapp.Converters;

import lombok.Synchronized;
import may.springframework.recipeapp.DTO.NotesDto;
import may.springframework.recipeapp.model.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesDtoToNotes implements Converter<NotesDto, Notes> {

    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesDto source) {
        if (source == null)
            return null;

        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}
