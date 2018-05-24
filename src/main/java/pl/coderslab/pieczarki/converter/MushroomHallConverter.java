package pl.coderslab.pieczarki.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.pieczarki.model.MushroomHall;
import pl.coderslab.pieczarki.repository.MushroomHallRepository;

@Component
public class MushroomHallConverter implements Converter<String, MushroomHall> {

    @Autowired
    MushroomHallRepository mushroomHallRepository;

    @Override
    public MushroomHall convert(String source) {
        long id = Long.parseLong(source);
        if(id == 0){
            return null;
        }
        MushroomHall mushroomHall = mushroomHallRepository.getOne(id);
        return mushroomHall;
    }
}
