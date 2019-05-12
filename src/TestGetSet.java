public class TestGetSet {

  private String helStr;
  private String byeStr;
  private double countDbl;
  private float randFlt;
  private boolean existBool;

  /**
   * @return the helStr
   */
  public String getHelStr() {
    return helStr;
  }

  /**
   * @param helStr the helStr to set
   */
  public void setHelStr(String helStr) {
    this.helStr = helStr;
  }

  /**
   * @return the byeStr
   */
  public String getByeStr() {
    return byeStr;
  }

  /**
   * @param byeStr the byeStr to set
   */
  public void setByeStr(String byeStr) {
    this.byeStr = byeStr;
  }

  /**
   * @return the countDbl
   */
  public double getCountDbl() {
    return countDbl;
  }

  /**
   * @param countDbl the countDbl to set
   */
  public void setCountDbl(double countDbl) {
    this.countDbl = countDbl;
  }

  /**
   * @return the randFlt
   */
  public float getRandFlt() {
    return randFlt;
  }

  /**
   * @param randFlt the randFlt to set
   */
  public void setRandFlt(float randFlt) {
    this.randFlt = randFlt;
  }

  /**
   * @return the existBool
   */
  public boolean isExistBool() {
    return existBool;
  }

  /**
   * @param existBool the existBool to set
   */
  public void setExistBool(boolean existBool) {
    this.existBool = existBool;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((byeStr == null) ? 0 : byeStr.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TestGetSet other = (TestGetSet) obj;
    if (byeStr == null) {
      if (other.byeStr != null)
        return false;
    } else if (!byeStr.equals(other.byeStr))
      return false;
    return true;
  }




}