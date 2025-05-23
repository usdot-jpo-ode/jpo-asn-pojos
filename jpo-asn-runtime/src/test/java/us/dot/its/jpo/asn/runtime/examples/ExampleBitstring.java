package us.dot.its.jpo.asn.runtime.examples;

import com.fasterxml.jackson.annotation.JsonCreator;
import us.dot.its.jpo.asn.runtime.types.Asn1Bitstring;

public class ExampleBitstring extends Asn1Bitstring {

  public boolean isFrom000_0to022_5degrees() {
    return get(0);
  }

  public void setFrom000_0to022_5degrees(boolean from000_0to022_5degrees) {
    set(0, from000_0to022_5degrees);
  }

  public boolean isFrom022_5to045_0degrees() {
    return get(1);
  }

  public void setFrom022_5to045_0degrees(boolean from022_5to045_0degrees) {
    set(1, from022_5to045_0degrees);
  }

  public boolean isFrom045_0to067_5degrees() {
    return get(2);
  }

  public void setFrom045_0to067_5degrees(boolean from045_0to067_5degrees) {
    set(2, from045_0to067_5degrees);
  }

  public boolean isFrom067_5to090_0degrees() {
    return get(3);
  }

  public void setFrom067_5to090_0degrees(boolean from067_5to090_0degrees) {
    set(3, from067_5to090_0degrees);
  }

  public boolean isFrom090_0to112_5degrees() {
    return get(4);
  }

  public void setFrom090_0to112_5degrees(boolean from090_0to112_5degrees) {
    set(4, from090_0to112_5degrees);
  }

  public boolean isFrom112_5to135_0degrees() {
    return get(5);
  }

  public void setFrom112_5to135_0degrees(boolean from112_5to135_0degrees) {
    set(5, from112_5to135_0degrees);
  }

  public boolean isFrom135_0to157_5degrees() {
    return get(6);
  }

  public void setFrom135_0to157_5degrees(boolean from135_0to157_5degrees) {
    set(6, from135_0to157_5degrees);
  }

  public boolean isFrom157_5to180_0degrees() {
    return get(7);
  }

  public void setFrom157_5to180_0degrees(boolean from157_5to180_0degrees) {
    set(7, from157_5to180_0degrees);
  }

  public boolean isFrom180_0to202_5degrees() {
    return get(8);
  }

  public void setFrom180_0to202_5degrees(boolean from180_0to202_5degrees) {
    set(8, from180_0to202_5degrees);
  }

  public boolean isFrom202_5to225_0degrees() {
    return get(9);
  }

  public void setFrom202_5to225_0degrees(boolean from202_5to225_0degrees) {
    set(9, from202_5to225_0degrees);
  }

  public boolean isFrom225_0to247_5degrees() {
    return get(10);
  }

  public void setFrom225_0to247_5degrees(boolean from225_0to247_5degrees) {
    set(10, from225_0to247_5degrees);
  }

  public boolean isFrom247_5to270_0degrees() {
    return get(11);
  }

  public void setFrom247_5to270_0degrees(boolean from247_5to270_0degrees) {
    set(11, from247_5to270_0degrees);
  }

  public boolean isFrom270_0to292_5degrees() {
    return get(12);
  }

  public void setFrom270_0to292_5degrees(boolean from270_0to292_5degrees) {
    set(12, from270_0to292_5degrees);
  }

  public boolean isFrom292_5to315_0degrees() {
    return get(13);
  }

  public void setFrom292_5to315_0degrees(boolean from292_5to315_0degrees) {
    set(13, from292_5to315_0degrees);
  }

  public boolean isFrom315_0to337_5degrees() {
    return get(14);
  }

  public void setFrom315_0to337_5degrees(boolean from315_0to337_5degrees) {
    set(14, from315_0to337_5degrees);
  }

  public boolean isFrom337_5to360_0degrees() {
    return get(15);
  }

  public void setFrom337_5to360_0degrees(boolean from337_5to360_0degrees) {
    set(15, from337_5to360_0degrees);
  }

  @JsonCreator
  public ExampleBitstring() {
    super(
        16,
        false,
        new String[] {
            "from000-0to022-5degrees",
            "from022-5to045-0degrees",
            "from045-0to067-5degrees",
            "from067-5to090-0degrees",
            "from090-0to112-5degrees",
            "from112-5to135-0degrees",
            "from135-0to157-5degrees",
            "from157-5to180-0degrees",
            "from180-0to202-5degrees",
            "from202-5to225-0degrees",
            "from225-0to247-5degrees",
            "from247-5to270-0degrees",
            "from270-0to292-5degrees",
            "from292-5to315-0degrees",
            "from315-0to337-5degrees",
            "from337-5to360-0degrees"
        });
  }
}

