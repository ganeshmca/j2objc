/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.google.protobuf.ExtensionRegistry;

import protos.PrimitiveFields;
import protos.PrimitiveFieldsOrBuilder;
import protos.Primitives;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Tests for correct serialization and deserialization of all primitive field
 * types.
 */
public class PrimitivesTest extends ProtobufTest {

  public void testParseFromByteArray() throws Exception {
    ExtensionRegistry registry = ExtensionRegistry.newInstance();
    Primitives.registerAllExtensions(registry);
    PrimitiveFields msg = PrimitiveFields.parseFrom(ALL_PRIMITIVES_BYTES, registry);
    checkFields(msg);
  }

  public void testMergeFromInputStream() throws Exception {
    ExtensionRegistry registry = ExtensionRegistry.newInstance();
    Primitives.registerAllExtensions(registry);
    ByteArrayInputStream in = new ByteArrayInputStream(ALL_PRIMITIVES_BYTES);
    PrimitiveFields.Builder builder = PrimitiveFields.newBuilder().mergeFrom(in, registry);
    PrimitiveFields msg = builder.build();
    checkFields(builder);
    checkFields(msg);
  }

  public void testMergeFromOtherMessage() throws Exception {
    PrimitiveFields filledMsg = getFilledMessage();
    PrimitiveFields.Builder builder = PrimitiveFields.newBuilder();
    builder.mergeFrom(filledMsg);
    PrimitiveFields msg = builder.build();
    checkFields(builder);
    checkFields(msg);
  }

  public void testSerialization() throws Exception {
    PrimitiveFields msg = getFilledMessage();

    assertEquals(695, msg.getSerializedSize());
    byte[] bytes1 = msg.toByteArray();
    checkBytes(ALL_PRIMITIVES_BYTES, bytes1);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    msg.writeTo(out);
    byte[] bytes2 = out.toByteArray();
    checkBytes(ALL_PRIMITIVES_BYTES, bytes2);
  }

  private void checkFields(PrimitiveFieldsOrBuilder msg) {
    assertEquals(1, msg.getInt32F());
    assertEquals(2, msg.getUint32F());
    assertEquals(3, msg.getSint32F());
    assertEquals(4, msg.getFixed32F());
    assertEquals(5, msg.getSfixed32F());
    assertEquals(6, msg.getInt64F());
    assertEquals(7, msg.getUint64F());
    assertEquals(8, msg.getSint64F());
    assertEquals(9, msg.getFixed64F());
    assertEquals(10, msg.getSfixed64F());
    assertEquals(true, msg.getBoolF());
    assertEquals(11.1f, msg.getFloatF());
    assertEquals(12.2, msg.getDoubleF());
    assertEquals(101, msg.getInt32R(0));
    assertEquals(151, msg.getInt32R(1));
    assertEquals(102, msg.getUint32R(0));
    assertEquals(152, msg.getUint32R(1));
    assertEquals(103, msg.getSint32R(0));
    assertEquals(153, msg.getSint32R(1));
    assertEquals(104, msg.getFixed32R(0));
    assertEquals(154, msg.getFixed32R(1));
    assertEquals(105, msg.getSfixed32R(0));
    assertEquals(155, msg.getSfixed32R(1));
    assertEquals(106, msg.getInt64R(0));
    assertEquals(156, msg.getInt64R(1));
    assertEquals(107, msg.getUint64R(0));
    assertEquals(157, msg.getUint64R(1));
    assertEquals(108, msg.getSint64R(0));
    assertEquals(158, msg.getSint64R(1));
    assertEquals(109, msg.getFixed64R(0));
    assertEquals(159, msg.getFixed64R(1));
    assertEquals(110, msg.getSfixed64R(0));
    assertEquals(160, msg.getSfixed64R(1));
    assertEquals(true, msg.getBoolR(0));
    assertEquals(false, msg.getBoolR(1));
    assertEquals(111.11f, msg.getFloatR(0));
    assertEquals(161.51f, msg.getFloatR(1));
    assertEquals(112.12, msg.getDoubleR(0));
    assertEquals(162.52, msg.getDoubleR(1));
    assertEquals(201, msg.getInt32P(0));
    assertEquals(251, msg.getInt32P(1));
    assertEquals(202, msg.getUint32P(0));
    assertEquals(252, msg.getUint32P(1));
    assertEquals(203, msg.getSint32P(0));
    assertEquals(253, msg.getSint32P(1));
    assertEquals(204, msg.getFixed32P(0));
    assertEquals(254, msg.getFixed32P(1));
    assertEquals(205, msg.getSfixed32P(0));
    assertEquals(255, msg.getSfixed32P(1));
    assertEquals(206, msg.getInt64P(0));
    assertEquals(256, msg.getInt64P(1));
    assertEquals(207, msg.getUint64P(0));
    assertEquals(257, msg.getUint64P(1));
    assertEquals(208, msg.getSint64P(0));
    assertEquals(258, msg.getSint64P(1));
    assertEquals(209, msg.getFixed64P(0));
    assertEquals(259, msg.getFixed64P(1));
    assertEquals(210, msg.getSfixed64P(0));
    assertEquals(260, msg.getSfixed64P(1));
    assertEquals(false, msg.getBoolP(0));
    assertEquals(true, msg.getBoolP(1));
    assertEquals(211.11f, msg.getFloatP(0));
    assertEquals(261.51f, msg.getFloatP(1));
    assertEquals(212.12, msg.getDoubleP(0));
    assertEquals(262.52, msg.getDoubleP(1));
    assertEquals(51, (int) msg.getExtension(Primitives.int32Fe));
    assertEquals(52, (int) msg.getExtension(Primitives.uint32Fe));
    assertEquals(53, (int) msg.getExtension(Primitives.sint32Fe));
    assertEquals(54, (int) msg.getExtension(Primitives.fixed32Fe));
    assertEquals(55, (int) msg.getExtension(Primitives.sfixed32Fe));
    assertEquals(56, (long) msg.getExtension(Primitives.int64Fe));
    assertEquals(57, (long) msg.getExtension(Primitives.uint64Fe));
    assertEquals(58, (long) msg.getExtension(Primitives.sint64Fe));
    assertEquals(59, (long) msg.getExtension(Primitives.fixed64Fe));
    assertEquals(60, (long) msg.getExtension(Primitives.sfixed64Fe));
    assertEquals(true, (boolean) msg.getExtension(Primitives.boolFe));
    assertEquals(61.11f, msg.getExtension(Primitives.floatFe));
    assertEquals(62.12, msg.getExtension(Primitives.doubleFe));
    assertEquals(301, (int) msg.getExtension(Primitives.int32Re, 0));
    assertEquals(351, (int) msg.getExtension(Primitives.int32Re, 1));
    assertEquals(302, (int) msg.getExtension(Primitives.uint32Re, 0));
    assertEquals(352, (int) msg.getExtension(Primitives.uint32Re, 1));
    assertEquals(303, (int) msg.getExtension(Primitives.sint32Re, 0));
    assertEquals(353, (int) msg.getExtension(Primitives.sint32Re, 1));
    assertEquals(304, (int) msg.getExtension(Primitives.fixed32Re, 0));
    assertEquals(354, (int) msg.getExtension(Primitives.fixed32Re, 1));
    assertEquals(305, (int) msg.getExtension(Primitives.sfixed32Re, 0));
    assertEquals(355, (int) msg.getExtension(Primitives.sfixed32Re, 1));
    assertEquals(306, (long) msg.getExtension(Primitives.int64Re, 0));
    assertEquals(356, (long) msg.getExtension(Primitives.int64Re, 1));
    assertEquals(307, (long) msg.getExtension(Primitives.uint64Re, 0));
    assertEquals(357, (long) msg.getExtension(Primitives.uint64Re, 1));
    assertEquals(308, (long) msg.getExtension(Primitives.sint64Re, 0));
    assertEquals(358, (long) msg.getExtension(Primitives.sint64Re, 1));
    assertEquals(309, (long) msg.getExtension(Primitives.fixed64Re, 0));
    assertEquals(359, (long) msg.getExtension(Primitives.fixed64Re, 1));
    assertEquals(310, (long) msg.getExtension(Primitives.sfixed64Re, 0));
    assertEquals(360, (long) msg.getExtension(Primitives.sfixed64Re, 1));
    assertEquals(true, (boolean) msg.getExtension(Primitives.boolRe, 0));
    assertEquals(false, (boolean) msg.getExtension(Primitives.boolRe, 1));
    assertEquals(311.11f, msg.getExtension(Primitives.floatRe, 0));
    assertEquals(361.51f, msg.getExtension(Primitives.floatRe, 1));
    assertEquals(312.12, msg.getExtension(Primitives.doubleRe, 0));
    assertEquals(362.52, msg.getExtension(Primitives.doubleRe, 1));
    assertEquals(401, (int) msg.getExtension(Primitives.int32Pe, 0));
    assertEquals(451, (int) msg.getExtension(Primitives.int32Pe, 1));
    assertEquals(402, (int) msg.getExtension(Primitives.uint32Pe, 0));
    assertEquals(452, (int) msg.getExtension(Primitives.uint32Pe, 1));
    assertEquals(403, (int) msg.getExtension(Primitives.sint32Pe, 0));
    assertEquals(453, (int) msg.getExtension(Primitives.sint32Pe, 1));
    assertEquals(404, (int) msg.getExtension(Primitives.fixed32Pe, 0));
    assertEquals(454, (int) msg.getExtension(Primitives.fixed32Pe, 1));
    assertEquals(405, (int) msg.getExtension(Primitives.sfixed32Pe, 0));
    assertEquals(455, (int) msg.getExtension(Primitives.sfixed32Pe, 1));
    assertEquals(406, (long) msg.getExtension(Primitives.int64Pe, 0));
    assertEquals(456, (long) msg.getExtension(Primitives.int64Pe, 1));
    assertEquals(407, (long) msg.getExtension(Primitives.uint64Pe, 0));
    assertEquals(457, (long) msg.getExtension(Primitives.uint64Pe, 1));
    assertEquals(408, (long) msg.getExtension(Primitives.sint64Pe, 0));
    assertEquals(458, (long) msg.getExtension(Primitives.sint64Pe, 1));
    assertEquals(409, (long) msg.getExtension(Primitives.fixed64Pe, 0));
    assertEquals(459, (long) msg.getExtension(Primitives.fixed64Pe, 1));
    assertEquals(410, (long) msg.getExtension(Primitives.sfixed64Pe, 0));
    assertEquals(460, (long) msg.getExtension(Primitives.sfixed64Pe, 1));
    assertEquals(true, (boolean) msg.getExtension(Primitives.boolPe, 0));
    assertEquals(false, (boolean) msg.getExtension(Primitives.boolPe, 1));
    assertEquals(411.11f, msg.getExtension(Primitives.floatPe, 0));
    assertEquals(461.51f, msg.getExtension(Primitives.floatPe, 1));
    assertEquals(412.12, msg.getExtension(Primitives.doublePe, 0));
    assertEquals(462.52, msg.getExtension(Primitives.doublePe, 1));
  }

  private PrimitiveFields getFilledMessage() {
    return PrimitiveFields.newBuilder()
        .setInt32F(1)
        .setUint32F(2)
        .setSint32F(3)
        .setFixed32F(4)
        .setSfixed32F(5)
        .setInt64F(6)
        .setUint64F(7)
        .setSint64F(8)
        .setFixed64F(9)
        .setSfixed64F(10)
        .setBoolF(true)
        .setFloatF(11.1f)
        .setDoubleF(12.2)
        .addInt32R(101).addInt32R(151)
        .addUint32R(102).addUint32R(152)
        .addSint32R(103).addSint32R(153)
        .addFixed32R(104).addFixed32R(154)
        .addSfixed32R(105).addSfixed32R(155)
        .addInt64R(106).addInt64R(156)
        .addUint64R(107).addUint64R(157)
        .addSint64R(108).addSint64R(158)
        .addFixed64R(109).addFixed64R(159)
        .addSfixed64R(110).addSfixed64R(160)
        .addBoolR(true).addBoolR(false)
        .addFloatR(111.11f).addFloatR(161.51f)
        .addDoubleR(112.12).addDoubleR(162.52)
        .addInt32P(201).addInt32P(251)
        .addUint32P(202).addUint32P(252)
        .addSint32P(203).addSint32P(253)
        .addFixed32P(204).addFixed32P(254)
        .addSfixed32P(205).addSfixed32P(255)
        .addInt64P(206).addInt64P(256)
        .addUint64P(207).addUint64P(257)
        .addSint64P(208).addSint64P(258)
        .addFixed64P(209).addFixed64P(259)
        .addSfixed64P(210).addSfixed64P(260)
        .addBoolP(false).addBoolP(true)
        .addFloatP(211.11f).addFloatP(261.51f)
        .addDoubleP(212.12).addDoubleP(262.52)
        .setExtension(Primitives.int32Fe, 51)
        .setExtension(Primitives.uint32Fe, 52)
        .setExtension(Primitives.sint32Fe, 53)
        .setExtension(Primitives.fixed32Fe, 54)
        .setExtension(Primitives.sfixed32Fe, 55)
        .setExtension(Primitives.int64Fe, 56L)
        .setExtension(Primitives.uint64Fe, 57L)
        .setExtension(Primitives.sint64Fe, 58L)
        .setExtension(Primitives.fixed64Fe, 59L)
        .setExtension(Primitives.sfixed64Fe, 60L)
        .setExtension(Primitives.boolFe, true)
        .setExtension(Primitives.floatFe, 61.11f)
        .setExtension(Primitives.doubleFe, 62.12)
        .addExtension(Primitives.int32Re, 301).addExtension(Primitives.int32Re, 351)
        .addExtension(Primitives.uint32Re, 302).addExtension(Primitives.uint32Re, 352)
        .addExtension(Primitives.sint32Re, 303).addExtension(Primitives.sint32Re, 353)
        .addExtension(Primitives.fixed32Re, 304).addExtension(Primitives.fixed32Re, 354)
        .addExtension(Primitives.sfixed32Re, 305).addExtension(Primitives.sfixed32Re, 355)
        .addExtension(Primitives.int64Re, 306L).addExtension(Primitives.int64Re, 356L)
        .addExtension(Primitives.uint64Re, 307L).addExtension(Primitives.uint64Re, 357L)
        .addExtension(Primitives.sint64Re, 308L).addExtension(Primitives.sint64Re, 358L)
        .addExtension(Primitives.fixed64Re, 309L).addExtension(Primitives.fixed64Re, 359L)
        .addExtension(Primitives.sfixed64Re, 310L).addExtension(Primitives.sfixed64Re, 360L)
        .addExtension(Primitives.boolRe, true).addExtension(Primitives.boolRe, false)
        .addExtension(Primitives.floatRe, 311.11f).addExtension(Primitives.floatRe, 361.51f)
        .addExtension(Primitives.doubleRe, 312.12).addExtension(Primitives.doubleRe, 362.52)
        .addExtension(Primitives.int32Pe, 401).addExtension(Primitives.int32Pe, 451)
        .addExtension(Primitives.uint32Pe, 402).addExtension(Primitives.uint32Pe, 452)
        .addExtension(Primitives.sint32Pe, 403).addExtension(Primitives.sint32Pe, 453)
        .addExtension(Primitives.fixed32Pe, 404).addExtension(Primitives.fixed32Pe, 454)
        .addExtension(Primitives.sfixed32Pe, 405).addExtension(Primitives.sfixed32Pe, 455)
        .addExtension(Primitives.int64Pe, 406L).addExtension(Primitives.int64Pe, 456L)
        .addExtension(Primitives.uint64Pe, 407L).addExtension(Primitives.uint64Pe, 457L)
        .addExtension(Primitives.sint64Pe, 408L).addExtension(Primitives.sint64Pe, 458L)
        .addExtension(Primitives.fixed64Pe, 409L).addExtension(Primitives.fixed64Pe, 459L)
        .addExtension(Primitives.sfixed64Pe, 410L).addExtension(Primitives.sfixed64Pe, 460L)
        .addExtension(Primitives.boolPe, true).addExtension(Primitives.boolPe, false)
        .addExtension(Primitives.floatPe, 411.11f).addExtension(Primitives.floatPe, 461.51f)
        .addExtension(Primitives.doublePe, 412.12).addExtension(Primitives.doublePe, 462.52)
        .build();
  }

  private static final byte[] ALL_PRIMITIVES_BYTES = asBytes(new int[] {
    0x08, 0x01, 0x10, 0x02, 0x18, 0x06, 0x25, 0x04, 0x00, 0x00, 0x00, 0x2D, 0x05, 0x00, 0x00, 0x00,
    0x30, 0x06, 0x38, 0x07, 0x40, 0x10, 0x49, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x51,
    0x0A, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x58, 0x01, 0x65, 0x9A, 0x99, 0x31, 0x41, 0x69,
    0x66, 0x66, 0x66, 0x66, 0x66, 0x66, 0x28, 0x40, 0xA8, 0x01, 0x65, 0xA8, 0x01, 0x97, 0x01, 0xB0,
    0x01, 0x66, 0xB0, 0x01, 0x98, 0x01, 0xB8, 0x01, 0xCE, 0x01, 0xB8, 0x01, 0xB2, 0x02, 0xC5, 0x01,
    0x68, 0x00, 0x00, 0x00, 0xC5, 0x01, 0x9A, 0x00, 0x00, 0x00, 0xCD, 0x01, 0x69, 0x00, 0x00, 0x00,
    0xCD, 0x01, 0x9B, 0x00, 0x00, 0x00, 0xD0, 0x01, 0x6A, 0xD0, 0x01, 0x9C, 0x01, 0xD8, 0x01, 0x6B,
    0xD8, 0x01, 0x9D, 0x01, 0xE0, 0x01, 0xD8, 0x01, 0xE0, 0x01, 0xBC, 0x02, 0xE9, 0x01, 0x6D, 0x00,
    0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xE9, 0x01, 0x9F, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
    0xF1, 0x01, 0x6E, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xF1, 0x01, 0xA0, 0x00, 0x00, 0x00,
    0x00, 0x00, 0x00, 0x00, 0xF8, 0x01, 0x01, 0xF8, 0x01, 0x00, 0x85, 0x02, 0x52, 0x38, 0xDE, 0x42,
    0x85, 0x02, 0x8F, 0x82, 0x21, 0x43, 0x89, 0x02, 0x48, 0xE1, 0x7A, 0x14, 0xAE, 0x07, 0x5C, 0x40,
    0x89, 0x02, 0x71, 0x3D, 0x0A, 0xD7, 0xA3, 0x50, 0x64, 0x40, 0xCA, 0x02, 0x04, 0xC9, 0x01, 0xFB,
    0x01, 0xD2, 0x02, 0x04, 0xCA, 0x01, 0xFC, 0x01, 0xDA, 0x02, 0x04, 0x96, 0x03, 0xFA, 0x03, 0xE2,
    0x02, 0x08, 0xCC, 0x00, 0x00, 0x00, 0xFE, 0x00, 0x00, 0x00, 0xEA, 0x02, 0x08, 0xCD, 0x00, 0x00,
    0x00, 0xFF, 0x00, 0x00, 0x00, 0xF2, 0x02, 0x04, 0xCE, 0x01, 0x80, 0x02, 0xFA, 0x02, 0x04, 0xCF,
    0x01, 0x81, 0x02, 0x82, 0x03, 0x04, 0xA0, 0x03, 0x84, 0x04, 0x8A, 0x03, 0x10, 0xD1, 0x00, 0x00,
    0x00, 0x00, 0x00, 0x00, 0x00, 0x03, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x92, 0x03, 0x10,
    0xD2, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x04, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
    0x9A, 0x03, 0x02, 0x00, 0x01, 0xA2, 0x03, 0x08, 0x29, 0x1C, 0x53, 0x43, 0x48, 0xC1, 0x82, 0x43,
    0xAA, 0x03, 0x10, 0xA4, 0x70, 0x3D, 0x0A, 0xD7, 0x83, 0x6A, 0x40, 0xB8, 0x1E, 0x85, 0xEB, 0x51,
    0x68, 0x70, 0x40, 0xC8, 0x3E, 0x33, 0xD0, 0x3E, 0x34, 0xD8, 0x3E, 0x6A, 0xE5, 0x3E, 0x36, 0x00,
    0x00, 0x00, 0xED, 0x3E, 0x37, 0x00, 0x00, 0x00, 0xF0, 0x3E, 0x38, 0xF8, 0x3E, 0x39, 0x80, 0x3F,
    0x74, 0x89, 0x3F, 0x3B, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x91, 0x3F, 0x3C, 0x00, 0x00,
    0x00, 0x00, 0x00, 0x00, 0x00, 0x98, 0x3F, 0x01, 0xA5, 0x3F, 0xA4, 0x70, 0x74, 0x42, 0xA9, 0x3F,
    0x8F, 0xC2, 0xF5, 0x28, 0x5C, 0x0F, 0x4F, 0x40, 0xE8, 0x3F, 0xAD, 0x02, 0xE8, 0x3F, 0xDF, 0x02,
    0xF0, 0x3F, 0xAE, 0x02, 0xF0, 0x3F, 0xE0, 0x02, 0xF8, 0x3F, 0xDE, 0x04, 0xF8, 0x3F, 0xC2, 0x05,
    0x85, 0x40, 0x30, 0x01, 0x00, 0x00, 0x85, 0x40, 0x62, 0x01, 0x00, 0x00, 0x8D, 0x40, 0x31, 0x01,
    0x00, 0x00, 0x8D, 0x40, 0x63, 0x01, 0x00, 0x00, 0x90, 0x40, 0xB2, 0x02, 0x90, 0x40, 0xE4, 0x02,
    0x98, 0x40, 0xB3, 0x02, 0x98, 0x40, 0xE5, 0x02, 0xA0, 0x40, 0xE8, 0x04, 0xA0, 0x40, 0xCC, 0x05,
    0xA9, 0x40, 0x35, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xA9, 0x40, 0x67, 0x01, 0x00, 0x00,
    0x00, 0x00, 0x00, 0x00, 0xB1, 0x40, 0x36, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xB1, 0x40,
    0x68, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xB8, 0x40, 0x01, 0xB8, 0x40, 0x00, 0xC5, 0x40,
    0x14, 0x8E, 0x9B, 0x43, 0xC5, 0x40, 0x48, 0xC1, 0xB4, 0x43, 0xC9, 0x40, 0x52, 0xB8, 0x1E, 0x85,
    0xEB, 0x81, 0x73, 0x40, 0xC9, 0x40, 0xB8, 0x1E, 0x85, 0xEB, 0x51, 0xA8, 0x76, 0x40, 0x8A, 0x41,
    0x04, 0x91, 0x03, 0xC3, 0x03, 0x92, 0x41, 0x04, 0x92, 0x03, 0xC4, 0x03, 0x9A, 0x41, 0x04, 0xA6,
    0x06, 0x8A, 0x07, 0xA2, 0x41, 0x08, 0x94, 0x01, 0x00, 0x00, 0xC6, 0x01, 0x00, 0x00, 0xAA, 0x41,
    0x08, 0x95, 0x01, 0x00, 0x00, 0xC7, 0x01, 0x00, 0x00, 0xB2, 0x41, 0x04, 0x96, 0x03, 0xC8, 0x03,
    0xBA, 0x41, 0x04, 0x97, 0x03, 0xC9, 0x03, 0xC2, 0x41, 0x04, 0xB0, 0x06, 0x94, 0x07, 0xCA, 0x41,
    0x10, 0x99, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xCB, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00,
    0x00, 0xD2, 0x41, 0x10, 0x9A, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xCC, 0x01, 0x00, 0x00,
    0x00, 0x00, 0x00, 0x00, 0xDA, 0x41, 0x02, 0x01, 0x00, 0xE2, 0x41, 0x08, 0x14, 0x8E, 0xCD, 0x43,
    0x48, 0xC1, 0xE6, 0x43, 0xEA, 0x41, 0x10, 0x52, 0xB8, 0x1E, 0x85, 0xEB, 0xC1, 0x79, 0x40, 0xB8,
    0x1E, 0x85, 0xEB, 0x51, 0xE8, 0x7C, 0x40
  });

  public void testExtremeIntValues() throws Exception {
    checkIntValue(0, new int[] {
      0x08, 0x00, 0x10, 0x00, 0x18, 0x00, 0x25, 0x00, 0x00, 0x00, 0x00, 0x2D, 0x00, 0x00, 0x00,
      0x00, 0xC8, 0x3E, 0x00, 0xD0, 0x3E, 0x00, 0xD8, 0x3E, 0x00, 0xE5, 0x3E, 0x00, 0x00, 0x00,
      0x00, 0xED, 0x3E, 0x00, 0x00, 0x00, 0x00 });
    checkIntValue(-1, new int[] {
      0x08, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x01, 0x10, 0xFF, 0xFF, 0xFF,
      0xFF, 0x0F, 0x18, 0x01, 0x25, 0xFF, 0xFF, 0xFF, 0xFF, 0x2D, 0xFF, 0xFF, 0xFF, 0xFF, 0xC8,
      0x3E, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x01, 0xD0, 0x3E, 0xFF, 0xFF,
      0xFF, 0xFF, 0x0F, 0xD8, 0x3E, 0x01, 0xE5, 0x3E, 0xFF, 0xFF, 0xFF, 0xFF, 0xED, 0x3E, 0xFF,
      0xFF, 0xFF, 0xFF });
    checkIntValue(Integer.MAX_VALUE, new int[] {
      0x08, 0xFF, 0xFF, 0xFF, 0xFF, 0x07, 0x10, 0xFF, 0xFF, 0xFF, 0xFF, 0x07, 0x18, 0xFE, 0xFF,
      0xFF, 0xFF, 0x0F, 0x25, 0xFF, 0xFF, 0xFF, 0x7F, 0x2D, 0xFF, 0xFF, 0xFF, 0x7F, 0xC8, 0x3E,
      0xFF, 0xFF, 0xFF, 0xFF, 0x07, 0xD0, 0x3E, 0xFF, 0xFF, 0xFF, 0xFF, 0x07, 0xD8, 0x3E, 0xFE,
      0xFF, 0xFF, 0xFF, 0x0F, 0xE5, 0x3E, 0xFF, 0xFF, 0xFF, 0x7F, 0xED, 0x3E, 0xFF, 0xFF, 0xFF,
      0x7F });
    checkIntValue(Integer.MIN_VALUE, new int[] {
      0x08, 0x80, 0x80, 0x80, 0x80, 0xF8, 0xFF, 0xFF, 0xFF, 0xFF, 0x01, 0x10, 0x80, 0x80, 0x80,
      0x80, 0x08, 0x18, 0xFF, 0xFF, 0xFF, 0xFF, 0x0F, 0x25, 0x00, 0x00, 0x00, 0x80, 0x2D, 0x00,
      0x00, 0x00, 0x80, 0xC8, 0x3E, 0x80, 0x80, 0x80, 0x80, 0xF8, 0xFF, 0xFF, 0xFF, 0xFF, 0x01,
      0xD0, 0x3E, 0x80, 0x80, 0x80, 0x80, 0x08, 0xD8, 0x3E, 0xFF, 0xFF, 0xFF, 0xFF, 0x0F, 0xE5,
      0x3E, 0x00, 0x00, 0x00, 0x80, 0xED, 0x3E, 0x00, 0x00, 0x00, 0x80
    });
  }

  private void checkIntValue(int value, int[] expectedBytesAsInts) throws Exception {
    byte[] expectedBytes = asBytes(expectedBytesAsInts);
    PrimitiveFields msg = PrimitiveFields.newBuilder()
        .setInt32F(value)
        .setUint32F(value)
        .setSint32F(value)
        .setFixed32F(value)
        .setSfixed32F(value)
        .setExtension(Primitives.int32Fe, value)
        .setExtension(Primitives.uint32Fe, value)
        .setExtension(Primitives.sint32Fe, value)
        .setExtension(Primitives.fixed32Fe, value)
        .setExtension(Primitives.sfixed32Fe, value)
        .build();
    checkBytes(expectedBytes, msg.toByteArray());

    PrimitiveFields parsedMsg = PrimitiveFields.parseFrom(expectedBytes);
    assertEquals(value, parsedMsg.getInt32F());
    assertEquals(value, parsedMsg.getUint32F());
    assertEquals(value, parsedMsg.getSint32F());
    assertEquals(value, parsedMsg.getFixed32F());
    assertEquals(value, parsedMsg.getSfixed32F());
  }

  public void testExtremeLongValues() throws Exception {
    checkLongValue(0, new int[] {
      0x30, 0x00, 0x38, 0x00, 0x40, 0x00, 0x49, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
      0x51, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xF0, 0x3E, 0x00, 0xF8, 0x3E, 0x00,
      0x80, 0x3F, 0x00, 0x89, 0x3F, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x91, 0x3F,
      0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 });
    checkLongValue(-1, new int[] {
      0x30, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x01, 0x38, 0xFF, 0xFF, 0xFF,
      0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x01, 0x40, 0x01, 0x49, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
      0xFF, 0xFF, 0xFF, 0x51, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xF0, 0x3E, 0xFF,
      0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x01, 0xF8, 0x3E, 0xFF, 0xFF, 0xFF, 0xFF,
      0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x01, 0x80, 0x3F, 0x01, 0x89, 0x3F, 0xFF, 0xFF, 0xFF, 0xFF,
      0xFF, 0xFF, 0xFF, 0xFF, 0x91, 0x3F, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF });
    checkLongValue(Long.MAX_VALUE, new int[] {
      0x30, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x7F, 0x38, 0xFF, 0xFF, 0xFF, 0xFF,
      0xFF, 0xFF, 0xFF, 0xFF, 0x7F, 0x40, 0xFE, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
      0x01, 0x49, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x7F, 0x51, 0xFF, 0xFF, 0xFF, 0xFF,
      0xFF, 0xFF, 0xFF, 0x7F, 0xF0, 0x3E, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x7F,
      0xF8, 0x3E, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x7F, 0x80, 0x3F, 0xFE, 0xFF,
      0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x01, 0x89, 0x3F, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
      0xFF, 0xFF, 0x7F, 0x91, 0x3F, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x7F });
    checkLongValue(Long.MIN_VALUE, new int[] {
      0x30, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x01, 0x38, 0x80, 0x80, 0x80,
      0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x01, 0x40, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
      0xFF, 0xFF, 0x01, 0x49, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x80, 0x51, 0x00, 0x00,
      0x00, 0x00, 0x00, 0x00, 0x00, 0x80, 0xF0, 0x3E, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80,
      0x80, 0x80, 0x01, 0xF8, 0x3E, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x01,
      0x80, 0x3F, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x01, 0x89, 0x3F, 0x00,
      0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x80, 0x91, 0x3F, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
      0x00, 0x80 });
  }

  private void checkLongValue(long value, int[] expectedBytesAsInts) throws Exception {
    byte[] expectedBytes = asBytes(expectedBytesAsInts);
    PrimitiveFields msg = PrimitiveFields.newBuilder()
        .setInt64F(value)
        .setUint64F(value)
        .setSint64F(value)
        .setFixed64F(value)
        .setSfixed64F(value)
        .setExtension(Primitives.int64Fe, value)
        .setExtension(Primitives.uint64Fe, value)
        .setExtension(Primitives.sint64Fe, value)
        .setExtension(Primitives.fixed64Fe, value)
        .setExtension(Primitives.sfixed64Fe, value)
        .build();
    checkBytes(expectedBytes, msg.toByteArray());

    PrimitiveFields parsedMsg = PrimitiveFields.parseFrom(expectedBytes);
    assertEquals(value, parsedMsg.getInt64F());
    assertEquals(value, parsedMsg.getUint64F());
    assertEquals(value, parsedMsg.getSint64F());
    assertEquals(value, parsedMsg.getFixed64F());
    assertEquals(value, parsedMsg.getSfixed64F());
  }
}
