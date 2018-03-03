package nz.co.fitnet.nameGenerator.api;

import java.util.List;
import java.util.Map;

import org.jvnet.hk2.annotations.Service;

@Service
public interface NameService {
	String generateName(Type type, String name, Map<String, String> parameters);

	List<String> nameList(Type type, String name, Map<String, String> parameters, int numOf);
}
