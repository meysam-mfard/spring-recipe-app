package may.springframework.recipeapp.Converters;

import lombok.Synchronized;
import may.springframework.recipeapp.DTO.NotesDto;
import may.springframework.recipeapp.model.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesDto implements Converter<Notes, NotesDto> {

    @Synchronized
    @Nullable
    @Override
    public NotesDto convert(Notes source) {
        if (source == null)
            return null;

        final NotesDto notesDto = new NotesDto();
        notesDto.setId(source.getId());
        notesDto.setRecipeNotes(source.getRecipeNotes());
        return notesDto;
    }
}
