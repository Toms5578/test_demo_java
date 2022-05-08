package com.atguigu.demo;

import org.apache.commons.cli.*;

import java.util.Arrays;

public class OptionsParser {
    private static final Options cliOptions = new Options();

    static {
        for (DistCpOptionSwitch option : DistCpOptionSwitch.values()) {
            cliOptions.addOption(option.getOption());
        }
    }

    private static class CustomParser extends GnuParser {
        @Override
        protected String[] flatten(Options options, String[] arguments, boolean stopAtNonOption) {
            for (int index = 0; index < arguments.length; index++) {
                if (arguments[index].equals("-" + DistCpOptionSwitch.FILTERS.getSwitch())) {
                    arguments[index] = DistCpOptionSwitch.PRESERVE_STATUS_DEFAULT;
                }
                System.out.println(arguments[index]);
            }

            return super.flatten(options, arguments, stopAtNonOption);
        }
    }

    public static CommandLine parse(String[] args)
            throws IllegalArgumentException {

        CommandLineParser parser = new CustomParser();

        CommandLine command;
        try {
            command = parser.parse(cliOptions, args, true);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Unable to parse arguments. " +
                    Arrays.toString(args), e);
        }


        return command;
    }

    public static void main(String[] args) {
        String a[] = {"-a","-b","-c"};
        CommandLine parse = parse(a);

        System.out.println(parse.getOptionValue(DistCpOptionSwitch.DIRECT_WRITE.getSwitch()));


        System.out.println(parse.hasOption(DistCpOptionSwitch.DIRECT_WRITE.getSwitch()));





    }


}

