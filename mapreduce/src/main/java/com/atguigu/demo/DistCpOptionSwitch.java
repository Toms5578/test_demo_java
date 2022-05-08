package com.atguigu.demo;

import org.apache.commons.cli.Option;
import org.apache.hadoop.conf.Configuration;

public enum DistCpOptionSwitch {

    /**
     * Path containing a list of strings, which when found in the path of
     * a file to be copied excludes that file from the copy job.
     */
    FILTERS(DistCpConstants.CONF_LABEL_FILTERS_FILE,
            new Option("f", true, "The path to a file containing a list of"
                    + " strings for paths to be excluded from the copy.")),

    /**
     * Write directly to the final location, avoiding the creation and rename
     * of temporary files.
     * This is typically useful in cases where the target filesystem
     * implementation does not support atomic rename operations, such as with
     * the S3AFileSystem which translates file renames to potentially very
     * expensive copy-then-delete operations.
     */
    DIRECT_WRITE(DistCpConstants.CONF_LABEL_DIRECT_WRITE,
            new Option("b", false, "Write files directly to the"
                    + " target location, avoiding temporary file rename.")),

    /**
     * Write directly to the final location, avoiding the creation and rename
     * of temporary files.
     * This is typically useful in cases where the target filesystem
     * implementation does not support atomic rename operations, such as with
     * the S3AFileSystem which translates file renames to potentially very
     * expensive copy-then-delete operations.
     */
    A(DistCpConstants.CONF_LABEL_MAX_CHUNKS_TOLERABLE,
            new Option("a", true, "Write files directly to the"
                         + " target location, avoiding temporary file rename."));


    public static final String PRESERVE_STATUS_DEFAULT = "-prbugpct";
    private final String confLabel;
    private final Option option;

    DistCpOptionSwitch(String confLabel, Option option) {
        this.confLabel = confLabel;
        this.option = option;
    }

    DistCpOptionSwitch(String confLabel, Option option, int argNum) {
        this(confLabel, option);
        this.option.setArgs(argNum);
    }

    /**
     * Get Configuration label for the option
     *
     * @return configuration label name
     */
    public String getConfigLabel() {
        return confLabel;
    }

    /**
     * Get CLI Option corresponding to the distcp option
     *
     * @return option
     */
    public Option getOption() {
        return option;
    }

    /**
     * Get Switch symbol
     *
     * @return switch symbol char
     */
    public String getSwitch() {
        return option.getOpt();
    }

    @Override
    public String toString() {
        return super.name() + " {" +
                "confLabel='" + confLabel + '\'' +
                ", option=" + option + '}';
    }

    /**
     * Helper function to add an option to hadoop configuration object
     *
     * @param conf   - Configuration object to include the option
     * @param option - Option to add
     * @param value  - Value
     */
    public static void addToConf(Configuration conf,
                                 DistCpOptionSwitch option,
                                 String value) {
        conf.set(option.getConfigLabel(), value);
    }

    /**
     * Helper function to set an option to hadoop configuration object
     *
     * @param conf   - Configuration object to include the option
     * @param option - Option to add
     */
    public static void addToConf(Configuration conf,
                                 DistCpOptionSwitch option) {
        conf.set(option.getConfigLabel(), "true");
    }
}
