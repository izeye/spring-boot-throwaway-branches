package learningtest.com.fasterxml.jackson.dataformat.xml;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link XmlMapper}.
 *
 * @author Johnny Lim
 */
public class XmlMapperTests {

	private final XmlMapper xmlMapper = new XmlMapper();

	@Test
	public void writeValueAsString() {
		try {
			assertThat(this.xmlMapper.writer().writeValueAsString(getPersonMap()))
					.isEqualTo("<HashMap><firstName>Johnny</firstName><lastName>Lim</lastName><age>20</age></HashMap>");
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Test
	public void withRootName() {
		try {
			assertThat(this.xmlMapper.writer().withRootName("person").writeValueAsString(getPersonMap()))
					.isEqualTo("<person><firstName>Johnny</firstName><lastName>Lim</lastName><age>20</age></person>");
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Test
	public void writeValueAsStringWhenValueIsListOfMaps() {
		try {
			assertThat(this.xmlMapper.writer().withRootName("persons").writeValueAsString(getPersonMaps()))
					.isEqualTo("<persons><item><firstName>Johnny</firstName><lastName>Lim</lastName><age>20</age></item><item><firstName>Johnny</firstName><lastName>Lim</lastName><age>20</age></item></persons>");
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Test
	public void writeValueAsStringWhenValueIsMapHavingListOfMaps() {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("person", getPersonMaps());
			assertThat(this.xmlMapper.writer().withRootName("persons").writeValueAsString(map))
					.isEqualTo("<persons><person><firstName>Johnny</firstName><lastName>Lim</lastName><age>20</age></person><person><firstName>Johnny</firstName><lastName>Lim</lastName><age>20</age></person></persons>");
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}

	private Map<String, Object> getPersonMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("firstName", "Johnny");
		map.put("lastName", "Lim");
		map.put("age", 20);
		return map;
	}

	private List<Map<String, Object>> getPersonMaps() {
		return Arrays.asList(getPersonMap(), getPersonMap());
	}

}
