package asn2pojo.runtime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.params.provider.Arguments;


public abstract class BaseSerializeTest<T> {

  private final static XmlMapper xmlMapper = new XmlMapper();
  private final static ObjectMapper jsonMapper = new ObjectMapper();
  private final Class<T> clazz;

  public BaseSerializeTest(Class<T> clazz) {
    this.clazz = clazz;
  }

  protected String toXml(T object) throws JsonProcessingException {
    String str = xmlMapper.writeValueAsString(object);
    System.out.println(str);
    return str;
  }

  protected String toJson(T object) throws JsonProcessingException {
    String str = jsonMapper.writeValueAsString(object);
    System.out.println(str);
    return str;
  }

  protected T fromXml(String xml) throws IOException {
    T object = xmlMapper.readValue(xml, clazz);
    System.out.println(object.toString());
    return object;
  }

  protected T fromJson(String json) throws IOException {
    T object = jsonMapper.readValue(json, clazz);
    System.out.println(object.toString());
    return object;
  }

  protected String loadResource(String path) {
    String str;
    try {
      str = IOUtils.resourceToString(path, StandardCharsets.UTF_8);
      //System.out.printf("Loaded resource:%n%s%n", str);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return str;
  }

  protected static List<String> listAllResourcesInDirectory(String directory) {
    List<String> resources = new ArrayList<>();
    try {
      URL dirUrl = IOUtils.resourceToURL(directory);
      File dir = new File(dirUrl.toURI());
      String[] files = dir.list();
      if (files != null) {
        for (String fileName : files) {
          String resourcePath = String.format("%s/%s", directory, fileName);
          System.out.println(resourcePath);
          resources.add(resourcePath);
        }
      }
    } catch (IOException | URISyntaxException e) {
      throw new RuntimeException(e);
    }
    return resources;
  }

  protected static Stream<Arguments> getResources(String directory) {
    List<String> resources = listAllResourcesInDirectory(directory);
    var streamBuilder = Stream.<Arguments>builder();
    resources.forEach(resource -> streamBuilder.add(Arguments.of(resource)));
    return streamBuilder.build();
  }

}