import java.util.HashMap;
public class BundleTable {
    private HashMap<String, HashMap<Integer, Double>> tableMap;
    private static BundleTable bundleTable = new BundleTable();

    private BundleTable() {
        this.tableMap = new HashMap<>();
    }

    public static BundleTable getInstance(){
        return bundleTable;
    }

    public boolean typeIsExist(String inputType) {
        if (this.tableMap.containsKey(inputType)) {
            return true;
        } else {
            return false;
        }
    }

    public HashMap<Integer, Double> getBundleMapByType (String inputType) {
        return this.tableMap.get(inputType);
    }
    public void setBundleRecord (String setType, Integer setNum, Double setPrice) {
        HashMap<Integer,Double> bundleMapRecord = new HashMap<>();

        if (!this.typeIsExist(setType)) {
            bundleMapRecord.put(setNum,setPrice);
            this.tableMap.put(setType,bundleMapRecord);
        } else {
            getBundleMapByType(setType).put(setNum,setPrice);
        }
    }

}