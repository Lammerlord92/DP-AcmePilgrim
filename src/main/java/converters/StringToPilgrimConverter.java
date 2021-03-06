package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import repositories.PilgrimRepository;
import domain.Pilgrim;
@Component
@Transactional
public class StringToPilgrimConverter implements Converter<String, Pilgrim>{
	@Autowired 
	private PilgrimRepository pilgrimRepository;

	@Override
	public Pilgrim convert(String text) {
		Pilgrim result;
		int id;
		try{
			if(StringUtils.isEmpty(text))
				result=null;
			else{
				id=Integer.valueOf(text);
				result=pilgrimRepository.findOne(id);
			}
		}catch (Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		
		return result;
	}
}
