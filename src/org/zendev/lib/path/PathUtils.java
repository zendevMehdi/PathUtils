package org.zendev.lib.path;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Arrays;

public class PathUtils {

    private boolean pathCheckEnable;
    private String invalidPathReplacement;

    public PathUtils(String invalidPathReplacement, boolean pathExists) {
        this.invalidPathReplacement = invalidPathReplacement;
        this.pathCheckEnable = pathExists;
    }

    private String returnPath(String checkPath, String validPath) {
        if (pathCheckEnable && !new File(checkPath).exists()) {
            return invalidPathReplacement;
        }

        return validPath;
    }

    public String getPath(String name) {
        return returnPath(name, new File(name).getAbsolutePath());
    }

    public String getName(String path) {
        return returnPath(path, new File(path).getName());
    }

    public String getBaseName(String path) {
        return returnPath(path, FilenameUtils.getBaseName(path));
    }

    public String getExtension(String path) {
        return returnPath(path, FilenameUtils.getExtension(path));
    }

    public String getParentName(String path) {
        if (Arrays.asList(File.listRoots()).contains(new File(path))) {
            return path;
        }

        return returnPath(path, FilenameUtils.getName(new File(path).getAbsoluteFile().getParentFile().getAbsolutePath()));
    }

    public String getParentPath(String path) {
        if (Arrays.asList(File.listRoots()).contains(new File(path))) {
            return path;
        }

        return returnPath(path, FilenameUtils.getFullPath(new File(path).getAbsolutePath()));
    }

    public String normalize(String path, boolean unixOS) {
        return returnPath(path, FilenameUtils.normalize(path, unixOS));
    }

    public boolean isPathCheckEnable() {
        return pathCheckEnable;
    }

    public void setPathCheckEnable(boolean pathCheckEnable) {
        this.pathCheckEnable = pathCheckEnable;
    }

    public String getInvalidPathReplacement() {
        return invalidPathReplacement;
    }

    public void setInvalidPathReplacement(String invalidPathReplacement) {
        this.invalidPathReplacement = invalidPathReplacement;
    }
}
