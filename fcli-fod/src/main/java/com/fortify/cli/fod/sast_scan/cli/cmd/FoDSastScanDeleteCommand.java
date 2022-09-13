package com.fortify.cli.fod.sast_scan.cli.cmd;

import com.fortify.cli.fod.rest.cli.cmd.AbstractFoDUnirestRunnerCommand;

import io.micronaut.core.annotation.ReflectiveAccess;
import kong.unirest.UnirestInstance;
import lombok.SneakyThrows;
import picocli.CommandLine;

@ReflectiveAccess
@CommandLine.Command(name = "delete")
public class FoDSastScanDeleteCommand extends AbstractFoDUnirestRunnerCommand {
    @SneakyThrows
    protected Void run(UnirestInstance unirest) {
        System.err.println("ERROR: Not yet implemented");
        return null;
    }
}
