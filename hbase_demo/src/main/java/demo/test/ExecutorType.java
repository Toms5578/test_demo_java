package demo.test;

public enum ExecutorType {

    // Master executor services
    MASTER_CLOSE_REGION        (1),
    MASTER_OPEN_REGION         (2),
    MASTER_SERVER_OPERATIONS   (3),
    MASTER_TABLE_OPERATIONS    (4),
    MASTER_RS_SHUTDOWN         (5),
    MASTER_META_SERVER_OPERATIONS (6),
    M_LOG_REPLAY_OPS           (7),
    MASTER_SNAPSHOT_OPERATIONS (8),
    MASTER_MERGE_OPERATIONS    (9);

    ExecutorType(int i) {

    }
    /**
     * @return Conflation of the executor type and the passed {@code serverName}.
     */


    String getExecutorName(String serverName) {
        return this.toString() + "-" + serverName.replace("%", "%%");
    }


}
