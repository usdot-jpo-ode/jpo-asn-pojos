package us.dot.its.jpo.asn.testgenerator;

import java.util.ArrayList;
import java.util.List;
import us.dot.its.jpo.asn.runtime.types.Asn1Field;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;
import us.dot.its.jpo.asn.runtime.types.Asn1Type;

public class SequenceGenerator extends RandomGenerator<Asn1Sequence> {

  public SequenceGenerator(GeneratorOptions options) {
    super(options);
  }

  @Override
  protected void populateRandom(Asn1Sequence instance) {
    List<Asn1Field> fields = AsnFieldUtil.fields(instance);
    List<Asn1Field> fieldsWithValues = new ArrayList<>();
    for (Asn1Field field : fields) {

      // Ignore fields named "regional"
      if (!regional && field.name().equals("regional")) {
        fieldsWithValues.add(field);
        continue;
      }

      // Ignore excluded PDUs
      if (excludePdus.contains(field.type())) {
        fieldsWithValues.add(field);
        continue;
      }

      // Ignore optional properties if configured to do so
      if (excludeOptional && field.optional() && !includeOptional.contains(field.name())) {
        continue;
      }

      RandomGenerator<?> fieldGen = getGeneratorForType(field.type(), options());
      if (fieldGen != null) {
        Asn1Type value = fieldGen.createRandom();
        if (value != null) {
          Asn1Field fieldWithValue =
              new Asn1Field(field.name(), value, field.optional(), field.tag(), field.type());
          fieldsWithValues.add(fieldWithValue);
        } else {
          fieldsWithValues.add(field);
        }
      } else {
        fieldsWithValues.add(field);
      }
    }
    AsnFieldUtil.setFields(instance, fieldsWithValues);
  }
}
