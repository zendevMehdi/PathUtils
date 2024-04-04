
## Authors

- [@Mehdi Lavasani](https://github.com/zendevMehdi)


## Features

- Access file and folder paths and normalize them easily
## Installation

You can get jar from release section or create new project and add src folder to the project.
    
# PathUtils

This library helps to manage different paths of files or folders and normalize them easily, it supports both MS-Windows and UNIX operating systems.



## Usage/Examples

Access hello.txt parent folder name and base name, if it doesn't exist and path is incorrct use C:\\Users path to replace it and prevent errors.

```java
package org.zendev.lib.path;

import java.io.File;

public class App {
    public static void main(String[] args) {
        var pth = new PathUtils("C:\\Users", true);
        var filePath = "hello.txt";

        System.out.println(pth.getBaseName(filePath));
        System.out.println(pth.getPath(filePath));
        System.out.println(pth.getParentPath(filePath));
        System.out.println(pth.getParentName(filePath));
        System.out.println(new File(pth.normalize(filePath, false)).getAbsolutePath());
    }
}
```
