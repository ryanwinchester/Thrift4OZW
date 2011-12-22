/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package OpenZWave;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UInt32_ListByte implements org.apache.thrift.TBase<UInt32_ListByte, UInt32_ListByte._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UInt32_ListByte");

  private static final org.apache.thrift.protocol.TField RETVAL_FIELD_DESC = new org.apache.thrift.protocol.TField("retval", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField _NODE_NEIGHBORS_FIELD_DESC = new org.apache.thrift.protocol.TField("_nodeNeighbors", org.apache.thrift.protocol.TType.LIST, (short)2);

  public int retval; // required
  public List<Byte> _nodeNeighbors; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    RETVAL((short)1, "retval"),
    _NODE_NEIGHBORS((short)2, "_nodeNeighbors");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // RETVAL
          return RETVAL;
        case 2: // _NODE_NEIGHBORS
          return _NODE_NEIGHBORS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __RETVAL_ISSET_ID = 0;
  private BitSet __isset_bit_vector = new BitSet(1);

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RETVAL, new org.apache.thrift.meta_data.FieldMetaData("retval", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields._NODE_NEIGHBORS, new org.apache.thrift.meta_data.FieldMetaData("_nodeNeighbors", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UInt32_ListByte.class, metaDataMap);
  }

  public UInt32_ListByte() {
  }

  public UInt32_ListByte(
    int retval,
    List<Byte> _nodeNeighbors)
  {
    this();
    this.retval = retval;
    setRetvalIsSet(true);
    this._nodeNeighbors = _nodeNeighbors;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UInt32_ListByte(UInt32_ListByte other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.retval = other.retval;
    if (other.isSet_nodeNeighbors()) {
      List<Byte> __this___nodeNeighbors = new ArrayList<Byte>();
      for (Byte other_element : other._nodeNeighbors) {
        __this___nodeNeighbors.add(other_element);
      }
      this._nodeNeighbors = __this___nodeNeighbors;
    }
  }

  public UInt32_ListByte deepCopy() {
    return new UInt32_ListByte(this);
  }

  @Override
  public void clear() {
    setRetvalIsSet(false);
    this.retval = 0;
    this._nodeNeighbors = null;
  }

  public int getRetval() {
    return this.retval;
  }

  public UInt32_ListByte setRetval(int retval) {
    this.retval = retval;
    setRetvalIsSet(true);
    return this;
  }

  public void unsetRetval() {
    __isset_bit_vector.clear(__RETVAL_ISSET_ID);
  }

  /** Returns true if field retval is set (has been assigned a value) and false otherwise */
  public boolean isSetRetval() {
    return __isset_bit_vector.get(__RETVAL_ISSET_ID);
  }

  public void setRetvalIsSet(boolean value) {
    __isset_bit_vector.set(__RETVAL_ISSET_ID, value);
  }

  public int get_nodeNeighborsSize() {
    return (this._nodeNeighbors == null) ? 0 : this._nodeNeighbors.size();
  }

  public java.util.Iterator<Byte> get_nodeNeighborsIterator() {
    return (this._nodeNeighbors == null) ? null : this._nodeNeighbors.iterator();
  }

  public void addTo_nodeNeighbors(byte elem) {
    if (this._nodeNeighbors == null) {
      this._nodeNeighbors = new ArrayList<Byte>();
    }
    this._nodeNeighbors.add(elem);
  }

  public List<Byte> get_nodeNeighbors() {
    return this._nodeNeighbors;
  }

  public UInt32_ListByte set_nodeNeighbors(List<Byte> _nodeNeighbors) {
    this._nodeNeighbors = _nodeNeighbors;
    return this;
  }

  public void unset_nodeNeighbors() {
    this._nodeNeighbors = null;
  }

  /** Returns true if field _nodeNeighbors is set (has been assigned a value) and false otherwise */
  public boolean isSet_nodeNeighbors() {
    return this._nodeNeighbors != null;
  }

  public void set_nodeNeighborsIsSet(boolean value) {
    if (!value) {
      this._nodeNeighbors = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RETVAL:
      if (value == null) {
        unsetRetval();
      } else {
        setRetval((Integer)value);
      }
      break;

    case _NODE_NEIGHBORS:
      if (value == null) {
        unset_nodeNeighbors();
      } else {
        set_nodeNeighbors((List<Byte>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RETVAL:
      return Integer.valueOf(getRetval());

    case _NODE_NEIGHBORS:
      return get_nodeNeighbors();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RETVAL:
      return isSetRetval();
    case _NODE_NEIGHBORS:
      return isSet_nodeNeighbors();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UInt32_ListByte)
      return this.equals((UInt32_ListByte)that);
    return false;
  }

  public boolean equals(UInt32_ListByte that) {
    if (that == null)
      return false;

    boolean this_present_retval = true;
    boolean that_present_retval = true;
    if (this_present_retval || that_present_retval) {
      if (!(this_present_retval && that_present_retval))
        return false;
      if (this.retval != that.retval)
        return false;
    }

    boolean this_present__nodeNeighbors = true && this.isSet_nodeNeighbors();
    boolean that_present__nodeNeighbors = true && that.isSet_nodeNeighbors();
    if (this_present__nodeNeighbors || that_present__nodeNeighbors) {
      if (!(this_present__nodeNeighbors && that_present__nodeNeighbors))
        return false;
      if (!this._nodeNeighbors.equals(that._nodeNeighbors))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(UInt32_ListByte other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    UInt32_ListByte typedOther = (UInt32_ListByte)other;

    lastComparison = Boolean.valueOf(isSetRetval()).compareTo(typedOther.isSetRetval());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRetval()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.retval, typedOther.retval);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSet_nodeNeighbors()).compareTo(typedOther.isSet_nodeNeighbors());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSet_nodeNeighbors()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this._nodeNeighbors, typedOther._nodeNeighbors);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // RETVAL
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.retval = iprot.readI32();
            setRetvalIsSet(true);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // _NODE_NEIGHBORS
          if (field.type == org.apache.thrift.protocol.TType.LIST) {
            {
              org.apache.thrift.protocol.TList _list4 = iprot.readListBegin();
              this._nodeNeighbors = new ArrayList<Byte>(_list4.size);
              for (int _i5 = 0; _i5 < _list4.size; ++_i5)
              {
                byte _elem6; // required
                _elem6 = iprot.readByte();
                this._nodeNeighbors.add(_elem6);
              }
              iprot.readListEnd();
            }
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(RETVAL_FIELD_DESC);
    oprot.writeI32(this.retval);
    oprot.writeFieldEnd();
    if (this._nodeNeighbors != null) {
      oprot.writeFieldBegin(_NODE_NEIGHBORS_FIELD_DESC);
      {
        oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.BYTE, this._nodeNeighbors.size()));
        for (byte _iter7 : this._nodeNeighbors)
        {
          oprot.writeByte(_iter7);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("UInt32_ListByte(");
    boolean first = true;

    sb.append("retval:");
    sb.append(this.retval);
    first = false;
    if (!first) sb.append(", ");
    sb.append("_nodeNeighbors:");
    if (this._nodeNeighbors == null) {
      sb.append("null");
    } else {
      sb.append(this._nodeNeighbors);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bit_vector = new BitSet(1);
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}
