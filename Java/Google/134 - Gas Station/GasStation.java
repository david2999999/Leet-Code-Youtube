public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, surplus = 0, deficit = 0;

        for (int i = 0; i < gas.length; i++) {
            surplus += gas[i];

            if (surplus >= cost[i]) {
                surplus -= cost[i];
            } else {
                deficit += (cost[i] - surplus);
                start = i + 1;
                surplus = 0;
            }
        }

        return surplus >= deficit ? start : -1;
    }
}